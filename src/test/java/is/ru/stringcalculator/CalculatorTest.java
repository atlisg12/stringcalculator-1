package is.ru.stringcalculator;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

	public static void main(String args[]) {
      		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}

	@Test
	public void testEmptyString() throws Exception {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() throws Exception {
		assertEquals(1, Calculator.add("1"));
		assertEquals(5, Calculator.add("5"));
	}

	@Test
	public void testTwoNumbers() throws Exception {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
    	public void testMultipleNumbers() throws Exception {
    		assertEquals(6, Calculator.add("1,2,3"));
    	}

	@Rule
	public ExpectedException exc = ExpectedException.none();

	@Test
	public void testNegativeNumbersException() throws Exception {
		exc.expect(IllegalArgumentException.class);
		exc.expectMessage("Negatives not allowed: -1,-3");
		Calculator.add("-1,2,-3");
	}

	@Test
	public void testSingleNegativeException() throws Exception {
		exc.expect(IllegalArgumentException.class);
		exc.expectMessage("Negatives not allowed: -5");
		Calculator.add("-5");
	}

	@Test
	public void testEnterBetweenNumbers() throws Exception {
		assertEquals(5, Calculator.add("0\n2,3"));
	}

	@Test
	public void testAddDelimiter() throws Exception {
		assertEquals(5, Calculator.add("//;\n2;3"));
		assertEquals(7, Calculator.add("//kalli\n1kalli2kalli3kalli1"));
	}

	@Test
	public void testBigNumbers() throws Exception {
		assertEquals(2, Calculator.add("2,1001"));
	}
}

