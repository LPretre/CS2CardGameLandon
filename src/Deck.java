import java.util.ArrayList;
public class Deck {
    // Uses an ArrayList to store a deck of cards
    private ArrayList<Card> cards;
    // Uses an integer to indicate how many cards are left in the deck
    private int cardsLeft;

    // Construct a deck of cards given suits and ranks
    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<Card>();
        for (String suit : suits){
            for (int j = 0; j < ranks.length; j++){
                cards.add(new Card(ranks[j], suit, values[j]));
            }
        }
        this.cardsLeft = suits.length * ranks.length;
    }


}
