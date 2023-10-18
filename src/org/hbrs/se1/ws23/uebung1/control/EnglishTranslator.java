package org.hbrs.se1.ws23.uebung1.control;

import org.hbrs.se1.ws23.uebung1.control.Translator;

import java.util.ArrayList;

/**
 * @author dwang2s
 */
public class EnglishTranslator implements Translator {

  public String date = "Okt/2023"; // Default-Wert

  /**
   * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
   */
  public String translateNumber(int zahl) {
    return "";
  }

  /**
   * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
   */
  public void printInfo(){
    System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
  }

  /**
   * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2022"))
   * Das Datum sollte system-intern durch eine Control-Klasse gesetzt werden und nicht von externen View-Klassen
   */
  public void setDate( String date ) {
    this.date = date;
  }
}
