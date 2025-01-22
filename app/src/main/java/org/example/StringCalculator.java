package org.example;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculator {

  public static int add(String input) {
    if (input.isEmpty()) {
      return 0;
    }

    String[] numbers = getInputNumbers(input);

    Optional<String> negativeNumber = Arrays.stream(numbers)
        .filter(number -> Integer.parseInt(number) < 0).findAny();

    if(negativeNumber.isPresent()) {
      throw new IllegalArgumentException("negatives not allowed: " + negativeNumber.get());
    }

    return Arrays.stream(numbers)
        .mapToInt(Integer::parseInt)
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
