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

}
