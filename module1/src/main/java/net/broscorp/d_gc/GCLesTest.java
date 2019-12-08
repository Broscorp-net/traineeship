package net.broscorp.d_gc;


import static junit.framework.TestCase.assertTrue;

import org.junit.jupiter.api.Test;

class GCLesTest {
  @Test
  public void manyObj() {
    //Теряя ссылку на объект он будет сожран мусорщиком, когда в памяи не будет хватать места
    for (int i = 0; i < 100_000; i++) {
          new GCTeach();
       }
  }

  @Test
  public void relinc(){
    //после финализации если сделать объект достижимым то мусорщик все все равно его сожрет
    GCTeach gcTeach= new GCTeach();
    GCTeach1 gcTeach1 = new GCTeach1();
    gcTeach.gc1 =gcTeach1;
    gcTeach = null;
    System.gc();
    boolean b = (gcTeach1.gc == null);
    System.out.println("Обьект gcTeach1.gc = " + gcTeach1.gc);
    assert (b);
  }

  @Test
  public void cycleObj()  {
    // Если объекы ссылаются друг на друга, но доступа к этим объекам нет, то мусорщик
    // беспощадно уничтожит "любовников"
    GCTeach gcTeach= new GCTeach();
    GCTeach1 gcTeach1 = new GCTeach1();
    gcTeach1.gc = gcTeach;
    gcTeach.gc1 = gcTeach1;
    gcTeach = null;
    gcTeach1 = null;
    System.gc();
  }



}