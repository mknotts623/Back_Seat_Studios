//made following: https://www.youtube.com/watch?v=qL9MrneLiNU

import javax.swing.*;
import java.awt.*;
/**
 * Basic card, with name, index number, attack, defense, card art
 * 
 * @author Christina Kim
 * @version 10/3/17
 */
public class Card
{
    private String cardName;
    private int index;
    private int attack;
    private int defense;
    private String cardImage;
    
    /**
     * Constructor for objects of class Card
     * @param cardName Name of the card's creature, spell, etc.
     * @param index Card's index number, used to organize and identify cards
     * @param attack Attack stat of card, compared to other cards' defense when challenging
     * @param defense Defense stat of card, compared to other cards' attack when withstanding challenges
     * @param cardImage Name of the image file for the card art
     */
    public Card(String cardName, int index, int attack, int defense, String cardImage) {
        this.cardName = cardName;
        this.index = index;
        this.attack = attack;
        this.defense = defense;
        this.cardImage = cardImage;
    }
    
    /**
     * Getter for cardName
     * @return the name of the card
     */
    public String toString() {
        return this.cardName;
    }
    
    /**
     * Getter for attack
     * @return Attack stat of card
     */
    public int getAttack() {
        return this.attack;
    }
    
    /**
     * Getter for defense
     * @return Defense stat of card
     */
    public int getDefense() {
        return this.defense;
    }
    
    /**
     * Getter for cardImage
     * @return File name for art used for card
     */
    public String getCardImage() {
        return this.cardImage;
    }
    
    /**
     * Getter for Card
     * @return the card itself
     */
    public Card getCard() {
        return this;
    }
    
    /**
     * Getter for index
     * @return Index number used to identify the card
     */
    public int getCardIndex() {
        return index;
    }
    
}
