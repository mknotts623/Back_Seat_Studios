import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Fighting
 * @author Eric
 * @version 1 - 9/29/17
 * Definitely still work in progress; this can serve as framework until we integrate a two-player system.
 */
public class Combat
{
    /**
     * Constructor for objects of class Combat
     */   
    public Combat(){
        System.out.println("Pick your attacking card.");
        Card atkCard = slotGrid[2][i].getCard();
        if(atkCard != null){
            System.out.println("Which card are you attacking?");
            Card defCard = slotGrid[1][i].getCard();
        }
        if(atkCard.getAttack >= defCard.getDefense){
            defCard = null;
        }
        if(defCard.getAttack >= atkCard.getDefense){
            atkCard = null;
        }
    }
   }
