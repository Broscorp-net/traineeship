package net.broscorp.gc;

import lombok.Getter;
import lombok.Setter;

/**
 * Class является шаблоном для создания объекта типа Cat
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
@Getter
@Setter
public class Cat {
    private String name;
    private int age;
    String[] menu = new String[10];

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        for (int i = 0; i < menu.length; i++) {
            menu[i] = "MENU_" + i;
        }
    }

    @Override
    public String toString() {
        return "Cat name=" + name + " age=" + age;
    }

    @Override
    public void finalize() {
        System.out.println("GC START IN CAT");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
