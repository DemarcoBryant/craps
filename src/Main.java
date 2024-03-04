//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int wins = 0;
        int losses = 0;

        for (int game = 1; game <= 10000; game++) {
            System.out.println("Game " + game);
            int point = rollDice();
            System.out.println("Point is " + point);

            while (true) {
                int roll = rollDice();
                System.out.println("Roll: " + roll);
                if (roll == point) {
                    System.out.println("Made point and won!");
                    wins++;
                    break;
                } else if (roll == 7) {
                    System.out.println("Got a seven and lost.");
                    losses++;
                    break;
                } else {
                    System.out.println("Trying for point...");
                }
            }

            System.out.print("Play again? (y/n): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("y")) {
                break;
            }
        }

        double winPercentage = (double) wins / (wins + losses) * 100;
        System.out.println("\nNumber of wins: " + wins);
        System.out.println("Number of losses: " + losses);
        System.out.printf("Winning percentage: %.2f%%\n", winPercentage);
    }

    public static int rollDice() {
        Random random = new Random();
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        return die1 + die2;
    }
}