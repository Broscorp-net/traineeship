package net.broscorp.bytecode;

public class Bytecode {

  public static void main(String[] args) {
    int answer = getTheAnswerToTheUltimateQuestionOfLifeAndTheUniverseAndEverything();
    int entropy = 1 << 4; //aka 16
    while (entropy < answer){
      entropy++;
    }
    System.out.println("Hello world");
  }

  public static int getTheAnswerToTheUltimateQuestionOfLifeAndTheUniverseAndEverything() {
    return 42;
  }
}
