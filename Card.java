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
    private int cost;
    private String cardImage;
    private boolean alreadyAttacked;
    private boolean isPermanent;
    
    /**
     * Constructor for objects of class Card
     * @param cardName Name of the card's creature, spell, etc.
     * @param index Card's index number, used to organize and identify cards
     * @param attack Attack stat of card, compared to other cards' defense when challenging
     * @param defense Defense stat of card, compared to other cards' attack when withstanding challenges
     * @param cardImage Name of the image file for the card art
     * @param alreadyAttacked Whether or not this card has attacked yet.
     */
    public Card(String cardName, int index, int attack, int defense, int cost, String cardImage, boolean isPermanent) {
        this.cardName = cardName;
        this.index = index;
        this.attack = attack;
        this.defense = defense;
        this.cost = cost;
        this.cardImage = cardImage;
        this.alreadyAttacked = false;
        this.isPermanent = isPermanent;
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
    
    /**
     * Getter for cost
     * @return Cost of card in player's resources
     */
    public int getCost() {
        return cost;
    }
    
    /**
     * Getter for alreadyAttacked
     * @return whether or not card has attacked
     */
    public boolean getAlreadyAttacked() {
        return alreadyAttacked;
    }
    /**
     * Setter for alreadyAttacked
     * 
     */
    public void setAlreadyAttacked(boolean state) {
        alreadyAttacked = state;
    }
    /**
     * Getter for isPermanent
     * @return whether or not a card is a permanent
     */
    public boolean isPermanent() {
        return isPermanent;
    }
}
