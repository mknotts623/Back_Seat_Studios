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
            buttons[2][5].setText("End Turn");
            buttons[0][5].setText(p1HP + "");
            buttons[3][5].setText(p2HP + "");
            buttons[1][5].setText("Game Name Here");
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
            if (a == 3) {
                card[a - 1][columnToPlace] = card[a][c];
                System.out.println(card[a][c] + " has been moved to " + (a - 1) + "," + columnToPlace);
                buttons[a - 1][columnToPlace].setIcon(new ImageIcon(card[a][c].getCardImage()));
                card[a][c] = null;
                buttons[a][c].setIcon(new ImageIcon("NoCard.png"));
            } else if (a == 0) {
                card[a + 1][columnToPlace] = card[a][c];
                System.out.println(card[a][c] + " has been moved to " + (a + 1) + "," + columnToPlace);
                buttons[a + 1][columnToPlace].setIcon(new ImageIcon(card[a][c].getCardImage()));
                card[a][c] = null;
                buttons[a][c].setIcon(new ImageIcon("NoCard.png"));
            }
        }
    }

    public static void combat(int a, int c) {
        if (a == 1) {
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
        } else if (a == 2) {
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
}

class ButtonListener implements ActionListener {
    ButtonListener() {}

    public void actionPerformed(ActionEvent e) {
        int rows = 4;
        int columns = 6;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns-1; j++) {
                if (e.getActionCommand().equals("Button"  + i + "," + j)) {
                    if (i == 3 || i == 0) {
                        buttonGame.moveCard(i,j);
                    }
                    if (i == 2 || i == 1) {
                        buttonGame.combat(i,j);
                    }
                }
            }
        }
    }
}

