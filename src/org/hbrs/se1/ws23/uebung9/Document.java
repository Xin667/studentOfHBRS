package org.hbrs.se1.ws23.uebung9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dwang2s
 */
public abstract class Document {
    private int id;
    public int getter() {
        return id;
    }
    public void setter(int id) {
        this.id = id;
    }
}
