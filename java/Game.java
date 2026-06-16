package fst_java;

import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;

public class Game {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        FileWriter file = new FileWriter("results.txt", true);
        int playerScore = 0, computerScore = 0;
        
        System.out.println("=== Rock Paper Scissors ===");
        System.out.print("How many rounds? ");
        int rounds = Integer.parseInt(scan.nextLine());
        
        for (int i = 1; i <= rounds; i++) {
            System.out.print("\nRound " + i + " - Enter (rock/paper/scissors): ");
            String player = scan.nextLine().toLowerCase();
            
            // Validate input
            if (!player.matches("rock|paper|scissors")) {
                System.out.println("Invalid input!");
                i--;
                continue;
            }
            
            String[] choices = {"rock", "paper", "scissors"};
            String computer = choices[rand.nextInt(3)];
            
            System.out.println("Computer: " + computer);
            
            String result;
            if (player.equals(computer)) {
                result = "TIE";
            } else if ((player.equals("rock") && computer.equals("scissors")) ||
                       (player.equals("paper") && computer.equals("rock")) ||
                       (player.equals("scissors") && computer.equals("paper"))) {
                playerScore++;
                result = "YOU WIN";
            } else {
                computerScore++;
                result = "LOSE";
            }
            
            System.out.println("Result: " + result);
            file.write("Round " + i + ": " + player + " vs " + computer + " = " + result + "\n");
        }
        
        System.out.println("\n=== FINAL SCORE ===");
        System.out.println("You: " + playerScore);
        System.out.println("Computer: " + computerScore);
        System.out.println("Winner: " + (playerScore > computerScore ? "YOU" : computerScore > playerScore ? "COMPUTER" : "TIE"));
        System.out.println("Results saved!");
        
        file.close();
        scan.close();
    }
}