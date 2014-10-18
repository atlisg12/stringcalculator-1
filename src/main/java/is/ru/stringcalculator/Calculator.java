package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) throws Exception {
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
		else {
			if (toInt(text) < 0) throw new IllegalArgumentException("Negatives not allowed: " + text);
			return toInt(text);
		}
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

	private static int sum(String[] numbers) throws Exception {
 	    	int total = 0;
		String negs = "";
		boolean noNegs = true;
        	for(String number : numbers) {
			if (toInt(number) > -1) {
		    		total += toInt(number);
			} else {
				if (negs.equals("")) negs += number;
				else negs += "," + number;
				noNegs = false;
			}
		}
		if (!noNegs) {
			throw new IllegalArgumentException("Negatives not allowed: " + negs);
		}
		return total;
    	}
}
