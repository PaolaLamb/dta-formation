package dta.chat.model.socket;

import dta.chat.history.HistoryFacade;
import dta.chat.model.ChatMessage;

public class ChatSocketProxy implements ChatSocket {

	private ChatSocket chatSocket;
	private HistoryFacade historyFacade = new HistoryFacade();

	public ChatSocketProxy(String host, int port) {
		this.chatSocket = new ChatSocketImpl(host, port);
	}

	@Override
	public void close() throws Exception {
		this.chatSocket.close();
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		historyFacade.saveMessage(msg);
		this.chatSocket.sendMessage(msg);
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		ChatMessage msg = this.chatSocket.readMessage();
		historyFacade.saveMessage(msg);
		return msg;
	}

}
