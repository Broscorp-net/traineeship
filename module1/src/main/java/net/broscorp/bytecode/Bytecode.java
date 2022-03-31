package net.broscorp.bytecode;

public class Bytecode {

  public static void main(String[] args) {
    int entropy = 1 << 4; //aka 16
    int answer = getTheAnswerToTheUltimateQuestionOfLifeAndTheUniverseAndEverything();
    do {
      entropy++;
    } while (entropy != answer);
    System.out.println("Hello world");
  }

  public static int getTheAnswerToTheUltimateQuestionOfLifeAndTheUniverseAndEverything() {
    return 42;
  }
}
