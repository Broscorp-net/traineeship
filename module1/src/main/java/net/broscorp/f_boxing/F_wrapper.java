
public class F_wrapper {
 
public  boolean equality(Integer a, Integer b) {
         return (a==b);
}

public  boolean isItIntegerObject(int a) {
  Integer b = a;
  return (b instanceof Integer);
}

public  boolean isItIntegerPrimitive(Integer e) {
  Integer k = 1000;
  int c = e;
  
          return (k==c);
}

}