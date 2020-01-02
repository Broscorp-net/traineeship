package net.broscorp.n_strings;

import org.junit.jupiter.api.Test;

import java.text.Normalizer;
import java.util.Formatter;
import java.util.Random;

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
        int numBugs = 100;
        String result = fs.song(100, 3);
        String s = result.substring(0, 3);
        String s2 = "100";
        assertEquals(s2, s);
    }

    @Test
    void testSongCouplets() {
        int numBugs = 100;
        String result = fs.song(100, 3);
        int numCouplets = 3;
        String[] s = result.split("\n\n");
        assertEquals(numCouplets, s.length);
    }
}