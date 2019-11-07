
import java.util.ArrayList;
import java.util.List;

public class B_byteCodeTwo {

  public static void main(String[] args) {
   
    String name = "My name is Volo";
    List<String> list = new ArrayList<String>();
        list.add(name);
        for(String firstName:list) {
          System.out.println(firstName);
        }

  }

}
