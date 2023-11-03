package org.hbrs.se1.ws23.uebung3.persistence.test;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung3.persistence.control.Container;
import org.hbrs.se1.ws23.uebung3.persistence.interfaces.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.interfaces.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung3.persistence.interfaces.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws23.uebung3.persistence.interfaces.PersistenceStrategyStream;
import org.hbrs.se1.ws23.uebung3.persistence.view.Main;
import org.hbrs.se1.ws23.uebung3.persistence.view.MemberView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dwang2s
 */
class ContainerTest{
    private Container myContainer;
    @BeforeEach
    void setUp() throws ContainerException{
        myContainer = Container.getInstance();
        myContainer.addMember(new ConcreteMember(1));
    }
    @Test
    void testPSNull() throws ContainerException, PersistenceException {
        //wenn PS leer ist, trotzdem möchte man die Liste von Container speichern/laden
        //Warum durch Main?
        Main.setStrategy(myContainer, null);

        assertThrows(NullPointerException.class, () -> myContainer.store());
        assertThrows(NullPointerException.class, () -> myContainer.load());
    }

    @Test
    void testPSMongoDB() throws ContainerException, PersistenceException{
        Main.setStrategy(myContainer, new PersistenceStrategyMongoDB<>());

        assertThrows(UnsupportedOperationException.class, () -> myContainer.store());
        assertThrows(UnsupportedOperationException.class, () -> myContainer.load());
    }
    @Test
    public void testPSStream() throws ContainerException, PersistenceException{
        PersistenceStrategyStream<Member> psS = new PersistenceStrategyStream<>();
        Main.setStrategy(myContainer, psS);

        //Member extends Serializable

        // In Java ist das Interface "Serializable" ein Marker-Interface,
        // das in der Java-API definiert ist. Ein Marker-Interface ist ein Interface,
        // das keine Methoden oder Felder enthält, sondern nur als Markierung dient,
        // um einer Klasse oder einem Objekt eine bestimmte Eigenschaft zuzuweisen.
        // Das "Serializable"-Interface wird verwendet, um anzuzeigen,
        // dass eine Klasse oder ein Objekt in einen Byte-Stream
        // serialisiert und deserialisiert werden kann.
        // also in Datei speichern oder durch Internet transpotieren

        //location ist jetzt nur "objects.ser"
        myContainer.store();
        myContainer.load();
        //MemberView.dump(myContainer.getCurrentList());

        psS.setLocation("/Users/wangdongxin/Desktop/objects.ser");
        myContainer.store();
        myContainer.load();

        psS.setLocation("C:/Pfad/Zum/Verzeichnis"); //URL nicht existiert
        assertThrows(PersistenceException.class, () -> myContainer.store());
        assertThrows(PersistenceException.class, () -> myContainer.load());

/*        psS.setLocation("snetnbw45vtw34"); //warum das geht?
        myContainer.store();
        myContainer.load();*/
    }
    @Test
    void testRoundTrip() throws ContainerException, PersistenceException{
        Main.setStrategy(myContainer, new PersistenceStrategyStream<>());

        myContainer.addMember(new ConcreteMember(2));
        assertEquals(2, myContainer.size());
        myContainer.addMember(new ConcreteMember(3));
        myContainer.addMember(new ConcreteMember(4));
        myContainer.store(); //Der Container erhältet 4 Members, dann gespeichert

        assertEquals(4, myContainer.size());
        myContainer.deleteMember(1);
        assertEquals(3, myContainer.size());
        myContainer.deleteMember(2);
        myContainer.deleteMember(3);
        assertEquals(1, myContainer.size());//viel geändert aber nicht gespeichert

        myContainer.load();//"Der Container" wird geladet
        assertEquals(4, myContainer.size());

        //String expected = StreamUtils.convertInputStreamToString(expectedInputStream);
    }
}