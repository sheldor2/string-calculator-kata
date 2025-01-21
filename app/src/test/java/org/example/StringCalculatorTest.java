/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
  @Test
  void shouldReturnZeroForEmptyString() {
    assertEquals(0, StringCalculator.add(""));
  }

  @Test
  void shouldReturnOneForInputStringOne() {
    assertEquals(1, StringCalculator.add("1"));
  }

  @Test
  void shouldReturnTwoForInputStringTwo() {
    assertEquals(2, StringCalculator.add("2"));
  }
}
