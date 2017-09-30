//Program base by Matt K., and then all of the stuff where it's actually drawing the board and spacing stuff out by Josh! :)  I hope this helps!

//I went for one of those trendy dark color schemes.  See the ALT COLOR by each color for a light color scheme version.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SampleBoard extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.darkGray); //ALT COLOR black
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth(); //Figure out the player's computer screen size.
        int height = (int)screenSize.getHeight(); //Converting this to an int right away makes other stuff less cluttered.
        
        //Draw the board segments
        g.setColor(Color.black); //ALT COLOR white
        g.fillRect(width/100, height/100, 97*width/100, 19*height/100); //Opponent's hand.
        g.fillRect(width/100, 21*height/100, 97*width/100, 24*height/100); //Opponent's field.
        g.fillRect(width/100, 46*height/100, 97*width/100, 24*height/100); //Player's hand.
        g.fillRect(width/100, 71*height/100, 97*width/100, 19*height/100); //Player's field.
        
        int cardWidth = width/14;
        int cardHeight = height/6;
        
        g.setColor(Color.lightGray); //ALT COLOR darkGray
        //Represents the card's back.
        for (int i = 0; i < 5; i++) { //Put 5 placeholder cards in opponent's hand.
            g.fillRect((2+i)*width/100 + i*cardWidth, 2*height/100, cardWidth, cardHeight); //Each is a small gap away from the next.
        }
        
        g.setColor(Color.white); //ALT COLOR lightGray
        //Represents the card's front.
        for (int i = 0; i < 2; i++) { //Put 2 placeholder cards in opponent's field.
            g.fillRect((2+i)*width/100 + i*cardWidth, 25*height/100, cardWidth, cardHeight); //Making these left aligned is way easier than center aligned.
        }

        for (int i = 0; i < 7; i++) { //Put 7 placeholder cards in player's field.  Wow, you're having a good game.
            g.fillRect((2+i)*width/100 + i*cardWidth, 50*height/100, cardWidth, cardHeight); //When this isn't a placeholder, we'l probably need to make each card some sort of draggable thing.
        }
        
        for (int i = 0; i < 4; i++) { //Put 4 placeholder cards in player's hand.
            g.fillRect((2+i)*width/100 + i*cardWidth, 72*height/100, cardWidth, cardHeight); //In case you haven't noticed, in the condition i < x, x is the number of cards to print. The cards are printed at a height equal to 1% of screen height greater (lower down) than the hand they're in, or 4% more than the field they're on.
        }
        
        
        //Labels! For clarity!
        g.setColor(Color.white); //ALT COLOR black
        g.drawString("Opponent's Hand", 90*width/100, 4*height/100); //These totally won't be here once the game is functional!
        g.drawString("Opponent's Field", 90*width/100, 24*height/100);
        g.drawString("Player's Field", 90*width/100, 49*height/100);
        g.drawString("Player's Hand", 90*width/100, 74*height/100);

    }
}
