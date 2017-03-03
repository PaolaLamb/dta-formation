package dta.chat.view.console;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;

public class ChatConsoleConversationView extends ViewComposite {
	private static final String CONVERSATION_TITLE = "== Conversation ==";

	public ChatConsoleConversationView() {
	}

	@Override
	public void print() {
		System.out.println(CONVERSATION_TITLE);
		// System.out.println("Welcome " + user);
	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		System.out.println(obj.getLogin() + " : " + obj.getText());
	}

}
