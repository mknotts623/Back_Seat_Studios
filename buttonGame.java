import java.awt.*;
import java.awt.color.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
/*
 * 
 * GOES ROWS, COLUMNS
 */
public class buttonGame extends JFrame {
    static int rows = 4;
    static int columns = 6; //Rightmost column is end turn button and player health displays.
    static Card[][] card = new Card[4][6];
    static JButton[][] buttons = new JButton[4][6];
    static JFrame p = new JFrame();
    
    static int p1HP = 50;
    static int p2HP = 50;
    static int maxMana = 1;
    static int p1Mana = 1;
    static int p2Mana = 1;
    
    static int turn = 1; //1 (top) or 2 (bottom) corresponding to that player's turn.

    public static void main(String[] args) {
        drawBoard();
    }

    public static void drawBoard() {
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setLayout(new GridLayout(rows,columns, 10, 10));
        p.setSize(1920,1080);
        try {
            for (int i = 0; i < rows; i++) { 
                for (int j = 0; j < columns; j++) {
                    int rand = (int) (Math.random() * 3);
                    card[i][j] = CardDatabase.CardDatabase(rand);
                    
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {                    
                    ImageIcon img = new ImageIcon(card[i][j].getCardImage());
                    
                    JButton b = new JButton("Button" + i + "," + j);
                    b.addActionListener(new ButtonListener());
                    //System.out.println(i+","+j);
                    if (j != 5) {
                        b.setIcon(img);
                    }
                    
                    /*else if (i == 1 && j == 1) {
                        b.setIcon(img);
                    }*/
                    p.add(b);
                    buttons[i][j] = b;
                }
            }
            //Soooo, apparently setting Text makes it stop working for clicking stuff, so to make it a button that works like a button, you can't use set text.
            //buttons[2][5].setText("End Turn");
            buttons[2][5].setIcon(new ImageIcon("EndTurn.png"));
            buttons[0][5].setText(p1HP + "");
            buttons[3][5].setText(p2HP + "");
            buttons[1][5].setText("Mana: " + p1Mana);
        }

        catch (Exception e) {
            System.out.println("ERROR:" + e);
        }
        p.setVisible(true);
    }    

    public static void moveCard(int a, int c) {
        int columnToPlace = 0; //Figures out first open space the card could be played.
        if (a == 3) {
            columnToPlace = firstOpenSpot(card, a - 1);
        } else if (a == 0) {
            columnToPlace = firstOpenSpot(card, a + 1);
        }
        
        System.out.println("First Open Column: " + columnToPlace);
        if (columnToPlace != -1) { //If there's an open spot, play the card.
            if (a == 3 && turn == 2 && p2Mana >= card[a][c].getCost()) {//You can only play your cards if it's your turn.
                p2Mana = p2Mana - card[a][c].getCost();
                buttons[1][5].setText("Mana: "+p2Mana);
                //Card costs mana.  Now move card to spot.
                card[a - 1][columnToPlace] = card[a][c];
                System.out.println(card[a][c] + " has been moved to " + (a - 1) + "," + columnToPlace);
                buttons[a - 1][columnToPlace].setIcon(new ImageIcon(card[a][c].getCardImage()));
                card[a][c] = null;
                buttons[a][c].setIcon(new ImageIcon("NoCard.png"));
            } else if (a == 0 && turn == 1 && p1Mana >= card[a][c].getCost()) {
                p1Mana = p1Mana - card[a][c].getCost();
                buttons[1][5].setText("Mana: "+p1Mana);
                //Card costs mana.  Now move card to spot.
                card[a + 1][columnToPlace] = card[a][c];
                System.out.println(card[a][c] + " has been moved to " + (a + 1) + "," + columnToPlace);
                buttons[a + 1][columnToPlace].setIcon(new ImageIcon(card[a][c].getCardImage()));
                card[a][c] = null;
                buttons[a][c].setIcon(new ImageIcon("NoCard.png"));
            }
        }
    }

    public static void combat(int a, int c) {
        if (a == 1 && turn == 1) { //Each row can only attack if it is its owner's turn.
            if (card[a + 1][c] == null) {
                System.out.println("nulled");
                String card1 = card[a][c].toString();
                System.out.println(card1 + " has attack/defense " + card[a][c].getAttack() + "/" + card[a][c].getDefense());
                System.out.println(card1 + " deals " + card[a][c].getAttack() + " damage player 2!");
                p2HP = p2HP - card[a][c].getAttack();
                buttons[3][5].setText(p2HP+"");
            } else {
                System.out.println("not nulled");
                String card1 = card[a][c].toString();
                String card2 = card[a + 1][c].toString();
                System.out.println(card1 + " has attack/defense " + card[a][c].getAttack() + "/" + card[a][c].getDefense());
                System.out.println(card2 + " has attack/defense " + card[a + 1][c].getAttack() + "/" + card[a + 1][c].getDefense());
                System.out.println(card1 + " takes " + card[a+1][c].getAttack() + " damage");
                System.out.println(card2 + " takes " + card[a][c].getAttack() + " damage");
                
                boolean card1dead = false;
                boolean card2dead = false;
                if (card[a][c].getAttack() >= card[a + 1][c].getDefense()) {
                    System.out.println(card2 + " dies");
                    card2dead = true;
                }
                if (card[a][c].getDefense() <= card[a + 1][c].getAttack()) {
                    System.out.println(card1 + " dies");
                    card1dead = true;
                }
                
                //This should make combat matter.
                if (card2dead) {
                    buttons[a+1][c].setIcon(new ImageIcon("NoCard.png"));
                    card[a+1][c] = null;
                }
                if (card1dead) {
                    buttons[a][c].setIcon(new ImageIcon("NoCard.png"));
                    card[a][c] = null;
                }
            }
        } else if (a == 2 && turn == 2) {
            if (card[a - 1][c] == null) {
                System.out.println("nulled");
                String card1 = card[a][c].toString();
                System.out.println(card1 + " has attack/defense " + card[a][c].getAttack() + "/" + card[a][c].getDefense());
                System.out.println(card1 + " deals " + card[a][c].getAttack() + " damage player 1!");
                p1HP = p1HP - card[a][c].getAttack();
                buttons[0][5].setText(p1HP+"");
            } else {
                String card1 = card[a][c].toString();
                String card2 = card[a - 1][c].toString();
                System.out.println(card1 + " has attack/defense " + card[a][c].getAttack() + "/" + card[a][c].getDefense());
                System.out.println(card2 + " has attack/defense " + card[a - 1][c].getAttack() + "/" + card[a - 1][c].getDefense());
                System.out.println(card1 + " takes " + card[a-1][c].getAttack() + " damage");
                System.out.println(card2 + " takes " + card[a][c].getAttack() + " damage");
            
                boolean card1dead = false;
                boolean card2dead = false;
                if (card[a][c].getAttack() >= card[a - 1][c].getDefense()) {
                    System.out.println(card2 + " dies");
                    card2dead = true;
                }
                if (card[a][c].getDefense() <= card[a - 1][c].getAttack()) {
                    System.out.println(card1 + " dies");
                    card1dead = true;
                }
            
                //This should make combat matter.
                if (card2dead) {
                    buttons[a-1][c].setIcon(new ImageIcon("NoCard.png"));
                    card[a-1][c] = null;
                }
                if (card1dead) {
                    buttons[a][c].setIcon(new ImageIcon("NoCard.png"));
                    card[a][c] = null;
                }
            }
        }
    }
    
    public static int firstOpenSpot(Card[][] card, int row) { //Pass in the array of cards and which row you want to access, and get the first open column.
        int columns = 6;
        int leftmostSpot = -1;
        int c = 0;
        boolean found = false;
        while(found == false && c < columns-1) {
            if (card[row][c] == null) {
                leftmostSpot = c;
                found = true;
            }
            c++;
        }
        return leftmostSpot;
    }
    
    public static void switchTurn() { //Toggle the turn variable.
        if(turn == 1) {
            turn = 2;
            p2Mana = maxMana;
            buttons[1][5].setText("Mana: "+p2Mana);
        }else if(turn == 2) {
            turn = 1;
            if (maxMana < 10) {
                maxMana++;
            }
            p1Mana = maxMana;
            buttons[1][5].setText("Mana: "+p1Mana);
        }
        System.out.println("Turn switched!  Player " + turn + "\'s turn!");
    }
}

class ButtonListener implements ActionListener {
    ButtonListener() {}

    public void actionPerformed(ActionEvent e) {
        int rows = 4;
        int columns = 6;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (e.getActionCommand().equals("Button"  + i + "," + j)) {
                    System.out.println("Row: "+i+" Column: " +j);
                    if ((i == 3 || i == 0) && j != columns-1) {
                        System.out.println("Click 1");
                        buttonGame.moveCard(i,j);
                    } else if ((i == 2 || i == 1) && j != columns-1) {
                        System.out.println("Click 2");
                        buttonGame.combat(i,j);
                    } else if (i == 2 && j == columns - 1) {
                        System.out.println("Click 3");
                        buttonGame.switchTurn(); //Clicking the end turn button switches who's turn it is.
                    }
                }
            }
        }
   }
}

