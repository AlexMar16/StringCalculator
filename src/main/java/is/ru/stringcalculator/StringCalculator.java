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
      throw new IllegalArgumentException("Negatives not allowed: -1");
    }
    return toInt(input);
  }

  private static int toInt(String number) {
    return Integer.parseInt(number);
  }

  private static int sum(String[] numbers) {
    int sum = 0;
    for(String number: numbers) {
      sum += toInt(number);
    }
    return sum;
  }
}
