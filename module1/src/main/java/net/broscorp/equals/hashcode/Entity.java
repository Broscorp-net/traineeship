package net.broscorp.equals.hashcode;

import java.util.Objects;

public class Entity {

  private int id;
  private String name;
  private String parameter;

  /**Constructor of the Entity class.
   * @param id  id
   * @param name  name
   * @param parameter parameter
   */
  public Entity(int id, String name, String parameter) {
    this.id = id;
    this.name = name;
    this.parameter = parameter;
  }

  public Entity() {
  }

  @Override
  public String toString() {
    return "Entity{"
        + "id=" + id
        + ", name='" + name + '\''
        + ", parameter='" + parameter + '\''
        + '}';
  }

  @Override
  public final boolean  equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Entity)) {
      return false;
    }
    Entity entity = (Entity) o;
    return id == entity.id
        && Objects.equals(name, entity.name)
        && Objects.equals(parameter, entity.parameter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, parameter);
  }
}
