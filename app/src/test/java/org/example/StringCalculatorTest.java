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
}
