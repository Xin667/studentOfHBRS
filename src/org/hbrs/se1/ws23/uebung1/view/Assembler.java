package org.hbrs.se1.ws23.uebung1.view;

import org.hbrs.se1.ws23.uebung1.control.EnglishTranslator;
import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws23.uebung1.control.Translator;

/**
 * @author dwang2s
 */
public class Assembler { //Zusammenbauer
  public static void main(String[] args) {
    Translator translator = new GermanTranslator();
    Client client = new Client(translator);
    client.display(1);

    client.setTranslator(new EnglishTranslator());
    client.display(3);
  }
}
