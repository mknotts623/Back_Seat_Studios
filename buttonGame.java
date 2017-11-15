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
    static int columns = 5;
    static Card[][] card = new Card[4][5];
    static JButton[][] buttons = new JButton[4][5];
    static JFrame p = new JFrame();

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
                    if (i == 3 || i == 0) {
                        b.setIcon(img);
                    }
                    else if (i == 1 && j == 1) {
                        b.setIcon(img);
                    }
                    p.add(b);
                    buttons[i][j] = b;
                }
            }
        }

        catch (Exception e) {
            System.out.println("ERROR:" + e);
        }
        p.setVisible(true);
    }    

    public static void moveCard(int a, int c) {
        if (a == 3) {
            card[a - 1][c] = card[a][c];
            System.out.println(card[a][c] + " has been moved to " + (a - 1) + "," + c);
        } else if (a == 0) {
            card[a + 1][c] = card[a][c];
            System.out.println(card[a][c] + " has been moved to " + (a + 1) + "," + c);
        }
    }

    public static void combat(int a, int c) {
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
        if (card1dead) {
            buttons[a-1][c].setIcon(new ImageIcon("NoCard.png"));
            card[a-1][c] = null;
        }
        if (card2dead) {
            buttons[a][c].setIcon(new ImageIcon("NoCard.png"));
            card[a][c] = null;
        }
    }
}

class ButtonListener implements ActionListener {
    ButtonListener() {}

    public void actionPerformed(ActionEvent e) {
        int rows = 4;
        int columns = 5;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (e.getActionCommand().equals("Button"  + i + "," + j)) {
                    if (i == 3 || i == 0) {
                        buttonGame.moveCard(i,j);
                    }
                    if (i == 2) {
                        buttonGame.combat(i,j);
                    }
                }
            }
        }
    }
}

