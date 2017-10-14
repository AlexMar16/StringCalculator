package is.ru.stringcalculator;

public class StringCalculator {

  public static int Add(String input) {
    if(input == "") {
      return 0;
    }
    if(input.contains(",")) {
      String[] numbers = input.split(",");
      return toInt(numbers[0]) + toInt(numbers[1]);
    }
    return Integer.parseInt(input);
  }

  private static int toInt(String number) {
    return Integer.parseInt(number);
  }
}
