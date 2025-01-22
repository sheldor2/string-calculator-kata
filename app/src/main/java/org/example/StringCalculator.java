package org.example;

import java.util.Arrays;

public class StringCalculator {

  public static int add(String input) {
    if (input.isEmpty()) {
      return 0;
    }

    String delimiter = ",\n";
    if (input.startsWith("//")) {
      delimiter = input.substring(2, 3);
      input = input.substring(4);
    }
    String[] numbers = input.split("["+ delimiter +"]");
    
    return Arrays.stream(numbers)
        .mapToInt(Integer::parseInt)
        .sum();
  }
}
