package org.hbrs.se1.ws23.uebung2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author dwang2s
 */
public class Container {
  private List<Member> myList = new ArrayList<>();
  public void addMember(Member member) throws ContainerException{
    if (myList.contains(member)){
      throw new ContainerException(member.getID());
    } else {
      myList.add(member);
    }
  }
  public String deleteMember(Integer id){
    for (int i = 0; i < myList.size(); i++) {
      if (myList.get(i).getID() == id) {
        myList.remove(i);
        return "" + id;
      }
    }
    throw new NoSuchElementException();
  }
  public void dump(){
    for (Member i : myList){
      System.out.println(i.toString());
    }
  }
  public int size(){
    return myList.size();
  }
}
