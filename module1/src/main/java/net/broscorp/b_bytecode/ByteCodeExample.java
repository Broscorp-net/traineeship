public class ByteCodeExample {

  static int salary=1;
  static int prices=1;

    public static void main(String[] args) {
      increase(5);
      System.out.printf("Привет! тебе подняли зп %d раз, но и цены выросли в %d раз" + "\n", salary, prices);
      decrease(4);
      System.out.printf("Привет! тебе понизили зп в %d раз, но и цены упали в %d раз" + "\n", salary, prices);

    }

    public static void increase(int a){
      for (int i = 0; i < a; i++) {
        salary++;
        prices++;
      }
  }
  public static void decrease(int a) {
    for (int i = 0; i < a; i++) {
      salary--;
      prices--;
    }
  }

}
