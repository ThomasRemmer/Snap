import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class Game extends Deck{

    public Game() {
        super();
        this.createDeck();
        this.shuffleDeck();
    }
    int turn = 1;
    Scanner scanner = new Scanner(System.in);
    boolean snap = false;
    String input = "";
    String currentCard = "";
    String previousCard = "";

    public void gameHandler(){
        System.out.println("Welcome to Snap! Press Enter to draw a card and type Snap when cards match to win!");

        Card card = this.dealCard();

        while(!snap) {
            scanner.nextLine();
            previousCard = card.getSymbol();
            card = this.dealCard();
            if (turn == 1) {
                System.out.println("Player 1 draws: " + card.toString());
                turn = 2;
            } else {
                System.out.println("Player 2 draws: " + card.toString());
                turn = 1;
            }
            currentCard = card.getSymbol();
            checkSnap();
        }
    }
    public void checkSnap(){
        if (currentCard.equals(previousCard)) {
            snap = true;
            handleInput();
        }
    }
    public void handleInput() {
        Timer timer = new Timer();
        timer.schedule(foundSnap, 3000);
        input = scanner.nextLine();
    }
    TimerTask foundSnap = new TimerTask() {

        public void run() {
            if (input.toLowerCase().equals("snap")) {
                if (turn == 2) {
                    System.out.println("Player 1 wins!");
                } else {
                    System.out.println("Player 2 wins!");
                }
                System.exit(0);
            } else {
                if (turn == 2) {
                    System.out.println("Player 1 was too slow and loses!");
                } else {
                    System.out.println("Player 2 was too slow and loses!");
                }
                System.exit(0);
            }
        }
    };

    }


