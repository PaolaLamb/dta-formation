package dta.chat.model;

import java.util.Scanner;

import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatSocketImpl;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	private ChatSocketImpl socket;
	private String login;
	private boolean listening;

	public ChatConversationModel(String host, int port) {
		socket = new ChatSocketImpl(host, port);
	}

	public ChatSocketImpl getSocket() {
		return socket;
	}

	public void setSocket(ChatSocketImpl socket) {
		this.socket = socket;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		// message.setLogin(login);
		this.login = login;
		notifyObservers(new ChatMessage("Welcome", login));
	}

	public void sendMessage(String msg) {
		// message.setText(msg);
		ChatMessage message = new ChatMessage(login, msg);
		socket.sendMessage(message);
		notifyObservers(message);

	}

	public void startListening() {
		listening = true;
		Thread thread = new Thread(() -> {

			while (listening) {
				ChatMessage message = socket.readMessage();
				notifyObservers(message);
			}
		});
		thread.start();
	}

	public boolean isListening() {
		return listening;
	}

	public void setListening(boolean listening) {
		this.listening = listening;
	}

	public void startWriting(Scanner scan) {
		String msg = "cacahuète";

		while (true) {
			msg = scan.next();
			sendMessage(msg);
		}

	}

}
