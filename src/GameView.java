import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private Image background;
    private Image[] cardImages;
    private final int WINDOW_WIDTH = 1050;
    private final int WINDOW_HEIGHT = 1500;
    private final int INSTRUCTIONS_X = 200;
    private Game a;
    public GameView(Game a) {

        // Initialize instance variables.
        this.a = a;
        background = new ImageIcon("Resources/Background.png").getImage();
        cardImages = new Image[52];
        for(int i = 0; i < 52; i ++) {
            cardImages[i] = new ImageIcon("Resources/" + i + ".png").getImage();
        }
        // Setup the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("The Table");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getCardImages() {
        return cardImages;
    }

    public void paint(Graphics g){
        g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }
}
