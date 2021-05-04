public class Bytecode {


  public static void main(String[] args) {
    Bytecode bytecode = new Bytecode();
    int i=0;
    while(i<30) {
      i++;
    }
    bytecode.sum();
    bytecode.func(44);
    System.out.println("Hello!!");
  }

  public int sum() {
    return 3+3;
  }

  public void func(int n) {
    int j = n*2;
    j++;
  }
}

