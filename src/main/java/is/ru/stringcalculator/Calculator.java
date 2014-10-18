package is.ru.stringcalculator;

import java.util.regex.*;

public class Calculator {

	public static int add(String text) throws Exception {
		if(text.equals("")){
			return 0;
		}
		else if (text.contains("//")) {
			String delimiter = text.substring(2, text.indexOf('\n'));
			if (delimiter.substring(0,1).equals("[")) {
				delimiter = delimiter.substring(1, delimiter.length() - 1);
				if (delimiter.substring(1).contains("[")) {
					String[] delimiters = splitDelimiters(delimiter);
					String numbers      = text.substring(text.indexOf('\n') + 1);
					return sum(splitNumbersByMultipleDelimiters(numbers, delimiters));
				}
			}
			String numbers   = text.substring(text.indexOf('\n') + 1);
			return sum(splitNumbersByDelimiter(numbers, Pattern.quote(delimiter)));
		}
		else if(text.contains(",") || text.contains("\n")) {
			return sum(splitNumbers(text));
		}
		else {
			if (toInt(text) < 0)
				throw new Exception("Negatives not allowed: " + text);
			return toInt(text);
		}
	}

	private static int toInt(String number){
		if (number.equals(""))
			return 0;
		if (Integer.parseInt(number) > 1000)
			return 0;
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    	return numbers.split("[,\n]");
	}

	private static String[] splitNumbersByDelimiter(String numbers, String delimiter) {
		return numbers.split(delimiter);
	}

	private static String[] splitNumbersByMultipleDelimiters(String numbers, String[] delimiters) {
		String splitter = "";
		for (String del : delimiters) {
			if (splitter.equals(""))
				splitter += "[" + del + "]";
			else
				splitter += "|[" + del + "]";
		}
		return numbers.split(splitter);
	}

	private static String[] splitDelimiters(String delimiter) {
		return delimiter.split(Pattern.quote("]["));
	}

	private static int sum(String[] numbers) throws Exception {
 	    	int total = 0;
		String negs = "";
		boolean noNegs = true;
        	for(String number : numbers) {
			if (toInt(number) > -1)
		    		total += toInt(number);
			else {
				if (negs.equals("")) negs += number;
				else negs += "," + number;
				noNegs = false;
			}
		}
		if (!noNegs) {
			throw new Exception("Negatives not allowed: " + negs);
		}
		return total;
    	}
}
