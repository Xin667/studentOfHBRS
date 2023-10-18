package org.hbrs.se1.ws23.uebung1.view;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws23.uebung1.control.TranslatorFactory;

/**
 * @author dwang2s
 */
public class ClientNew extends GermanTranslator { //Nachteil: kann nicht zu EnglishTranslator umwandeln
  void display(int zahl){
    String result = translateNumber(zahl);
    System.out.println("Das Ergebnis der Berechnung: " + zahl + "ist " + result);
  }
}
