package org.hbrs.se1.ws23.uebung4.prototype.Controller;

import org.hbrs.se1.ws23.uebung4.prototype.Model.Container;

/**
 * @author dwang2s
 */
public class Main {
    public static void main (String[] args) throws Exception { //JVM
        // ToDo: Bewertung Exception-Handling (F3, F7)
        Container con = Container.getInstance();
        con.startEingabe();
    }
}
