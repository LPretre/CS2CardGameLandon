import java.awt.*;

public class Card {

    private String rank;
    private String suit;
    private int value;
    private Image cardImage;
    private GameView viewer;
    private final int CARD_LENGTH = 300;
    private final int CARD_WIDTH = 150;

    /// Constructs a card with a given suit, rank, and value
    public Card(String rank, String suit, int value, Image cardImage, GameView viewer) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        this.cardImage = cardImage;
        this.viewer = viewer;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString(){
        return (rank + " of " + suit);
    }

    //Draws card on the screen at a given coordinate
    public void draw(Graphics g, int x, int y){
        g.drawImage(cardImage, x, y, CARD_WIDTH, CARD_LENGTH, viewer);
    }
}
