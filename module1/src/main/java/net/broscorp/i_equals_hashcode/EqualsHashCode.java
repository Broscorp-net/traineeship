package net.broscorp.i_equals_hashcode;


public class EqualsHashCode {
  public int id;
  public String name;

  public EqualsHashCode(int id, String name) {
    this.id = id;
    this.name = name;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    EqualsHashCode other = (EqualsHashCode) obj;
    if (id != other.id)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "EqualsHashCode [id=" + id + ", name=" + name + "]";
  }
}
