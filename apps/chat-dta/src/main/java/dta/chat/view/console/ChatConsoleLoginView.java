package dta.chat.view.console;

import java.util.Scanner;

public class ChatConsoleLoginView extends ViewComposite {
	private static final String AUTHENTIFICATION_TITLE = "== Authentification =="; // pas
																					// obligé
																					// vu
	// que le titre
	// reste le même
	private Scanner sc;

	public ChatConsoleLoginView(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public void print() {
		System.out.println(AUTHENTIFICATION_TITLE);
		System.out.println("Veuillez saisir votre login :");
		String login = sc.next();
		this.authController.authentificate(login);
	}

}
