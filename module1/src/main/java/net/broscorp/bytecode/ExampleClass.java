class ExampleClass {

  public String text;
  private Double value; // was aDouble

  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
    }

    printHelloWorld(2, "suns in my sky");

    System.out.println("Hello, World!");
  }

  private static void printHelloWorld(int i, String message) {
    System.out.println(i + " " + message);
  }
}

