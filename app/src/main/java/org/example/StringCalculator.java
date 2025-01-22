package org.example;

import java.util.Arrays;

public class StringCalculator {

  public static int add(String input) {
    if (input.isEmpty()) {
      return 0;
    }
    String[] numbers = input.split("[,\n]");
    
    return Arrays.stream(numbers)
        .mapToInt(Integer::parseInt)
        .sum();
  }
}
