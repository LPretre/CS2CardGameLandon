import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Deck extends JFrame {
    /// Uses an ArrayList to store a deck of cards
    private ArrayList<Card> cards;
    /// Uses an integer to indicate how many cards are left in the deck
    private int cardsLeft;
    private Image[] images;

    /// Construct a deck of cards given suits and ranks
    public Deck(String[] ranks, String[] suits, int[] values, Image[] cardImages) {
        cards = new ArrayList<Card>();
        for (String suit : suits){
            for (int j = 0; j < ranks.length; j++){
                cards.add(new Card(ranks[j], suit, values[j]));
            }
        }
        this.cardsLeft = suits.length * ranks.length;
    }

    /// Indicate whether there are any cards that have not been dealt out
    public boolean isEmpty(){
        if (cardsLeft == 0){
            return true;
        }
        return false;
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    /// Deals out last card in the deck, given that the deck is not empty
    public Card deal(){
        if (isEmpty()) {
            return null;
        }
        cardsLeft -= 1;
        return cards.get(cardsLeft);

    }

    /// Swaps randomly indexed cards starting from the last card and going down to the first
    /// Resets the cards left to the size of the deck
    public void shuffle(){
        for (int i = cards.size() - 1; i >= 0; i -= 1){
            int newIndex = (int) (Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(newIndex));
            cards.set(newIndex, temp);
        }
        cardsLeft = cards.size();
    }
}


