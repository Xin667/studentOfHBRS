package org.hbrs.se1.ws23.uebung1.control;

import java.util.ArrayList;

public class GermanTranslator implements Translator {

	public String date = "Okt/2023"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber(int zahl) {
		// [ihr Source Code aus Übung 1-2]
		java.util.List<String> numberList = new ArrayList<>(10);
		numberList.add("eins");
		numberList.add("zwei");
		numberList.add("drei");
		numberList.add("vier");
		numberList.add("fünf");
		numberList.add("sechs");
		numberList.add("sieben");
		numberList.add("acht");
		numberList.add("neun");
		numberList.add("zehn");
		//String numberArray[] = {...};
		String result = "";
		try {
			result = numberList.get(zahl - 1);
		} catch (IndexOutOfBoundsException e) {
			result = "Übersetzung der Zahl " + zahl + " nicht möglich " + "(" + version + ")";
		} finally {
			return result;
		}
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
