package org.hbrs.se1.ws23.uebung9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dwang2s
 */
class TestClient {
    private ComplexDocument complexDocument;
    @BeforeEach
    void setUp() {
        complexDocument = new ComplexDocument();
    }
    @Test
    void test() throws UnsupportedEncodingException {
        Document d1 = new Text("SE1", Text.Encoding.UTF8);
        complexDocument.addDocument(d1);
        assertEquals(3, complexDocument.getSize());

        Document d2 = new Text("WuS", Text.Encoding.UTF16);
        complexDocument.addDocument(d2);
        assertEquals(9, complexDocument.getSize());

        Document d3 = new Text("Datenbank", Text.Encoding.UTF32);
        complexDocument.addDocument(d3);
        assertEquals(45, complexDocument.getSize());

        Document g = new Grafic("localhost:8080" );
        complexDocument.addDocument(g);
        assertEquals(1245, complexDocument.getSize());
    }
}