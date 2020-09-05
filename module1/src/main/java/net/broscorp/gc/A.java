package net.broscorp.gc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class A {

  public static A globalInst;
  private Object diffObj;

  public Object getDiffObj() {
    return diffObj;
  }

  public void setDiffObj(Object diffObj) {
    this.diffObj = diffObj;
  }


  public void resurrect() {
    globalInst = this;
  }

  @Override
  protected void finalize() throws Throwable {
    String outStr = String.format(
        "%s %s",
        A.class.getTypeName(),
        Instant.now().toString()
    );

    System.out.println(outStr);

    Path pathToLogsFile = Paths.get("logs.txt");
    Files.write(pathToLogsFile, outStr.getBytes(), StandardOpenOption.APPEND);

    super.finalize();
  }

}
