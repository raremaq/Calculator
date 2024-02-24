import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws ArithmeticException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число операцию число");
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }


    public static String calc(String input) {
        String[] numbers = input.split(" ");
        if (numbers.length != 3) {
            throw new IllegalArgumentException("Неверный формат выражения.");
        }

        boolean isRoman1;
        boolean isRoman2;
        int num1, num2;

        try {
            num1 = Integer.parseInt(numbers[0]);
            isRoman1 = false;
        } catch (NumberFormatException e) {
            num1 = romToArab(numbers[0]);
            isRoman1 = true;
        }

        try {
            num2 = Integer.parseInt(numbers[2]);
            isRoman2 = false;
        } catch (NumberFormatException e) {
            num2 = romToArab(numbers[2]);
            isRoman2 = true;
        }

        if (isRoman1 && isRoman2) {

        } else if (!isRoman1 && !isRoman2) {

        } else {
            throw new IllegalArgumentException("Переменные должны быть или только римскими или только арабскими");
        }

        int result = 0;
        char operation = numbers[1].charAt(0);


        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Ошибка! Деление на ноль");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Неизвестная операция");


        }
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Вводимые чила должны быть в диапазоне от 1 до 10");
        }

        if (!isRoman1) {
            return String.valueOf(result);
        } else return arabToRom(result);
    }

    private static final String[] roman_Numerals = {"null", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static int romToArab(String romanNumeral) {
        String inputUp = romanNumeral.toUpperCase();
        for (int i = 0; i < roman_Numerals.length; i++) {
            if (inputUp.equals(roman_Numerals[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String arabToRom(int arabNumeral) {
        if (arabNumeral <= 0) {
            throw new IllegalArgumentException("Результат операций римских чисел не может быть меньше или равен нулю");
        }
        return roman_Numerals[arabNumeral];
    }
}