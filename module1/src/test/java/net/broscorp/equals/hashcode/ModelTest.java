package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModelTest {

  private List<Model> modelList;

  @BeforeEach
  void setUp() {
    modelList = new ArrayList<>();
    modelList.add(new Model(1, "y"));
    modelList.add(new Model(9, "zy"));
    modelList.add(new Model(1, "yx"));
    modelList.add(new Model(5, "xy"));
    modelList.add(new Model(4, "x"));
    modelList.add(new Model(9, "zy"));
    modelList.add(new Model(1, "y"));
    modelList.add(new Model(2, "x"));
  }

  @Test
  public void checkTwoSameObject() {
    assertTrue(modelList.get(0).hashCode() == modelList.get(6).hashCode());
    assertTrue(modelList.get(0).equals(modelList.get(6)));

  }

  @Test
  public void checkTwoOtherObject() {
    assertFalse(modelList.get(0).hashCode() == modelList.get(1).hashCode());
    assertFalse(modelList.get(0).equals(modelList.get(1)));
  }

  @Test
  public void findSameHashCode() {
    for (Model model:modelList) {
      for (Model model1:modelList) {
        boolean sameHashCode = model.hashCode() == model1.hashCode();
        boolean differentWorth = model.equals(model1);
        if (sameHashCode && !differentWorth) {
          System.out.println(model.toString() + " and " + model1
                  .toString() + " are different object wheres have same hashCode");
          System.out.println("model.hashCode() = " + model
                  .hashCode() + " and " + "model1.hashCode() = " + model1.hashCode());
          assertTrue(sameHashCode);
          assertFalse(differentWorth);
        }
      }
    }
  }

}