import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public static ArrayList<Card> cards = new ArrayList<>();
    public static String[] suit = {"Hearts", "Clubs", "Diamonds", "Spades"};
    public static String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static int[] values = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    public static ArrayList<Card> createDeck() {
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card card = new Card(suit[i], symbols[j], values[j]);
                cards.add(card);
            }
        }
        return cards;
    }
    public Card dealCard() {
        return cards.remove(0);
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(cards, (a, b) -> a.getValue() - b.getValue());
        return cards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        Collections.sort(cards, (a, b) -> a.getSuit().compareTo(b.getSuit()));
        return cards;
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(cards);
        return cards;
    }
}
