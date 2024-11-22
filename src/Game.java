import java.util.Scanner;

public class Game {
    private Player user;
    private Player house;
    private Deck gameDeck;

    /// Initialize arrays of the elements in a deck
    private final String[] suits = {"Clubs", "Hearts", "Diamonds", "Spades"};
    private final String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six",
                                     "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private final int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    public Game(String name){
        user = new Player(name);
        house = new Player("Dealer");
        gameDeck = new Deck(ranks, suits, values);
    }

    public void printInstructions(){
        System.out.println("Welcome to Blackjack by Landon! \n" +
                "Your goal is to get your hand to equal a total value of 21\n" +
                "If your hand goes over 21, you bust and automatically lose that hand" +
                "Aces have a default value of 11, but if you bust with an ace it will turn into a 1 \n"
                + "Have fun!");
    }

    public void playGame(){
        System.out.println("Dealing first hand...");
        gameDeck.shuffle();
        house.addCard(gameDeck.deal());
        user.addCard(gameDeck.deal());
        house.addCard(gameDeck.deal());
        user.addCard(gameDeck.deal());

    }
}
