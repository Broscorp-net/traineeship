import java.util.Random;

public class Strings {

  /**
   * Returns true if line is palindrome.
   * @param line - String line
   * @return - returns true if line is palindrome and false if it isn't
   */
  public boolean isPalindrome(String line) {
    StringBuilder builder = new StringBuilder();
    builder.append(line);
    String result = builder.reverse().toString();
    return result.equals(line);
  }

  public String returnFirstWord(String line) {
    String[] result = line.split(" ");
    return result[0];
  }

  public String removeAllLLetters(String line) {
    return line.replace("l", "");
  }

  public String replaceOToQ(String line) {
    return line.replace("o", "q");
  }

  /**
   * Prints all words from line with number of letters in each word.
   * @param line - String line
   */
  public void printWords(String line) {
    String[] words = line.split(" ");
    for (String word : words) {
      String[] letters = word.split("");
      System.out.println(word + " " + letters.length);
    }
  }

  /**
   * Returns song with bugs = bugsQuantity and couplets = coupletsQuantity.
   * @param bugsQuantity - number of bugs
   * @param coupletsQuantity - number of couplets
   * @return - song text
   */
  public String songText(int bugsQuantity, int coupletsQuantity) {

    String song = "%d little bugs in the code, \n"
        + "%d little bugs in the code. \n"
        + "Take one down, patch it around %d little bugs in the code. \n";

    Random random = new Random(bugsQuantity * coupletsQuantity);
    StringBuilder builder = new StringBuilder();

    int n = bugsQuantity;
    int m;

    for (int i = 0; i < coupletsQuantity; i++) {
      m = n - 10 + random.nextInt(20);
      builder.append(String.format(song, n, n, m));
      n = m;
    }
    return builder.toString();
  }
}
