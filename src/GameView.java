import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private Image background;
    private Image[] cardImages;
    private final int WINDOW_WIDTH = 1050;
    private final int WINDOW_HEIGHT = 1000;
    private final int INSTRUCTIONS_X = 200;
    private final int USER_Y = 600;
    private final int USER_X_START = 50;
    private final int HOUSE_Y = 50;
    private final int HOUSE_X_START = 50;
    private final int CARD_WIDTH = 150;
    private final int CARD_HEIGHT = 300;
    private final int DECK_X = 50;
    private final int DECK_Y = 375;
    private final int DECK_HEIGHT = 200;
    private final int DECK_WIDTH = 100;
    private final int MESSAGE_X = 200;
    private final int MESSAGE_Y = 450;
    private final int POINTS_X = 200;
    private final int POINTS_Y = 550;
    private Game a;
    private Image cardBack;

    public GameView(Game a) {

        // Initialize instance variables.
        this.a = a;
        background = new ImageIcon("Resources/BackgroundB.png").getImage();
        cardImages = new Image[52];
        for(int i = 0; i < 52; i ++) {
            cardImages[i] = new ImageIcon("Resources/" + (i + 1) + ".png").getImage();
        }
        cardBack = new ImageIcon("Resources/back.png").getImage();
        // Setup the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("The Table");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    // Returns the array of all card images
    public Image[] getCardImages() {
        return cardImages;
    }

    // Displays the board, displays the game as it progresses
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("San Serav", Font.BOLD + Font.ITALIC, 35));
        //Draw background
        g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        //Display point total
        g.drawString("Your Points: " + a.getUser().getPoints(), POINTS_X, POINTS_Y);
        //Display the "Deck" card
        g.drawImage(cardBack, DECK_X, DECK_Y, DECK_WIDTH, DECK_HEIGHT, this);
        if (!a.getUser().getHand().isEmpty()){
            //Display the user's cards
            for (int i = 0; i < a.getUser().getHand().size(); i ++) {
                a.getUser().getHand().get(i).draw(g,USER_X_START + i * 200 , USER_Y);
            }
        }
        if (!a.getHouse().getHand().isEmpty()){
            //Display the dealer's cards, only show the first
            a.getHouse().getHand().get(0).draw(g, HOUSE_X_START, HOUSE_Y);
            for (int i = 1; i < a.getHouse().getHand().size(); i++){
                g.drawImage(cardBack, HOUSE_X_START + i * 200, HOUSE_Y, CARD_WIDTH, CARD_HEIGHT, this);
            }
        }
        //Determine who has won, flip the dealer's cards over
        if (a.getWin()){
            g.drawString("You win!", MESSAGE_X, MESSAGE_Y);
            g.drawString("Play again?(yes/no)", MESSAGE_X - 5, MESSAGE_Y + 45);
            for (int i = 0; i < a.getHouse().getHand().size(); i++){
                a.getHouse().getHand().get(i).draw(g, HOUSE_X_START + i * 200, HOUSE_Y);
            }
        }
        else if(a.getLoss()){
            g.drawString("You lose :(", MESSAGE_X, MESSAGE_Y);
            g.drawString("Play again?(yes/no)", MESSAGE_X - 5, MESSAGE_Y + 45);
            for (int i = 0; i < a.getHouse().getHand().size(); i++){
                a.getHouse().getHand().get(i).draw(g, HOUSE_X_START + i * 200, HOUSE_Y);
            }
        }
        else if(a.getTie()){
            g.drawString("It's a tie!", MESSAGE_X, MESSAGE_Y);
            g.drawString("Play again?(yes/no)", MESSAGE_X - 5, MESSAGE_Y + 45);
            for (int i = 0; i < a.getHouse().getHand().size(); i++){
                a.getHouse().getHand().get(i).draw(g, HOUSE_X_START + i * 200, HOUSE_Y);
            }
        }
    }
}
