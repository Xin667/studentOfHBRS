package org.hbrs.se1.ws23.uebung2;

/**
 * @author dwang2s
 */
public class ConcreteMember implements Member{
  private Integer id;
  public ConcreteMember(int id) {
    this.id = id;
  }
  @Override
  public Integer getID() {
    return id;
  }
  @Override
  public String toString() {
    return "Member (ID = " + id + ")";
  }
}
