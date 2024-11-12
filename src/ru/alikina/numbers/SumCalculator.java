package ru.alikina.numbers;

public class SumCalculator {

    public static Double sum(String input) {
        String[] numbers = input.split("\\s+");
        Double total = 0.0;

        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                total += parseNumber(number);
            }
        }

        return total;
    }

    private static Double parseNumber(String number) {
        if (number.contains("/")) {
            String[] parts = number.split("/");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid fraction format: " + number);
            }
            String numerator = parts[0];
            String denominator = parts[1];
            return (Double.parseDouble(numerator) / Double.parseDouble(denominator)) ;
        } else {
            return Double.parseDouble(number);
        }
    }
}
