package is.ru.stringcalculator;

public class StringCalculator {

  public static int Add(String input) {
    if(input == "") {
      return 0;
    }
    if(input.contains(",") || input.contains("\n")) {
      return sum(getNumbers(input));
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
      return splits[1].split(getDelimiter(splits[0]));
    }
    return input.split(",|\n");
  }

  private static String getDelimiter(String input) {
    String delimiter = charToString(input,  2);
    for(int i = 0; i < input.length(); i++) {
      delimiter += "|" + charToString(input, i);
    }
    return delimiter;
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
