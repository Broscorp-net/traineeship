import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class E_primitivesTest {

	
	/**
	 * In this taste case I try increment max Byte value, and failed on test execution.
	 * Reason - byte can consist only 127; 
	 */
	@Test
	void testOverflow() {
		E_primitives e_prim = new E_primitives();
		byte a = Byte.MAX_VALUE;   
		byte result = e_prim.overflow(a);   
		assertEquals(128,result); 
	}

	
	/**
	 * In this test case I try to push double, into integer. Integer has now decimal part, that means
	 * loosing of information. And as a result - test had failed.
	 */
	@Test
	void testConvertation() {
		E_primitives e_prim = new E_primitives();
		double b = 12.9999;
		 int result = e_prim.convertation(b);
		 assertEquals(b,result);
		 
	}

	
	/**
	 * This test depictured mess conduction during Java simple  arithmetical function (multiplication) 
	 * upon numbers with decimal point. We know for  sure that 2.11*5 = 10.55, but java thinking in other
	 * way. 
	 * Result - loosing of data, and fail on test. 
	 */
	@Test
	void testDeviation() {
		E_primitives e_prim = new E_primitives();
		double a = 2.11;
		double b = 5.0;
		double result = e_prim.deviation(a, b);
		assertEquals(10.55, result);
	}
}
