/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {
  @Test
  void shouldReturnZeroForEmptyString() {
    assertEquals(0, StringCalculator.add(""));
  }

  @ParameterizedTest
  @CsvSource({"'0', 0", "'1', 1", "'5', 5" })
  void shouldReturnSameNumberForSingleNumberInput(final String input, final int output) {
    assertEquals(output, StringCalculator.add(input));
  }

  @ParameterizedTest
  @CsvSource({"'1,2', 3", "'2,3', 5", "'5,6', 11" })
  void shouldReturnSumForTwoNumbers(final String input, final int output) {
    assertEquals(output, StringCalculator.add(input));
  }

  @ParameterizedTest
  @CsvSource({
      "'1,2,3', 6",
      "'1,2,3,4,5', 15",
      "'1,2,3,4,5,6,7,8,9,10', 55",
      "'1,2,3,4,5,6,7,8,9,10,11,12,13,14,15', 120"
  })
  void shouldAddMultipleNumbers(final String input, final int output) {
    assertEquals(output, StringCalculator.add(input));
  }

  @Test
  void shouldAddNumbersWithNewLineAsDelimiter() {
    assertEquals(6, StringCalculator.add("1\n2,3"));
  }

  @ParameterizedTest
  @CsvSource({"'//;\n1;2', 3", "'//(\n1(2(9', 12", "'//-\n4-2-1', 7"})
  void shouldAddNumbersWithCustomDelimiter() {
    assertEquals(3, StringCalculator.add("//;\n1;2"));
  }

  @Test
  void shouldThrowExceptionForNegativeNumber() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      StringCalculator.add("-3,2");
    });
    assertEquals("negatives not allowed: -3", exception.getMessage());
  }

  @Test
  void shouldThrowExceptionForNegativeNumbersAndDsplayThemInMessage() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      StringCalculator.add("-3,2,-5,-7,1");
    });
    assertEquals("negatives not allowed: -3,-5,-7", exception.getMessage());
  }

  @Test
  void shouldIgnoreNumbersGreaterThan1000() {
    assertEquals(9, StringCalculator.add("7,1001,2"));
  }

  @Test
  void shouldAddNumbersWithCustomDelimiterOfAnyLength() {
    assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
  }

}
