package org.hbrs.se1.ws23.uebung3.persistence.view;

import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung3.persistence.control.Container;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author dwang2s
 */
public class Client { //extends GermanTranslator
    /*
     * Methode zur Ausgabe einer Zahl auf der Console
     * (auch bezeichnet als CLI, Terminal)
     *
     */
    private Container myContainer = Container.getInstance();
    private List<Member> myList = myContainer.getCurrentList();

    public void addMember(Member member) throws ContainerException {
        myContainer.addMember(member);
    }
    public String deleteMember(Integer id){
        return myContainer.deleteMember(id);
    }
    public void dump(){
        MemberView.dump(myList);
    }
}
