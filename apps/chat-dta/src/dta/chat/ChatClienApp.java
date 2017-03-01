package dta.chat;

import java.util.Scanner;

import dta.chat.view.console.ChatConsoleView;
import dta.chat.view.console.ViewComposite;

public class ChatClienApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ViewComposite view = new ChatConsoleView(scan);

		view.print();
		scan.close();

	}
}
