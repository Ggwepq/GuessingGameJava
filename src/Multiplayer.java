import java.util.Scanner;

public class Multiplayer {

    Scanner sc = new Scanner(System.in);
    Game gameUtils = new Game();
    Player player1, player2;

    int turn = 0, randomNum, player1Attempt = 0, player2Attempt = 0;

    Multiplayer(){
        System.out.println("\n===== Guessing Game =====\n   === Multiplayer ===\n");
        randomNum = gameUtils.getRandomNum();
        getPLayerNames();
    }

    void getPLayerNames(){
        System.out.print("Player 1 Name: ");
        String plyr1Name = sc.nextLine();
        System.out.print("Player 2 Name: ");
        String plyr2Name = sc.nextLine();

        player1 = new Player(plyr1Name, player1Attempt);
        player2 = new Player(plyr2Name, player2Attempt);

        System.out.println("\nWelcome! Please enjoy playing.\n");
        gameStart();
    }

    void showAttempts(){
        System.out.println("===== Guess Attempts =====");
        System.out.println(player1.getName() + ": " + player1.getAttempt() + " || " + player2.getName() + ": " + player2.getAttempt());
    }

    void gameStart(){
        getPlayerInput();
    }

    void getPlayerInput(){
        showAttempts();

        String guess = "";
        if (getCurrentPlayer().equals("player1")){
            System.out.print(player1.getName() + " Guess: ");
            guess = sc.nextLine();
        } else if (getCurrentPlayer().equals("player2")){
            System.out.print(player2.getName() + " Guess: ");
            guess = sc.nextLine();
        }

        int guessNum;
        if (gameUtils.isInteger(guess)){
            guessNum = Integer.parseInt(guess);
            
            if (gameUtils.isBetweenMinMax(guessNum)){
                compareGuess(guessNum);
            } else {
                System.out.println("\nMust be 1 to 100...");
                getPlayerInput();
            }
        } else {
            System.out.println("\nMust be a Number...");
            getPlayerInput();
        }
    }

    void compareGuess(int guess){
        if (guess == randomNum){
            if (getCurrentPlayer().equals("player1")){
                System.out.println("\nCongratulations! " + player1.getName() + " got the correct number in turn " + turn + ". :D\n");
                hasGuessedRight();
            }
            hasGuessedRight();
        } else {
            if (!gameUtils.isHigher(guess, randomNum)) {
                System.out.println("\nGuess is Lower than the Number. :(");

                if (getCurrentPlayer().equals("player1")){
                    player1Attempt++;
                    player1.setAttempt(player1Attempt);
                } else {
                    player2Attempt++;
                    player2.setAttempt(player2Attempt);
                }

                turn++;
                getPlayerInput();
            } else if (gameUtils.isHigher(guess, randomNum)) {
                System.out.println("\nGuess is Higher than the Number. :(");

                if (getCurrentPlayer().equals("player1")){
                    player1Attempt++;
                    player1.setAttempt(player1Attempt);
                } else {
                    player2Attempt++;
                    player2.setAttempt(player2Attempt);
                }

                turn++;
                getPlayerInput();
            }
        }
    }

    void hasGuessedRight(){
        showAttempts();
        showDoneMenu();
    }

    void showDoneMenu(){
        System.out.print("What would you like to do now?\n[1] Play Again\n[2] Main Menu\n[3] Exit\n>> ");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                player1Attempt = player2Attempt = turn = 0;
                new Multiplayer();
                break;
            case 2: 
                System.out.println("\n");
                new GuessingGame().StartScreen();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("\nPlease Choose Again...\n");
                showDoneMenu();
                break;
        }

    }

    String getCurrentPlayer(){
        if (turn % 2 == 0){
            return "player1";
        } else {
            return "player2";
        }
    }

}
