package net.broscorp.primitives;

public class PrimitivesCheck {

  public byte typeOverflow(byte num) {
    return ++num;
  }

  public int longToIntConversion(long num) {
    return (int) num;
  }

  public double floatToDoubleConversion(float num) {
    return  num;
  }


  //fault when working with floating point numbers.

 public double internalBinaryRepresentationOfNumbers(double first, double second){
    return first - second;
 }


}
