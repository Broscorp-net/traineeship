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
        String[] text = result.split("\n"); // Делим строку и заносим части в массив
        String rowThree = text[2].substring(31, text[2].length() - 1); // обрезаем третью строку со знаком препинания для сравнения с 4 и 5-й строками
        String rowFourth = text[3].substring(0, text[3].length() - 2);
        String rowFifth = text[4].substring(0, text[4].length() - 2);
        assertEquals(rowThree, rowFourth);
        assertEquals(rowThree, rowFifth);
    }
}