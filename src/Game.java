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

    public Game(String name) {
        user = new Player(name);
        house = new Player("Dealer");
        gameDeck = new Deck(ranks, suits, values);
    }

    public void printInstructions() {
        System.out.println("Welcome to Blackjack by Landon! \n" +
                "Your goal is to get your hand to equal a total value of 21.\n" +
                "If your hand goes over 21, you bust and automatically lose that hand.\n" +
                "Aces have a value of 11, sorry! \n" +
                "A hand win gets you 100 points; a loss loses you 100.\n" +
                "Have fun!");
    }

    public void playGame() {
        System.out.println("Dealing the first hand...");
        gameDeck.shuffle();

        /// Deal two cards to each player
        house.addCard(gameDeck.deal());
        user.addCard(gameDeck.deal());
        house.addCard(gameDeck.deal());
        user.addCard(gameDeck.deal());

        System.out.println("Your hand: " + user.getHand() + ". Your hand value: " + user.getHandValue());
        System.out.println("Dealer's visible card: " + house.getHand().get(0));

        /// If the player has a blackjack, they auto win
        if (user.getHandValue() == 21){
            System.out.println("Blackjack! You Win!");
            user.addPoints(100);
            return;
        }
        /// Run the player's turns

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to hit or stand? (Type 'hit' or 'stand')");
            String choice = scanner.nextLine();
            if (choice.equals("hit")) {
                user.addCard(gameDeck.deal());
                System.out.println("Your hand: " + user.getHand() + ". Your hand value: " + user.getHandValue());
                if (user.getHandValue() > 21) {
                    System.out.println("You busted!");
                    user.addPoints(-100);
                    return; /// End the round
                }
            } else if (choice.equals("stand")) {
                break;
            } else {
                System.out.println("Invalid input, please type 'hit' or 'stand'.");
            }
        }

        /// Run the CPU's turn

        System.out.println("Dealer's turn...");
        System.out.println("Dealer's hand: " + house.getHand() + ". Dealer's hand value: " + house.getHandValue());
        while (house.getHandValue() < 17) {
            house.addCard(gameDeck.deal());
            System.out.println("Dealer's hand: " + house.getHand() + ". Dealer's hand value: " + house.getHandValue());
        }

        /// Determine the winner
        if (house.getHandValue() > 21 || user.getHandValue() > house.getHandValue()) {
            System.out.println("You win this hand!");
            user.addPoints(100);
        } else if (user.getHandValue() == house.getHandValue()) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Dealer wins this hand.");
            user.addPoints(-100);
        }
    }

    /// Starts the game, plays from the top
    public void start() {
        printInstructions();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            playGame();
            System.out.println("Would you like to play again? (yes/no)\n Your point total: "
            + user.getPoints());
            if (!scanner.nextLine().equals("yes")) {
                System.out.println("Thanks for playing! \n You ended with: " +
                        user.getPoints() + " points");
                break;
            }
            user.clearHand();
            house.clearHand();
            gameDeck.shuffle();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        Game blackjack = new Game(name);
        blackjack.start();
    }
}
