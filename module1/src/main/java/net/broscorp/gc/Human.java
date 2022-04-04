package net.broscorp.gc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Human {
  private Integer id;

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Human with id " + id + " was finalized" );
  }
}
