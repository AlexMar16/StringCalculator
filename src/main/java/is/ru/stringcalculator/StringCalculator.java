package is.ru.stringcalculator;

public class StringCalculator {

  public static int Add(String input) {
    if(input == "") {
      return 0;
    }
    if(input.contains(",")) {
      String[] numbers = input.split(",");
      return sum(numbers);
    }
    return Integer.parseInt(input);
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
