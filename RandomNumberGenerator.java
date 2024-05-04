import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        System.out.println("*************************************************************************************************************"+"  \n\n\n");
        System.out.println("IN THIS GAME,YOU HAVE TO GUESS A NUMBER BETWEEN  1 AND 100");
        System.out.println("FOR EACH RIGHT GUESS YOU GAIN 10 POINTS\n\n\n");
        System.out.println("*************************************************************************************************************"+"  \n");

        int totalScore = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("ROUND " + (i + 1));
            int score = guessthenumber();
            totalScore += score;
        }
        System.out.println("Total score: " + totalScore);
    }

    public static int guessthenumber() {
        Random rand = new Random();
        int minRange = 1;
        int maxRange = 100;
        int score = 0;

        int randomNumber = rand.nextInt(maxRange - minRange + 1) + minRange;
        System.out.println("Random number: " + randomNumber);

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter your guess");
            Scanner sc = new Scanner(System.in);
            int guess = sc.nextInt();
            System.out.println(guess);

            if (randomNumber == guess) {
                System.out.println("Right Guess\n\n");
                score += 10;
                break;
            } else {
                System.out.println("Wrong guess");
                double difference = (guess - randomNumber) / (double) randomNumber * 100;
                if (difference > 50 && difference > 0) {
                    System.out.println("Too high");
                } else if (difference < 25 && difference > 0) {
                    System.out.println("Close enough");
                } else if (difference < -50) {
                    System.out.println("Too low");
                } else if (difference > -25) {
                    System.out.println("Close enough");
                }
            }
        }
        System.out.println("Score for this round: " + score);
        return score;
    }
}
