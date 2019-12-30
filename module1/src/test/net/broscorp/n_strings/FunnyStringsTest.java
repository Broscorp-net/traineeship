package net.broscorp.n_strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunnyStringsTest {

    FunnyStrings fs = new FunnyStrings();

    @Test
    void testIsPalindrom() {
        assertTrue(fs.isPalindrom("Toporopot"));
    }

    @Test
    void testMagicWordHello() {
        assertEquals("Hello", fs.magicWordHello());
    }

    @Test
    void testMagicWordDelLiteral() {
        StringBuilder s = new StringBuilder();
        s.append("Heo Word!");
        StringBuilder d = fs.magicWordDelLiteral();
        assertEquals(s.toString(), d.toString());
    }

    @Test
    void testMagicWordDelLiteralO() {
        StringBuilder s = new StringBuilder();
        s.append("Hellq Wqrld!");
        StringBuilder d = fs.magicWordDelLiteralO();
        assertEquals(s.toString(), d.toString());
    }

    @Test
    void testWordAndNumber() {
        String text = "#1: Hello #letter: 5 #2: World! #letter: 6";
        assertEquals(text, fs.wordAndNumber());
    }

    @Test
    void testSong() {
        String result = fs.song(100, 2);
        String ExpResult = "";
        assertEquals(ExpResult, result);

    }
}