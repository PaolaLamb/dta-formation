package dta.chat;

import java.util.Scanner;

import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ChatConsoleView;
import dta.chat.view.console.ViewComposite;

public class ChatClientApp {
	private static final int SERVER_PORT = 1800;
	private static final String SERVER_HOST = "localhost";

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {

			ChatConversationModel model = new ChatConversationModel(SERVER_HOST, SERVER_PORT);

			ViewComposite view = new ChatConsoleView(scan);
			view.setAuthController((login) -> {
				model.setLogin(login);
			});

			model.addObserver(view);
			view.print();
			model.startListening();
			model.startWriting(scan);

		}

	}
}
