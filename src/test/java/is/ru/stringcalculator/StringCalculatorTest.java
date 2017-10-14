package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

  @Test
  public void testEmptyString() {
    assertEquals(0, StringCalculator.Add(""));
  }

  @Test
  public void testOneNumber() {
    assertEquals(1, StringCalculator.Add("1"));
    assertEquals(2, StringCalculator.Add("2"));
  }

  @Test
  public void testTwoNumbers() {
    assertEquals(3, StringCalculator.Add("1,2"));
  }

  @Test
  public void testMultipleNumbers() {
    assertEquals(6, StringCalculator.Add("1,2,3"));
  }

  @Test
  public void testWithNewLine() {
    assertEquals(6, StringCalculator.Add("1\n2,3"));
    assertEquals(6, StringCalculator.Add("1\n2\n3"));
  }

  @Test
  public void testOneNegative() {
    try{
      StringCalculator.Add("-1");
      junit.framework.Assert.fail("Should throw IllegalArgumentException..");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Negatives not allowed: -1", e.getMessage());
    }
  }

  @Test
  public void testOneNegativeOtherThanOne() {
    try{
      StringCalculator.Add("-2");
      junit.framework.Assert.fail("Should throw IllegalArgumentException..");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Negatives not allowed: -2", e.getMessage());
    }
  }

  @Test
  public void testMultipleOnlyNegatives() {
    try{
      StringCalculator.Add("-1,-2\n-3");
      junit.framework.Assert.fail("Should throw IllegalArgumentException..");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Negatives not allowed: -1,-2,-3", e.getMessage());
    }
  }

  @Test
  public void testMultipleNotOnlyNegatives() {
    try{
      StringCalculator.Add("4,-1,2,-2\n-3");
      junit.framework.Assert.fail("Should throw IllegalArgumentException..");
    }
    catch (IllegalArgumentException e) {
      assertEquals("Negatives not allowed: -1,-2,-3", e.getMessage());
    }
  }

  @Test
  public void testNumberBiggerThan1K() {
    assertEquals(0, StringCalculator.Add("1001"));
  }

  @Test
  public void testNumbersBiggerThan1K() {
    assertEquals(3, StringCalculator.Add("1,1002,2"));
  }

  @Test
  public void testDifferentSingleCharacterDelimiter() {
    assertEquals(3, StringCalculator.Add("//;\n1;2"));
  }
}
