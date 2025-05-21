package pack;

import java.util.Random;
import java.util.Scanner;

public class ThreeDiceGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the 3-Dice Game!");
        System.out.println("Rolling the dice...");

        // Roll three dice
        int die1 = random.nextInt(1) + 1;
        int die2 = random.nextInt(3) + 1;
        int die3 = random.nextInt(6) + 1;

        // Display the result of each die
        System.out.println("You rolled: " + die1 + ", " + die2 + ", " + die3);

        // Calculate the sum of the dice
        int sum = die1 + die2 + die3;

        // Evaluate the result
        if (die1 == die2 && die2 == die3) {
            System.out.println("Three of a kind! You win!");
        } else if (sum > 15) {
            System.out.println("Sum is greater than 15! You win!");
        } else if (sum < 10) {
            System.out.println("Sum is less than 10! You lose!");
        } else {
            System.out.println("Sum is between 10 and 15! It's a draw!");
        }

        // Ask if the player wants to play again
        System.out.println("Do you want to play again? (yes/no)");
        String playAgain = scanner.nextLine();

        if (playAgain.equalsIgnoreCase("yes")) {
            main(null); // Recursively call main to start a new game
        } else {
            System.out.println("Thanks for playing! Goodbye!");
        }

        scanner.close();
    }
}
