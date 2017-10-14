package is.ru.stringcalculator;

public class StringCalculator {

  public static int Add(String input) {
    if(input == "") {
      return 0;
    }
    if(input.contains(",")) {
      String[] numbers = input.split(",");
      return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
    }
    return Integer.parseInt(input);
  }
}
