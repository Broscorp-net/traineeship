package net.broscorp.strings;

import java.util.Arrays;
import java.util.List;

public class StringApp {

  private static final String hello = "Hello World!";

  public boolean palindrome(String str) {
    List<String> list = Arrays.asList(str.split(""));
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < list.size(); i = i + 1) {
      builder.append(list.get((list.size() - 1) - i));
    }
    String string = String.valueOf(builder);
    return str.equalsIgnoreCase(string);
  }

  public String hello() {
    List<String> list = Arrays.asList(hello.split(" "));

    return list.get(0);
  }

  public String deleteL() {
    List<String> list = Arrays.asList(hello.split(" "));
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      List<String> array = Arrays.asList(list.get(i).split(""));
      for (int j = 0; j < array.size(); j++) {
        if (!array.get(j).equalsIgnoreCase("l")) {
          builder.append(array.get(j));
        }
      }
      if (i == 0) {
        builder.append(" ");
      }
    }
    return String.valueOf(builder);
  }

  public String change_O() {
    List<String> list = Arrays.asList(hello.split(" "));
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {

      List<String> array = Arrays.asList(list.get(i).split(""));

      for (int j = 0; j < array.size(); j++) {
        if (!array.get(j).equalsIgnoreCase("o")) {
          builder.append(array.get(j));
        } else {
          builder.append("q");
        }
      }
      if (i == 0) {
        builder.append(" ");
      }
    }
    return String.valueOf(builder);
  }

  public static void main(String[] args) {
    StringApp app = new StringApp();

    System.out.println(app.deleteL());
    System.out.println(app.hello());
    System.out.println(app.change_O());
    System.out.println(app.palindrome("Okazako"));
  }
}
