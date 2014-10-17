package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if (text.contains("//")) {
			String delimiter = text.substring(2, text.indexOf('\n'));
			String numbers   = text.substring(text.indexOf('\n') + 1);
			return sum(splitNumbersByDelimiter(numbers, delimiter));
		}
		else if(text.contains(",") || text.contains("\n")) {
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    	return numbers.split("[,\n]");
	}

	private static String[] splitNumbersByDelimiter(String numbers, String delimiter) {
		return numbers.split(delimiter);
	}

	private static int sum(String[] numbers){
 	    	int total = 0;
        	for(String number : numbers){
		    	total += toInt(number);
		}
		return total;
    	}
}
