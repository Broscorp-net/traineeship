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
    public void checkPalindromeTest() {
        assertTrue(tester.checkPalindrome("топот"),
                "Method should return true when string is a palindrome");
        assertFalse(tester.checkPalindrome("топор"),
                "Method should return false when string is not a palindrome");
    }

    @Test
    public void helloWorldToHelloTest() {
        assertEquals("Hello",
                tester.helloWorldToHello("Hello World"));
    }

    @Test
    public void helloWorldRemoveAll_l_Test() {
        assertEquals("Heo Word",
                tester.helloWorldRemoveAll_l("Hello World"));
    }

    @Test
    public void helloWorldReplaceAll_o_With_q_Test() {
        assertEquals("Hellq Wqrld",
                tester.helloWorldReplaceAll_o_With_q("Hello World"));
    }

    @Test
    public void splitByWordsTest() {
        tester.splitByWords("Hello World");

        assertEquals("Hello 5\nWorld 5\n", output.toString());
    }

    @Test
    public void compileSongAboutBugsTest() {
        int c = 4;
        String song = tester.compileSongAboutBugs(10, c);
        String[] rows = song.split("\n+");

        assertEquals(3 * c, rows.length);
    }

}
