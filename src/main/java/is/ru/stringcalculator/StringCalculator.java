package is.ru.stringcalculator;

public class StringCalculator {

  public static int Add(String input) {
    if(input == "") {
      return 0;
    }
    if(input.contains(",") || input.contains("\n")) {
      String[] numbers = input.split(",|\n");
      return sum(numbers);
    }
    int number = toInt(input);
    if(number < 0) {
      throw new IllegalArgumentException("Negatives not allowed: " + number);
    }
    return toInt(input);
  }

  private static int toInt(String number) {
    return Integer.parseInt(number);
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
