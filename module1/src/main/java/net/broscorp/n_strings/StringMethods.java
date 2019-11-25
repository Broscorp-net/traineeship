import java.util.Arrays;
import java.util.Random;

public class StringMethods {

    public boolean checkPalindrome(String str) {
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public String helloWorldToHello(String helloWorld) {
        if(helloWorld != "Hello World") {
            throw new IllegalArgumentException("Argument must be \"Hello World\"");
        } else {
            return helloWorld.substring(0, 5);
        }
    }

    public String helloWorldRemoveAll_l(String helloWorld) {
        if(helloWorld != "Hello World") {
            throw new IllegalArgumentException("Argument must be \"Hello World\"");
        } else {
            return helloWorld.replaceAll("l", "");
        }
    }

    public String helloWorldReplaceAll_o_With_q(String helloWorld) {
        if(helloWorld != "Hello World") {
            throw new IllegalArgumentException("Argument must be \"Hello World\"");
        } else {
            return helloWorld.replaceAll("o", "q");
        }
    }

    public void splitByWords(String helloWorld) {
        if(helloWorld != "Hello World") {
            throw new IllegalArgumentException("Argument must be \"Hello World\"");
        } else {
            Arrays.stream(helloWorld.split(" "))
                    .forEach(word ->
                            System.out.printf("%s %d\n", word, word.length()));
        }
    }

    public String compileSongAboutBugs(int versesCount, int bugsCount) {
        Random random = new Random();
        String song = "";
        for(int i = 0; i < versesCount; i++) {
            int updatedBugsCount = bugsCount - 10 + random.nextInt(20);
            song += String.format("%d little bugs in the code, \n" +
                            "%d little bugs in the code. \n" +
                            "Take one down, patch it around %d little bugs in the code.\n\n",
                    bugsCount, bugsCount, updatedBugsCount);
            bugsCount = updatedBugsCount;
        }
        return song;
    }
}
