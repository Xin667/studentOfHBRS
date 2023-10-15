package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {
    @Test
    void aPositiveTest() {
        GermanTranslator translator = new GermanTranslator();

        String value1 = translator.translateNumber(1);
        assertEquals("eins", value1);

        String value2 = translator.translateNumber(5);
        assertEquals("fünf", value2);

        String value3 = translator.translateNumber(10);
        assertEquals("zehn", value3);
    }
    @Test
    void aNegativeTest() {
        GermanTranslator translator = new GermanTranslator();

        String value1 = translator.translateNumber(0);
        assertEquals("Übersetzung der Zahl 0 nicht möglich (1.0)", value1);

        String value2 = translator.translateNumber(-2);
        assertEquals("Übersetzung der Zahl -2 nicht möglich (1.0)", value2);

        String value3 = translator.translateNumber(11);
        assertEquals("Übersetzung der Zahl 11 nicht möglich (1.0)", value3);
    }
}