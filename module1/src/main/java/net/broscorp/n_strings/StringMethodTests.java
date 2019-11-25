import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class StringMethodTests {

    static StringMethods tester;
    protected final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    public static void initTester() {
        tester = new StringMethods();
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void whenStringIsPalindrome_thenAssertionSucceeds() {
        //setup
        String actualInputData = "топот";
        //execute
        boolean actualData = tester.checkPalindrome(actualInputData);
        //verify
        assertTrue(actualData, "Method should return true when string is a palindrome");
    }

    @Test
    public void whenStringIsNotPalindrome_thenAssertionSucceeds() {
        //setup
        String actualInputData = "топор";
        //execute
        boolean actualData = tester.checkPalindrome(actualInputData);
        //verify
        assertFalse(actualData, "Method should return false when string is not a palindrome");
    }

    @Test
    public void helloWorldToHelloTest() {
        //setup
        String expectedData = "Hello";
        String actualInputData = "Hello World";
        //execute
        String actualData = tester.helloWorldToHello(actualInputData);
        //verify
        assertEquals(expectedData, actualData);
    }

    @Test
    public void helloWorldRemoveAll_l_Test() {
        //setup
        String expectedData = "Heo Word";
        String actualInputData = "Hello World";
        //execute
        String actualData = tester.helloWorldRemoveAll_l(actualInputData);
        //verify
        assertEquals(expectedData, actualData);
    }

    @Test
    public void helloWorldReplaceAll_o_With_q_Test() {
        //setup
        String expectedData = "Hellq Wqrld";
        String actualInputData = "Hello World";
        //execute
        String actualData = tester.helloWorldReplaceAll_o_With_q(actualInputData);
        //verify
        assertEquals(expectedData, actualData);
    }

    @Test
    public void splitByWordsTest() {
        //setup
        String expectedData = "Hello 5\nWorld 5\n";
        String actualInputData = "Hello World";
        //execute
        tester.splitByWords(actualInputData);
        String actualData = output.toString();
        //verify
        assertEquals(expectedData, actualData);
    }

    @Test
    public void compileSongAboutBugs_versesCountTest() {
        int versesCount = 4;
        //setup
        int expectedData = 3 * versesCount;
        int actualInput_versesCount = versesCount;
        //execute
        String song = tester.compileSongAboutBugs(actualInput_versesCount, 10);
        String[] rows = song.split("\n+");
        int actualData = rows.length;
        //verify
        assertEquals(expectedData, actualData);
    }

    @Test
    public void compileSongAboutBugs_bugsCountTest() {
        Integer bugsCount = 10;
        //setup
        String expectedData = bugsCount.toString();
        int actualInput_bugsCount = bugsCount;
        //execute
        String song = tester.compileSongAboutBugs(4, actualInput_bugsCount);
        String actualData = song.substring(0, 2);
        //verify
        assertEquals(expectedData, actualData);
    }

}
