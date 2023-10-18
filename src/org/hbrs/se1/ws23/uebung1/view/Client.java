package org.hbrs.se1.ws23.uebung1.view;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws23.uebung1.control.Translator;
import org.hbrs.se1.ws23.uebung1.control.TranslatorFactory;

import java.util.ArrayList;

public class Client { //extends GermanTranslator
	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 * (auch bezeichnet als CLI, Terminal)
	 *
	 */
	private Translator translator;

	public Client(Translator translator) {
		this.translator = translator;
		//translator = translator (Selbstzuweisung)
	}

	public void setTranslator(Translator translator) {
		this.translator = translator;
	}

	void display(int zahl){
		// In dieser Methode soll die Methode translateNumber
		// mit dem übergegebenen Wert der Variable aNumber
		// aufgerufen werden.
		//
		// Strenge Implementierung gegen das Interface Translator gewuenscht!
		String result = TranslatorFactory.creatGermanTranslator().translateNumber(zahl);
		//String result = TranslatorFactory.creatEnglishTranslator().translateNumber(zahl);
		System.out.println("Das Ergebnis der Berechnung: " + zahl + "ist " + result);
	}
}
