/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
