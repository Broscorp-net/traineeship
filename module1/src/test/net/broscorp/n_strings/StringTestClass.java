package net.broscorp.n_strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StringTestClass {
    StringClass stringClass = new StringClass();

    @Test
    void theWordIsAPalindromeTest() {
        assertTrue(stringClass.isAWordAPalindrome("dad"));
    }

    @Test
    void theWordIsNotAPalindromeTest() {
        assertFalse(stringClass.isAWordAPalindrome("doc"));
    }

    @Test
    void helloMethodCutTest() {
        assertEquals("Hello", stringClass.helloMethodCut());
    }

    @Test
    void helloMethodNotCutTest() {
        assertNotEquals("Hello World", stringClass.helloMethodCut());
    }

    @Test
    void lSymbolDeletingMethodTest() {
        assertEquals("Heo Word", stringClass.lSymbolDeletingMethod());
    }

    @Test
    void lSymbolNotDeletingMethodTest() {
        assertNotEquals("Hello World", stringClass.lSymbolDeletingMethod());
    }

    @Test
    void replaceOToQMethodTest() {
        assertEquals("Hellq Wqrld", stringClass.replaceOToQMethod());
    }

    @Test
    void notReplaceOToQMethodTest() {
        assertNotEquals("Hello World", stringClass.replaceOToQMethod());
    }

    @Test
    void listOfWordsMethodTest() {
        String[] array = {"Hello", "World"};
        assertEquals(array.length, stringClass.listOfWordsMethod("Hello World").length);
    }


    @Test
    void listOfLettersMethod() {
        List<Character> stringList = Arrays.asList('a', 'b', 'c', 'd');
        assertEquals(stringList, stringClass.listOfLettersMethod("abcd"));
    }

    @Test
    void songTestMethod() {
        String s = "2 little bugs in the code, \n" +
                "2 little bugs in the code. \n" +
                " Take one down, patch it around -6 little bugs in the code.\n" +
                "-6 little bugs in the code, \n" +
                "-6 little bugs in the code. \n" +
                " Take one down, patch it around -4 little bugs in the code.\n";
        assertEquals(s, stringClass.songMethod(2, 2));
    }

}
