import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTest {

	@Test
	public void byteOverflowTest() {

		short a = (short) 32767;
		short b = (short) (a+1);
		assertTrue(b<a);
	}

	@Test
	public void longToIntConversionProblemTest(){
		long number = Long.MAX_VALUE;
		System.out.println((int)number);
		assertEquals(-1,(int) number);
	}
	@Test
	public void longToIntConversionTest(){
		long number = 500000;
		System.out.println((int)number);
		assertEquals(500000,(int) number);
	}

	@Test
	public void FloatToDoubleConversionProblemTest(){
		float number = 14.1F;
		double numberB = number;
		System.out.println((double) number);

		assertNotEquals(14.1,numberB);
	}

	@Test
	public void doubleFloatDefectTest(){
		float a = 13.33f;
		double b = 13.0;
		assertNotEquals(0.33,a-b);
	}

}