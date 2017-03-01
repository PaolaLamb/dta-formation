package dta.chat.view.console;

import java.util.Scanner;

public class ChatConsoleLoginView extends ViewComposite {
	private String authentification = "== Authentification =="; // pas obligé vu
																// que le titre
																// reste le même
	private Scanner sc;

	public ChatConsoleLoginView(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public void print() {
		System.out.println(authentification);
		System.out.println("Veuillez saisir votre login :");
		String saisie = sc.next();
		System.out.println("la saisie est  " + saisie);

	}

}
