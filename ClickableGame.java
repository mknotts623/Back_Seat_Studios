//Programmed by Josh Fickes.

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickableGame extends JPanel {

  

    public static void main(String[] args) {
        /** NEW STUFF BEGIN **/
        int turn = 1; //1 or 2, corresponding to player whose turn it is.
        CardDatabase possibleCards = new CardDatabase();
        DeckBuilder p1Deck = new DeckBuilder(possibleCards.database);
        DeckBuilder p2Deck = new DeckBuilder(possibleCards.database);
        /** NEW STUFF END **/
        //THESE HAVE TO MATCH THE VALUES IN SampleBoard.java!!!//
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth(); //Figure out the player's computer screen size.
        int height = (int)screenSize.getHeight(); //Converting this to an int right away makes other stuff less cluttered.
        
        int cardScale = 4650; //This can let us easily tweak the cards' size.
        int cardWidth = height*450/cardScale; //By making both in terms of screen height, the cards will always have the right proportions, and if we leave a considerable border to the right, they should all fit on screen.
        int cardHeight = height*650/cardScale;
        
        int cardsPerRow = 10; //Allows for easy editing. Don't forget to change the ones in the other methods too. 
        Slot[][] slotGrid = new Slot[4][cardsPerRow];//4 rows of 10 slots.  Keep in mind, row 0 is the top row (opponent's hand), and column 0 is the leftmost slot.
        buildSlotGrid(slotGrid);
        
        JFrame frame = new JFrame();
        
        SampleBoard boardDrawing = new SampleBoard();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(boardDrawing); //This makes the pretty board.
        
        frame.getContentPane().addMouseListener(new MouseAdapter() { //This lets you click stuff.
            public void mousePressed(MouseEvent me) { 
                //System.out.println(me);
                if (me.getButton() == MouseEvent.BUTTON1) { //button 1 was clicked
                    
                    System.out.println("x coordinate: " + me.getX());//For testing!!!!!!!!!!!!!!!!!!!!!!
                    System.out.println("y coordinate: " + me.getY());
                    
                    
                    int xPos = me.getX();
                    int yPos = me.getY();
                    boolean found = false;
                    if (!found) {
                        for (int i = 0; i < cardsPerRow; i++) { //Check slots in p2's hand.  These loops are from the SampleBoard.java file.  If we change that, change these.
                            if (xPos > ((2+i)*width/100 + i*cardWidth) && xPos < ((2+i)*width/100 + (i+1)*cardWidth) && yPos > (2*height/100) && yPos < ((2*height/100) + cardHeight)) {
                                clickSelect(slotGrid, 0, i, frame);
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        for (int i = 0; i < cardsPerRow; i++) { //Check slots in p2's field.  All that's different is the conditions for the yPos.
                            if (xPos > ((2+i)*width/100 + i*cardWidth) && xPos < ((2+i)*width/100 + (i+1)*cardWidth) && yPos > (25*height/100) && yPos < ((25*height/100) + cardHeight)) {
                                clickSelect(slotGrid, 1, i, frame);
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        for (int i = 0; i < cardsPerRow; i++) { //Check slots in p1's field.
                            if (xPos > ((2+i)*width/100 + i*cardWidth) && xPos < ((2+i)*width/100 + (i+1)*cardWidth) && yPos > (50*height/100) && yPos < ((50*height/100) + cardHeight)) {
                                clickSelect(slotGrid, 2, i, frame);
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        for (int i = 0; i < cardsPerRow; i++) { //Check slots in p1's hand.
                            if (xPos > ((2+i)*width/100 + i*cardWidth) && xPos < ((2+i)*width/100 + (i+1)*cardWidth) && yPos > (72*height/100) && yPos < ((72*height/100) + cardHeight)) {
                                clickSelect(slotGrid, 3, i, frame);
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("No card clicked.");
                    }
                    /** NEW STUFF BEGIN **/ 
                } else if (me.getButton() == MouseEvent.BUTTON2) {
                    drawCard(slotGrid, turn, p1Deck, p2Deck);
                    /** NEW STUFF END **/
                }
            } 
        });
    
        /*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();*/
        frame.setSize(width,height);
        
        frame.setVisible(true);
        /***BOARD IS NOW DRAWN AND CLICKABLE***/
    
    
    
    }
    
    public static void clickSelect(Slot[][] slotGrid, int row, int column, JFrame frame) { //Accesses slot grid at [row][column], and decides what to do with the card based on its position.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        
        int cardScale = 4650;
        int cardWidth = height*450/cardScale;
        int cardHeight = height*650/cardScale;
        
        
        System.out.println("Card clicked at x=" + column + " y=" + row);//For testing!!!!!!!!!!!!!!!!!!!!!
        System.out.println("1");
        
        if (slotGrid[row][column].getCard() != null) {
            System.out.println("2");
            if (slotGrid[row][column].getLocation().equals("hand")/*row == 3 || row == 0*/) { //Preferably, don't just use rows, but we can do that if need be.
                System.out.println("3");
                if (row == 3) { //Player 1's hand.  Check player 1's field for space.
                    System.out.println("4");
                    //Move card from hand to field.
                    int newLocation = firstSpace(slotGrid, 2);
                    slotGrid[2][newLocation].setCard(slotGrid[row][column].getCard());
                    slotGrid[row][column].setCard(null);
                } else if (row == 0) { //Player 2's hand.  Check player 2's field for space.
                    System.out.println("5");
                    //Move card from hand to field.
                    int newLocation = firstSpace(slotGrid, 1);
                    slotGrid[1][newLocation].setCard(slotGrid[row][column].getCard());
                    slotGrid[row][column].setCard(null);
                } else {
                    System.out.println("Uh oh!  You said a card that wasn't in row 0 or 3 was in someone's hand!  That doesn't make sense!  Dork.");
                }
            } else if (slotGrid[row][column].getLocation().equals("field") /*row == 2 || row == 1*/) { //Again, ideally we wouldn't just use row.
                System.out.println("COMBAT NOT YET IMPLEMENTED.");
            } else {
                System.out.println("Well, looks like you put a card somewhere other than in a hand OR the field!  Wow, you might want to check out what's going on in your code there.");
            }
        } else {
            System.out.println("No card there."); //Testing only!!!!!!!!!!!!!!!
        }
        
        System.out.println("6");
        System.out.println("Card clicked at x=" + column + " y=" + row);//For testing!!!!!!!!!!!!!!!!!!!!!
        
    }
    
    public static int firstSpace(Slot[][] slotGrid, int row) { //Returns the column number of the first open position in the selected row.
        int cardsPerRow = 10; //Allows for easy editing. Don't forget to change the ones in the other methods too.
        boolean found = false;
        int whereIsGap = cardsPerRow + 1;
        for (int i = 0; i < cardsPerRow; i++) { //Run through each slot.
            if (found == false && slotGrid[row][i].getCard() == null) {
                found = true;
                whereIsGap = i;
            }
        }
        return whereIsGap;
    }
    
    public static void buildSlotGrid(Slot[][] slotGrid) {
        int cardsPerRow = 10; //Allows for easy editing. Don't forget to change the ones in the other methods too. 
        for (int i = 0; i < cardsPerRow; i++) {
            slotGrid[0][i] = new Slot("hand", 2, null);
        }
        for (int i = 0; i < cardsPerRow; i++) {
            slotGrid[1][i] = new Slot("field", 2, null);
        }
        for (int i = 0; i < cardsPerRow; i++) {
            slotGrid[2][i] = new Slot("field", 1, null);
        }
        for (int i = 0; i < cardsPerRow; i++) {
            slotGrid[3][i] = new Slot("hand", 1, null);
        }
    }
    
    /** NEW STUFF BEGIN **/
    public static void drawCard(Slot[][] slotGrid, int turn, DeckBuilder p1Deck, DeckBuilder p2Deck) {
        int cardsPerRow = 10; //Allows for easy editing. Don't forget to change the ones in the other methods too.
        Card newCard;
        if (turn == 1) {
            newCard = p1Deck.drawCard();
            int column = firstSpace(slotGrid, 3);
            if (column < cardsPerRow) {
                slotGrid[3][column].setCard(newCard);
            }
        } else if (turn == 2) {
            newCard = p2Deck.drawCard();
            int column = firstSpace(slotGrid, 0);
            if (column < cardsPerRow) {
                slotGrid[0][column].setCard(newCard);
            }
        } else {
            System.out.println("Wow, how\'d you make the turn not 1 or 2?  Might want to check out your code there."); 
        }
    }
    /** NEW STUFF END **/
}