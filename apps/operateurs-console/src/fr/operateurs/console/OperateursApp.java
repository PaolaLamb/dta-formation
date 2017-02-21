package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {

	public static void main(String[] args) {
		System.out.println("***** Application Opérateurs *****") ;
		Scanner scan = new Scanner(System.in) ;
		
		System.out.println("Veuillez saisir le premier nombre...") ;
		int premier = scan.nextInt() ;
		
		System.out.println("Veuillez saisir le second nombre...") ;
		int second = scan.nextInt() ;
		
		System.out.println(premier + " + " + second + " = " + (premier+second));
		System.out.println(premier + " - " + second + " = " + (premier-second));
		System.out.println(premier + " x " + second + " = " + (premier*second));
		System.out.println(premier + " / " + second + " = " + (premier/second));
		System.out.println(premier + " % " + second + " = " + (premier%second));

	}

}
