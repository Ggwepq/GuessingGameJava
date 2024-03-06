import java.util.Scanner;

public class SinglePlayer {

    Game gameUtils = new Game();
    Scanner sc = new Scanner(System.in);

    int randomNum;

    SinglePlayer(){
        System.out.println("\n===== Guessing Game =====\n  === Single Player ===\n");
        randomNum = gameUtils.getRandomNum();
        System.out.println("Number: "+randomNum);
        getInput();
    }

    void getInput(){
        System.out.print("Guess: ");
        String guessNumber = sc.nextLine();
        
        int guessNum = 0;
        if (gameUtils.isInteger(guessNumber)){
            guessNum = Integer.parseInt(guessNumber);
            
            if (gameUtils.isBetweenMinMax(guessNum)){
                compareGuess(guessNum);
            } else {
                System.out.println("\nMust be 1 to 100 only...");
                getInput();
            }
        } else {
            System.out.println("\nMust be a number...");
            getInput();
        }
    }

    void compareGuess(int guess){
        if (guess == randomNum){
            System.out.println("\nCongratulations! You've guess the number right!! :D\n");
            hasGuessedRight();
        } else {
            if (!gameUtils.isHigher(guess, randomNum)) {
                System.out.println("\nGuess is Lower than the Number. :(");
                getInput();
            } else if (gameUtils.isHigher(guess, randomNum)) {
                System.out.println("\nGuess is Higher than the Number. :(");
                getInput();
            }
        }
    }

    void hasGuessedRight(){
        System.out.print("What would you like to do now?\n[1] Play Again\n[2] Main Menu\n[3] Exit\n>> ");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                new SinglePlayer();
                break;
            case 2: 
                System.out.println("\n");
                new GuessingGame().StartScreen();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("\nPlease Choose Again...\n");
                hasGuessedRight();
                break;
        }
    }
}