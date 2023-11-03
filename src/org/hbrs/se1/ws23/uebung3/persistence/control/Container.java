package org.hbrs.se1.ws23.uebung3.persistence.control;

import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung3.persistence.interfaces.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.interfaces.PersistenceStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author dwang2s
 */
public class Container {
  private static final Container instance = new Container();
  private static List<Member> myList = new ArrayList<>(); //oder durch privaten Konstruktor instanziieren
  private PersistenceStrategy<Member> myPersistenceStrategy = null;

  public static Container getInstance(){
/*    if (instance == null) {
      instance = new Container();
      return instance;
    }*/
    //muss nicht, denn instance schon final und instanziiert ist
    return instance;
  }
  public List<Member> getCurrentList() {
    return myList;
  }
  public void setPersistenceStrategy(PersistenceStrategy<Member> myPersistenceStrategy) {
    this.myPersistenceStrategy = myPersistenceStrategy;
  }
  public int size(){
    return myList.size();
  }
  public void store() throws PersistenceException {
    myPersistenceStrategy.save(myList);
  }
  public void load() throws PersistenceException {
    myList = myPersistenceStrategy.load();
  }
  public void addMember(Member member) throws ContainerException {
    if (myList.contains(member)){
      throw new ContainerException(member.getID());
    } else {
      myList.add(member);
    }
  }
  public String deleteMember(Integer id){
    for (int i = 0; i < myList.size(); i++) {
      if (myList.get(i).getID().equals(id)) {
        myList.remove(i);
        return "" + id;
      }
    }
    throw new NoSuchElementException();
  }
}
