package net.broscorp.strings;

import java.util.Arrays;
import java.util.Random;

public class StringOperations {

    public boolean isPalindrome(String text) {
        return text.replaceAll(" ","")
                .equalsIgnoreCase(new StringBuilder(text.replaceAll(" ",""))
                        .reverse().toString());
    }

    public String saveFirstWordInText(String text) {
        String[] array = text.split(" ");
        return array[0];
    }

    public String removeLetterL(String text) {
        return text.replaceAll("l", "");
    }

    public String changeSomeLetters(String text, String changedLetter, String newLetter) {
        return text.replaceAll(changedLetter, newLetter);
    }

    public String wordStatistic(String text) {
        StringBuilder sb = new StringBuilder();

        Arrays.asList(text.split(" ")).forEach(s -> sb.append(s).append(" -> ").append(s.length()).append("\n"));

        return sb.toString();
    }

    public String getSong(int bugs, int couplets) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random((long) bugs * couplets);
        int m;

        for (int i = 0; i < couplets; i++) {
            m = bugs - 10 + random.nextInt(20);
            sb.append(bugs).append(" little bugs in the code,\n");
            sb.append(bugs).append(" little bugs in the code.\n");
            sb.append("Take one down, patch it around ").append(m).append(" little bugs in the code.\n");
            bugs = m;
        }
        return sb.toString();
    }
}
