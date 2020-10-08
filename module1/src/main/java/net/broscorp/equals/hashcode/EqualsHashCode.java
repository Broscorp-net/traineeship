package net.broscorp.equals.hashcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EqualsHashCode {


  private String s1;
  private String s2;
  private String s3;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EqualsHashCode)) {
      return false;
    }

    EqualsHashCode that = (EqualsHashCode) o;

    return  this.s1 == that.s1 && this.s2 == that.s2 && this.s3 == that.s3;
  }

  protected EqualsHashCode(String s1, String s2, String s3) {
    this.s1 = s1;
    this.s2 = s2;
    this.s3 = s3;
  }

  @Override
  public int hashCode() {
    int result = 31 * s1.length() + 31 * s2.length() + 31 * s3.length();
    return result;
  }

  @Override
  public String toString() {
    return "EqualsHashCode{"
            +
            "s1='" + s1 + '\''
            +
            ", s2='" + s2 + '\''
            +
            ", s3='" + s3 + '\''
            +
            '}';
  }
}
