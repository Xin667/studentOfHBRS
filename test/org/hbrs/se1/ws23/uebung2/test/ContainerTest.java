package org.hbrs.se1.ws23.uebung2.test;

import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dwang2s
 */
class ContainerTest {
  @Test
  void aTest() throws ContainerException {
    Container myContainer = new Container();
    Member m1 = new ConcreteMember(1);
    Member m2 = new ConcreteMember(2);

    //Test
    //1
    assertEquals(0,myContainer.size());
    //2
    myContainer.addMember(m1);
    myContainer.dump();
    //3
    assertThrows(ContainerException.class, () -> myContainer.addMember(m1));
    //4
    myContainer.addMember(m2);
    myContainer.dump();
    //5
    assertEquals(2,myContainer.size());
    //6
    assertEquals("1",myContainer.deleteMember(1));
    //7
    assertThrows(NoSuchElementException.class, () -> myContainer.deleteMember(1));
    //8
    assertEquals(1,myContainer.size());
    myContainer.dump();
    //9
    assertEquals("2",myContainer.deleteMember(2));
    myContainer.dump();
    //10
    assertEquals(0,myContainer.size());
  }
}
