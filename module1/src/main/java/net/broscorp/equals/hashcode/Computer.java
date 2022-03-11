package net.broscorp.equals.hashcode;

public class Computer {

  private String serialNumber;
  private String cpu;
  private String graphics;
  private int ram;
  private int storage;

  /**
   * Class computer that represents a business model of computer.
   */

  public Computer(String serialNumber, String cpu, String graphics, int ram, int storage) {
    this.serialNumber = serialNumber;
    this.cpu = cpu;
    this.graphics = graphics;
    this.ram = ram;
    this.storage = storage;
  }

  public Computer() {
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public String getCpu() {
    return cpu;
  }

  public void setCpu(String cpu) {
    this.cpu = cpu;
  }

  public String getGraphics() {
    return graphics;
  }

  public void setGraphics(String graphics) {
    this.graphics = graphics;
  }

  public int getRam() {
    return ram;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public int getStorage() {
    return storage;
  }

  public void setStorage(int storage) {
    this.storage = storage;
  }

  @Override
  public int hashCode() {
    return serialNumber.hashCode() + cpu.hashCode() + graphics.hashCode();
  }

  @Override
  public String toString() {
    return "{\"serialNumber\" : \"" + serialNumber + "\","
        + " \"cpu\" : \"" + cpu + "\","
        + "\"graphics\" : \"" + graphics + "\", "
        + "\"ram\": " + ram + ","
        + " \"storage\": " + storage + " }";
  }

  @Override
  public boolean equals(Object o) {

    if (getClass() != o.getClass()) {
      return false;
    }

    Computer computer = (Computer) o;

    if (this.serialNumber != computer.getSerialNumber()) {
      return false;
    }

    if (this.cpu != computer.getCpu()) {
      return false;
    }

    if (this.graphics != computer.getGraphics()) {
      return false;
    }

    if (this.ram != computer.getRam()) {
      return false;
    }

    if (this.storage != computer.getStorage()) {
      return false;
    }

    return true;
  }

}
