package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
		assertEquals(5, Calculator.add("5"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
    	public void testMultipleNumbers(){
    		assertEquals(6, Calculator.add("1,2,3"));
    	}

	@Test
	public void testNegativeNumbers() {
		assertEquals(-6, Calculator.add("-1,-2,-3"));
	}

	@Test
	public void testEnterBetweenNumbers() {
		assertEquals(5, Calculator.add("0\n2,3"));
	}

	@Test
	public void testAddDelimiter() {
		assertEquals(5, Calculator.add("//;\n2;3"));
		assertEquals(7, Calculator.add("//kalli\n1kalli2kalli3kalli1"));
	}
}
