package dta.chat.view.console;

import java.util.Scanner;

public class ChatConsoleView extends ViewComposite {

	public ChatConsoleView(Scanner sc) {
		ChatConsoleTitleView title = new ChatConsoleTitleView();
		this.add(title);

		ChatConsoleLoginView login = new ChatConsoleLoginView(sc);
		this.add(login);

		ChatConsoleConversationView conversation = new ChatConsoleConversationView();
		this.add(conversation);

	}

}
