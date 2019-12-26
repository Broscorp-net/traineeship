package net.broscorp.n_strings;

import java.util.Random;

class FunnyStrings {
    private String word = "Hello World!";

    boolean isPalindrom(String something) {
        StringBuilder reverse = new StringBuilder();
        for (int i = something.length() - 1; i >= 0; i--) {
            reverse.append(something.charAt(i));
        }
        return reverse.toString().equalsIgnoreCase(something);
    }

    String magicWordHello() {
        String[] wordHello = word.split(" ");
        return wordHello[0];
    }

    StringBuilder magicWordDelLiteral() {
        char ch = 'l';
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (ch != word.charAt(i)) {
                wordBuilder.append(word.charAt(i));
            }
        }
        return wordBuilder;
    }

    StringBuilder magicWordDelLiteralO() {
        char ch = 'o';
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (ch != word.charAt(i)) {
                wordBuilder.append(word.charAt(i));
            } else {
                wordBuilder.append('q');
            }
        }
        return wordBuilder;
    }

    String wordAndNumber() {
        String[] wordHello = word.split(" ");
        String one = "#1: " + wordHello[0] + " #letter: " + wordHello[0].length();
        String two = " #2: " + wordHello[1] + " #letter: " + wordHello[1].length();
        return one + two;
    }

    String song(int numBugs, int numCouplets) {
        Random random = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = numCouplets; i > 0; i--) {
            int m = numBugs - 10 + random.nextInt(20);
            s.append(numBugs).append(" little bugs in the code, \n")
                    .append(numBugs).append(" little bugs in the code. \n")
                    .append("Take one down, patch it around ").append(m).append(" little bugs in the code." + "\n");
            numBugs = m;
        }
        return s.toString();
    }
}
