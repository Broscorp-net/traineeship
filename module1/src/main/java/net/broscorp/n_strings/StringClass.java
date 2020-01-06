package net.broscorp.n_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringClass {

    public boolean isAWordAPalindrome(String s) {//Написать метод, который определяет, является ли слово палиндромом
        StringBuilder stringBuilder = new StringBuilder(s);
        if (!s.equalsIgnoreCase(String.valueOf(stringBuilder.reverse()))) return false;
        else return true;
    }

    public String helloMethodCut() {//Оставляет только слово Hello
        return "Hello World".substring(0, 5);
    }

    public String lSymbolDeletingMethod() {//Удаляет все буквы "l" в строке
        return "Hello World".replace("l", "");
    }

    public String replaceOToQMethod() {//Меняет все буквы "о" на букву "q"
        return "Hello World".replace("o", "q");
    }

    public String[] listOfWordsMethod(String s) {//Выводит список слов
        String[] words = s.split("\\W+");
        return words;
    }

    public List<Character> listOfLettersMethod(String s) {//Выводит количество букв в соответствующем слове.
        List<Character> characterList = new ArrayList<>();
        for (Character character : s.toCharArray()) {
            characterList.add(character);
        }
        return characterList;
    }

    public String songMethod(int bugsQuantity, int coupletsQuantity) {
        Random random = new Random(bugsQuantity * coupletsQuantity);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= coupletsQuantity; i++) {
            int m = bugsQuantity - 10 + random.nextInt(20);
            stringBuilder.append(String.format("%d little bugs in the code, \n"
                    + "%d little bugs in the code. \n " +
                    "Take one down, patch it around %d little bugs in the code.\n", bugsQuantity, bugsQuantity, m));
            bugsQuantity = m;
        }
        return stringBuilder.toString();
    }

}

