package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class StringCalculator {

  public static int add(String input) {
    if (input.isEmpty()) {
      return 0;
    }
    String[] numbers = getInputNumbers(input);

    validateNegativeNumbers(numbers);

    return Arrays.stream(numbers)
        .mapToInt(Integer::parseInt)
        .filter(number -> number <= 1000)
        .sum();
  }

  private static void validateNegativeNumbers(String[] numbers) {
    List<String> negativeNumbers = Arrays.stream(numbers)
        .filter(number -> Integer.parseInt(number) < 0).toList();

    if(!negativeNumbers.isEmpty()) {
      Optional<String> allNegativeNumbers = negativeNumbers.stream().reduce((a, b) -> a + "," + b);
      throw new IllegalArgumentException("negatives not allowed: " + allNegativeNumbers.get());
    }
  }

  private static String[] getInputNumbers(String input) {
    String delimiter = ",\n";
    if (isMultiLengthCustomDelimiter(input)) {
      return getNumbersWithMultiLengthCustomDelimiter(input);
    }
    else if (isSingleLengthCustomDelimiter(input)) {
      delimiter = input.substring(2, 3);
      input = input.substring(4);
    }
    return input.split("[" + delimiter + "]");
  }

  private static boolean isMultiLengthCustomDelimiter(String input) {
    return input.startsWith("//[");
  }

  private static String[] getNumbersWithMultiLengthCustomDelimiter(String numbersString) {
    int delimiterEndIndex = numbersString.indexOf("\n");

    String[] delimiters = numbersString.substring(3, delimiterEndIndex - 1).split(Pattern.quote("]["));
    StringBuilder regex = new StringBuilder();
    for (String delimiter : delimiters) {
      regex.append(Pattern.quote(delimiter)).append("|");
    }
    regex.setLength(regex.length() - 1);

    numbersString = numbersString.substring(delimiterEndIndex + 1);
    return numbersString.split(regex.toString());
  }

  private static boolean isSingleLengthCustomDelimiter(String input) {
    return input.startsWith("//");
  }
}
