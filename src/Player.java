import java.util.ArrayList;

public class Player {
    /// Stores player's name
    private String name;
    /// Stores the player's current hand
    private ArrayList<Card> hand;
    /// Stores the players points as an integer
    private int points;

    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
        this.points = 0;
    }

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    /// Adds a given amount of points to the player
    public void addPoints(int points){
        this.points += points;
    }

    /// Adds a card to the player's hand
    public void addCard(Card newCard){
        hand.add(newCard);
    }

    /// Returns a string representation of the player
    public String toString(){
        return name + " has " + points +
                " points. \n" + name +
                "'s hand: " + hand;
    }

    /// Returns the value of the player's entire hand
    public int getHandValue(){
        int sum = 0;
        for (Card card : hand){
            sum += card.getValue();
        }
        return sum;
    }

    public void clearHand(){
        this.hand = new ArrayList<Card>();
    }

}
