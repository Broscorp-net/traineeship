package net.broscorp.gc;

public class Developer2 {

  private TestObject testObject;

  Developer2(TestObject testObject) {
    this.testObject = testObject;
  }

  //    @Override
  //    protected void finalize() throws Throwable {
  //      System.out.println("This is finalize method");
  //      testObject.developer2 = this;
  //    }
}
