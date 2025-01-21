package org.example;

public class StringCalculator {

  public static int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    }
    return Integer.parseInt(numbers);
  }
}
