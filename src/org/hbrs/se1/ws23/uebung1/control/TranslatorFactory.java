package org.hbrs.se1.ws23.uebung1.control;
public class
/**
 * @author dwang2s
 * Anwendung des Factory Method Pattern (Kapitel 6;[GoF])
 * Problem: Inkonsistente Objekt-Erzeugung und -Parametrisierung
 * Lösung: Service-Klasse für die zentrale und konsistente Erzeugung
 */
TranslatorFactory {
    public static Translator creatGermanTranslator(){
        return new GermanTranslator();
    }
}
