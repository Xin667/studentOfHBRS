package org.hbrs.se1.ws23.uebung3.persistence.view;

import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung3.persistence.control.Container;
import org.hbrs.se1.ws23.uebung3.persistence.interfaces.PersistenceStrategy;

/**
 * @author dwang2s
 */
public class Main {
    public static void setStrategy(Container myContainer, PersistenceStrategy<Member> persistenceStrategy){
        myContainer.setPersistenceStrategy(persistenceStrategy);
    }
}