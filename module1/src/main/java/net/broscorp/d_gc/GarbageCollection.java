
public class GarbageCollection {

  public static void main(String[] args) {
    
showGarbageCollection();
  }
  @Override
  protected void finalize() {
    System.out.println("Finalize has been called");
  }
public static void showGarbageCollection() {
  for (int i = 1; i<=100; i++) {
    GarbageCollection gc = new GarbageCollection();
    System.out.println(gc.hashCode()+" number "+i);
    gc = null;
  }
  System.gc();
}
}
