package org.hbrs.se1.ws23.uebung9;

/**
 * @author dwang2s
 */
public class Text extends CoreDocument{
    private String inhalt;
    private Encoding encode;
    enum Encoding {
        UTF8,UTF32,UTF16;
    }

    public Text(String inhalt, Encoding encode) {
        this.inhalt = inhalt;
        this.encode = encode;
    }

    public String getInhalt() {
        return inhalt;
    }

    public Encoding getEncode() {
        return encode;
    }
}
