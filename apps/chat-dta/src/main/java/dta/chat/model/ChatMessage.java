package dta.chat.model;

import java.io.Serializable;

public class ChatMessage implements Serializable {

	public static final String FORMAT_SEPARATOR = "###";
	private static final long serialVersionUID = 12L;
	private String login;
	private String text;

	public ChatMessage() {
	}

	public ChatMessage(String login, String text) {
		this.login = login;
		this.text = text;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLogin() {
		return login;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "ChatMessage [login=" + login + ", text=" + text + "]";
	}

	public String formater() {
		return login + FORMAT_SEPARATOR + text + "\n";
	}

}
