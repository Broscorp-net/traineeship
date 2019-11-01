package net.broscorp.h_generics;

import java.util.function.Function;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MyCoolList {

  public void add(Object o){
    throw new NotImplementedException();
  }

  public Object get(int index){
    throw new NotImplementedException();
  }

  public Object remove(int index){
    throw new NotImplementedException();
  }

  public Object map(Function f){
    throw new NotImplementedException();
  }

}
