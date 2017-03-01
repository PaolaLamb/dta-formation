package dta.chat.view.console;

public class ChatConsoleConversationView extends ViewComposite {
	private String conversation = "== Conversation ==";

	public ChatConsoleConversationView() {
	}

	@Override
	public void print() {
		System.out.println(conversation);
	}

}
