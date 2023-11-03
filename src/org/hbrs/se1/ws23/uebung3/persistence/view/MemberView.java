package org.hbrs.se1.ws23.uebung3.persistence.view;

import org.hbrs.se1.ws23.uebung2.Member;

import java.util.List;

/**
 * @author dwang2s
 */
public class MemberView {
    public static void dump(List<Member> mylist){
        for (Member i : mylist){
            System.out.println(i.toString());
        }
    }
}
