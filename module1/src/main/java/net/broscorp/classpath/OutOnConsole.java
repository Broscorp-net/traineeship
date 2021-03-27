package net.broscorp.classpath;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class OutOnConsole {

  OutOnConsole(String message) {
    System.out.println(message);
    try {
      new Robot().keyPress(KeyEvent.VK_ENTER);
    } catch (AWTException e) {
      e.printStackTrace();
    }
  }
}
