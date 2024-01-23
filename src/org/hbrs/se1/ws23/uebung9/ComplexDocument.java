package org.hbrs.se1.ws23.uebung9;

import java.io.UnsupportedEncodingException;
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
    public int getSize() throws UnsupportedEncodingException {
        int size = 0;
        for(Document i : list) {
            if (i instanceof Text) {
                if (((Text) i).getEncode() == Text.Encoding.UTF8) {
                    size += ((Text) i).getInhalt().getBytes("UTF-8").length;
                }
                if (((Text) i).getEncode() == Text.Encoding.UTF16) {
                    size += ((Text) i).getInhalt().getBytes("UTF-16").length;
                }
                if (((Text) i).getEncode() == Text.Encoding.UTF32) {
                    size += ((Text) i).getInhalt().getBytes("UTF-32").length;
                }
            }
            if (i instanceof Grafic) {
                size += 1200;
            }
        }
        return size;
    }
}
