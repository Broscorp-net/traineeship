package net.broscorp.i_equals_hashcode;


public class Equals_HashCode {
  public int id;
  public String name;

  public Equals_HashCode(int id, String name) {
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
    Equals_HashCode other = (Equals_HashCode) obj;
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
    return "Equals_HashCode [id=" + id + ", name=" + name + "]";
  }
}
