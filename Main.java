package com.example.untitled;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");

        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        System.out.println("=== Калькулятор факториала ===");

        while (!validInput) {
            try {
                System.out.print("Пожалуйста, введите положительное целое число: ");
                number = scanner.nextInt();

                if (number < 0) {
                    System.out.println("Ошибка: Вы ввели отрицательное число. Попробуйте снова.\n");
                    scanner.nextLine();
                    continue;
                }
                validInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введены некорректные данные. Пожалуйста, используйте только целые числа.\n");
                scanner.nextLine();
            }
        }
        scanner.close();

        BigInteger result = calculateFactorial(number);
        System.out.printf("Факториал числа %d равен:%n%s%n", number, result);
    }

    public static BigInteger calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}