package net.broscorp.equals.hashcode;

import java.util.Objects;

public class EqualsHashCode {

  private int id;
  private String name;
  private String subname;

  public EqualsHashCode(int i, String name, String subname) {

  }

  public EqualsHashCode(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSubname() {
    return subname;
  }

  public void setSubname(String subname) {
    this.subname = subname;
  }

  @Override
  public String toString() {
    return "EqualsHashCode{" + "id=" + id + ","
        + " name='" + name + '\'' + ","
        + " subname='" + subname + '\''
        + '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, subname);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    EqualsHashCode other = (EqualsHashCode) obj;

    return id == other.id && name == other.name;
  }

}
