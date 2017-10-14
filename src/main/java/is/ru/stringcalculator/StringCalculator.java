package is.ru.stringcalculator;

public class StringCalculator {

  public static int Add(String input) {
    if(input == "") {
      return 0;
    }
    if(input.contains(",") || input.contains("\n")) {
			String[] numbers;
			numbers = getNumbers(input);
      return sum(numbers);
    }
    int number = toInt(input);
    if(number < 0) {
      throw new IllegalArgumentException("Negatives not allowed: " + number);
    }
    return number;
  }

	private static String[] getNumbers(String input) {
		if(input.contains("//")) {
			String[] splits = input.split("\n");
			String onlyNumbers;
			if(splits.length > 2) {
				onlyNumbers = fixNumbers(splits);
			}
			else {
				onlyNumbers = splits[1];
			}
			String delimiter = charToString(splits[0],2);
			for(int i = 3; i < splits[0].length(); i++) {
				delimiter += charToString(splits[0], i);
			}
			return onlyNumbers.split(delimiter + "|,|\n");
		}
		return input.split(",|\n");
	}

	private static String fixNumbers(String[] splits) {
		String fixed = splits[1];
		for(int i = 2; i < splits.length; i++) {
			fixed += "\n" + splits[i];
		}
		return fixed;
	}

	private static String charToString(String input, int index) {
		return Character.toString(input.charAt(index));
	}

  private static int toInt(String strNumber) {
    int number =  Integer.parseInt(strNumber);
    if(number > 1000) {
      number = 0;
    }
    return number;
  }

  private static int sum(String[] numbers) {
    int sum = 0;
    String[] negatives = new String[numbers.length];
    int index = 0;
    for(String number: numbers) {
      sum += toInt(number);
      if(number.contains("-")) {
        negatives[index] = number;
        index++;
      }
    }
    if(index > 0) {
      throwNegatives(negatives, index);
    }
    return sum;
  }

  private static void throwNegatives(String[] negatives, int index) {
    String message = "Negatives not allowed: ";
    for(int i = 0; i < index - 1; i++) {
      message += negatives[i] + ",";
    }
    message += negatives[index - 1];
    throw new IllegalArgumentException(message);
  }
}
