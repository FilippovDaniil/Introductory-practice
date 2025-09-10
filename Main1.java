package com.example.Practice;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("=== ИГРА 'УГАДАЙ ЧИСЛО' ===");
        System.out.println("Компьютер загадал число от 1 до 100.");
        System.out.println("Попробуйте угадать его за минимальное количество попыток!");
        System.out.println("Для выхода введите '0' в любой момент.");
        System.out.println("-----------------------------------");

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessed = false;

            System.out.println("\nНовая игра! Число загадано...");

            while (!guessed && attempts < maxAttempts) {
                System.out.printf("Попытка %d/%d. Введите ваше число: ", attempts + 1, maxAttempts);

                try {
                    int userGuess = scanner.nextInt();

                    if (userGuess == 0) {
                        System.out.println("Игра прервана.");
                        break;
                    }

                    if (userGuess < 1 || userGuess > 100) {
                        System.out.println("Пожалуйста, введите число от 1 до 100.");
                        continue;
                    }

                    attempts++;

                    if (userGuess == secretNumber) {
                        guessed = true;
                        System.out.printf("🎉 ПОЗДРАВЛЯЮ! Вы угадали число %d за %d попыток!%n",
                                secretNumber, attempts);
                    } else if (userGuess < secretNumber) {
                        System.out.println("⬆️ Слишком маленькое число. Попробуйте больше.");
                    } else {
                        System.out.println("⬇️ Слишком большое число. Попробуйте меньше.");
                    }

                    // Подсказка после 5 попыток
                    if (attempts == 5 && !guessed) {
                        int lowerBound = Math.max(1, secretNumber - 10);
                        int upperBound = Math.min(100, secretNumber + 10);
                        System.out.printf("💡 Подсказка: число находится между %d и %d%n",
                                lowerBound, upperBound);
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Ошибка! Пожалуйста, введите целое число.");
                    scanner.nextLine(); // Очистка буфера
                }
            }

            if (!guessed) {
                System.out.printf("❌ К сожалению, вы исчерпали все попытки. Загаданное число было: %d%n",
                        secretNumber);
            }

            // Предложение сыграть еще раз
            System.out.print("\nХотите сыграть еще раз? (да/нет): ");
            scanner.nextLine(); // Очистка буфера
            String response = scanner.nextLine();

            if (!response.equalsIgnoreCase("да") && !response.equalsIgnoreCase("yes")) {
                playAgain = false;
                System.out.println("Спасибо за игру! До свидания!");
            }
        }

        scanner.close();
    }
}
