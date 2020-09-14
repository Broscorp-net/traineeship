package net.broscorp.boxing.valuerf;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.valueref.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

  @Test
  public void testFooWithListExcectedTrue() {

    Foo foo = new Foo();

    List<String> list = new ArrayList<>();

    int listSizeBeforeCallMethod = list.size();

    Assertions.assertTrue(listSizeBeforeCallMethod == 0);

    foo.foo(1, list);

    int listSizeAfterCallMethod = list.size();

    Assertions.assertTrue(listSizeAfterCallMethod > 0);
    Assertions.assertTrue(listSizeAfterCallMethod == 1);
  }
  /*
  * ������������ void ������� � junit �������� �������������, �� ������ � �� �����, 
  * ��� ��� ����� ������ �� ��������� �� ����� ��������� ������ ��� ������ �� ����������, 
  * ������� �� ��������� � ����� ���������, �� ��� ��� ���� �� ���������� ����� ����������� ���, 
  * �� �� ��������� ��������� �� ����� ��� ��� ��� �������� �� ������ ��������� ����� � ������� ��� �������� ���� �����,
  * �������� ������� � ��������� ������ ��������� � ��������� ����������.
  */
  
  @Test
  public void testFooWithDigitAndListExcectedTrue() {

    Foo foo = new Foo();

    List<String> list = new ArrayList<>();
    int number = 14;

    int listSizeBeforeCallMethod = list.size();

    Assertions.assertTrue(listSizeBeforeCallMethod == 0);

    foo.foo(number, list);

    int listSizeAfterCallMethod = list.size();

    Assertions.assertTrue(listSizeAfterCallMethod > 0);
    Assertions.assertTrue(listSizeAfterCallMethod == 1);
    
    Assertions.assertTrue(number == 14);
  }
  
  /*
   * ������ ���� ����������, ���������� number �� ����������, 
   * ���� ����� foo ��������� � ��� 15, ��� ����������� ���� ���������.
   */
}
