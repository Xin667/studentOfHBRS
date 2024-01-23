package org.hbrs.se1.ws23.uebung9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dwang2s
 */
public class ComplexDocument extends Document{
    private List<Document> list;
    public ComplexDocument() {
        list = new ArrayList<>();
    }
    public void addDocument(Document d) {
        list.add(d);
    }
    public void removeDocument(Document d) {
        list.remove(d);
    }
    public int getSize() {
        int size = 0;
        for(Document i : list) {
            if (i instanceof Text) {
                if (((Text) i).getEncode() == Text.Encoding.UTF8) {
                    size += ((Text) i).getInhalt().length();
                }
                if (((Text) i).getEncode() == Text.Encoding.UTF16) {
                    size += ((Text) i).getInhalt().length() * 2;
                }
                if (((Text) i).getEncode() == Text.Encoding.UTF32) {
                    size += ((Text) i).getInhalt().length() * 4;
                }
            }
            if (i instanceof Grafic) {
                size += 1200;
            }
        }
        return size;
    }
}
