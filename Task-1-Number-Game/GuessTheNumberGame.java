package com.practice.basicpgm;

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=== Guess The Number Game ===");

        int totalWins = 0;
        boolean keepPlaying = true;

        while (keepPlaying) {
            int secretNumber = rand.nextInt(100) + 1;  // random number between 1 and 100
            int tries = 0;
            final int LIMIT = 5;

            System.out.println("\nI've chosen a number between 1 and 100. Try to guess it!");

            boolean guessedCorrectly = false;

            while (tries < LIMIT) {
                System.out.print("Your guess (" + (LIMIT - tries) + " tries left): ");
                int guess = input.nextInt();
                input.nextLine();  // consume newline
                tries++;

                if (guess == secretNumber) {
                    System.out.println("🎉 Well done! You found it in " + tries + " attempt(s).");
                    totalWins++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("📉 Too low — aim higher!");
                } else {
                    System.out.println("📈 Too high — go lower!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Oops! You’ve used all " + LIMIT + " tries. The number was " + secretNumber + ".");
            }

            System.out.print("Play another round? (yes/no): ");
            String answer = input.nextLine().trim();
            keepPlaying = answer.equalsIgnoreCase("yes");
        }

        System.out.println("\nThanks for playing! You guessed correctly " + totalWins + " time(s).");
        input.close();
    }
}

