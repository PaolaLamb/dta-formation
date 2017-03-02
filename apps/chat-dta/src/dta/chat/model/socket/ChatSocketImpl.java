package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.model.ChatMessage;

public class ChatSocketImpl implements ChatSocket {

	private ClientSocket clientSocket;

	public ChatSocketImpl(String host, int port) {

		try {
			this.clientSocket = new ClientSocket(host, port);
		} catch (IOException e) {
			throw new ChatClientException(e);
		}
	}

	@Override
	public void close() throws Exception {
		this.clientSocket.close();
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		try {
			this.clientSocket.sendObject(msg);
		} catch (IOException e) {
			throw new ChatClientException(e);
		}
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		try {
			return (ChatMessage) this.clientSocket.readObject();
		} catch (ClassNotFoundException e) {
			throw new ChatClientException(e);
		} catch (IOException e) {
			throw new ChatClientException(e);
		}
	}
}
