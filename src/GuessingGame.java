import java.util.Scanner;

public class GuessingGame{

    Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        GuessingGame game = new GuessingGame();
        game.StartScreen();
    }

    public void StartScreen(){
        System.out.println("===== Guessing Game =====\n");
        System.out.print("Select Mode:\n[1] Single Player\n[2] Multiplayer\n[3] Exit\n>> ");
        int choice = sc.nextInt();

        switch(choice){
            case 1:
                new SinglePlayer();
                break;
            case 2:
                new Multiplayer();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Please select again...\n");
                break;
        }
    }
}