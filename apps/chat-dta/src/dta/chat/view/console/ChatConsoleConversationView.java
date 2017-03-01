package dta.chat.view.console;

public class ChatConsoleConversationView extends ViewComposite {
	private static final String CONVERSATION_TITLE = "== Conversation ==";

	public ChatConsoleConversationView() {
	}

	@Override
	public void print() {
		System.out.println(CONVERSATION_TITLE);
	}

}
