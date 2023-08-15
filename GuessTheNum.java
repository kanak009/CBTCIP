import java.util.*;

public class GuessTheNum{

    public static void main(String[]args)
    {
        double SecretValueDouble = Math.random() * 100;
        int SecretValue = (int) Math.floor(SecretValueDouble);
        
        do{
        int maxAttempts = 10;
        int totalScore = 0;
        int attempt=0;
        int Score=0;

        System.out.println("Welcome to Guess the Number Game!");

        Scanner sc=new Scanner(System.in);
        
        
        while(attempt<maxAttempts)
        {
            System.out.println("Guess any number between 1 to 100:");
            int userGuess=sc.nextInt();
            attempt++;


            if(userGuess==SecretValue)
            {
            Score = maxAttempts - attempt + 1;
            totalScore += Score;
            System.out.println("Congratulations! You've guessed the number " + SecretValue + " in " + attempt + " attempts.");
            System.out.println("Your total score: " + totalScore);
            break;
            
            }
            
            
            else if(userGuess>SecretValue)
            {
                System.out.println("Your guess is too high.");
            }
            else
            {
                System.out.println("Your guess is too low.");
            }

            int remainingAttempt=maxAttempts-attempt; 
            

            if (remainingAttempt>0) 
            {
                System.out.println("You have " + remainingAttempt + " attempts left.");
            } else 
            {
                System.out.println("Sorry, you've run out of attempts. The number was " + SecretValue + ".");
            }
        }
    
        

        System.out.println("Do you want to play again? (yes/no)");
        String playAgain = sc.next().toLowerCase();

        if (!playAgain.equals("yes")) 
        {
            break;
        }
    } while (true);
        
    System.out.println("Thanks for playing!");
    System.exit(0);

}
}
       

   