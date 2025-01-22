package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StringCalculator {

  public static int add(String input) {
    if (input.isEmpty()) {
      return 0;
    }

    String[] numbers = getInputNumbers(input);

    List<String> negativeNumbers = Arrays.stream(numbers)
        .filter(number -> Integer.parseInt(number) < 0).toList();

    if(!negativeNumbers.isEmpty()) {
      Optional<String> allNegativeNumbers = negativeNumbers.stream().reduce((a, b) -> a + "," + b);
      throw new IllegalArgumentException("negatives not allowed: " + allNegativeNumbers.get());
    }

    return Arrays.stream(numbers)
        .mapToInt(Integer::parseInt)
        .filter(number -> number <= 1000)
        .sum();
  }

  private static String[] getInputNumbers(String input) {
    String delimiter = ",\n";
    if (input.startsWith("//")) {
      delimiter = input.substring(2, 3);
      input = input.substring(4);
    }
    return input.split("[" + delimiter + "]");
  }
}
