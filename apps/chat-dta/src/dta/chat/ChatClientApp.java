package dta.chat;

import java.util.Scanner;

import dta.chat.controller.ChatAuthController;
import dta.chat.controller.ChatAuthControllerImpl;
import dta.chat.view.console.ChatConsoleView;
import dta.chat.view.console.ViewComposite;

public class ChatClientApp {
	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {

			ViewComposite view = new ChatConsoleView(scan);

			ChatAuthController dao = new ChatAuthControllerImpl(view);
			view.setAuthController(dao);
			view.print();
		}
	}
}
