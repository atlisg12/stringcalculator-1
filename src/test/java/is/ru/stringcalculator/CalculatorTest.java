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

	@Test (expected = Exception.class)
	public void testException() throws Exception {
		assertEquals("Negatives not allowed: -1,-2,-4", Calculator.add("-1,1,-2,-4"));
	}

	@Test (expected = Exception.class)
	public void testExceptionSingleNegative() throws Exception {
		assertEquals("Negatives not allowed: -3", Calculator.add("-3"));
	}

	@Test
	public void testEnterBetweenNumbers() throws Exception {
		assertEquals(5, Calculator.add("0\n2,3"));
	}

	@Test
	public void testAddDelimiter() throws Exception {
		assertEquals(5, Calculator.add("//;\n2;3"));
	}

	@Test
	public void testAddDelimiterOfAnyLength() throws Exception {
		assertEquals(7, Calculator.add("//[kalli]\n1kalli2kalli3kalli1"));
	}

	@Test
	public void testBigNumbers() throws Exception {
		assertEquals(2, Calculator.add("2,1001"));
	}

	@Test
	public void testBigNumbersWhenAddingDelimiter() throws Exception {
		assertEquals(9, Calculator.add("//aðskilnaður\n3aðskilnaður6aðskilnaður1328aðskilnaður0aðskilnaður500005"));
	}

	@Test
	public void testAddDelimitersOfAnyLength() throws Exception {
		assertEquals(5, Calculator.add("//[***]\n1***4***0"));
	}

	@Test
	public void testAddMultipleDelimiters() throws Exception {
		assertEquals(8, Calculator.add("//[*][%][s]\n1*2%3s2"));
	}

	@Test
	public void testAddMultipleDelimitersOfAnyLength() throws Exception {
		assertEquals(9, Calculator.add("//[***][$][snilld]\n1***2$3snilld3"));
	}
}

