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

    /**
     * Написать метод, который получает два числа - количество багов и количество куплетов и возвращает текст песни
     * <p>
     * %n little bugs in the code,
     * %n little bugs in the code.
     * Take one down, patch it around %m little bugs in the code.
     * Где m = n - 10 + random.nextInt(20)
     * <p>
     * Для следующего куплета обновляем n = m
     * <p>
     * Чтоб результаты вызова метода были повторяемы - инициализировать random произведением параметров метода.
     */

    public String songMethod(int bugsQuantity, int coupletsQuantity) {
        if (coupletsQuantity <= 0) coupletsQuantity = 1;
        String s = "";
        Random random = new Random();
        for (int i = 1; i <= coupletsQuantity; i++) {
            int m = bugsQuantity - 10 + random.nextInt(20);
            if (m < 0) m = 0;
            if (bugsQuantity < 0) bugsQuantity = 0;
            s += bugsQuantity + " little bugs in the code,\n" +
                    bugsQuantity + " little bugs in the code,\n" +
                    "Take one down, patch it around " + m + " little bugs in the code." + "\n";
            bugsQuantity = m;
        }
        return s;
    }

    public static void main(String[] args) {
        StringClass stringClass=new StringClass();
        System.out.println(stringClass.songMethod(2, 1));
    }
}
