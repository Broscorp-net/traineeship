public class MyReader {

  public static void main(String[] args) {
    String input = System.console().readLine();
    MyWriter.writeToConsole(input);
  }
}
