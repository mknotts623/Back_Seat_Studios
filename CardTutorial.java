//https://www.youtube.com/watch?v=qL9MrneLiNU

import javafx.scene.image.ImageView;
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardTutorial
{
    private String cardName;
    private int indexNumber;
    private int attack;
    private int defense;
    private ImageView cardImage;
    
    public CardTutorial(String cardName, int indexNumber, int attack, int defense, ImageView cardImage) {
        this.cardName = cardName;
        this.indexNumber = indexNumber;
        this.attack = attack;
        this.defense = defense;
        this.cardImage = cardImage;
        this.cardImage.setFitHeight(240);
        this.cardImage.setFitWidth(148);
    }
    public String toString() {
        return this.cardName;
    }
    public int getAttack() {
        return this.attack;
    }
    public int getDefense() {
        return this.defense;
    }
    public ImageView getCardImage() {
        return this.cardImage;
    }
    public CardTutorial getCardTutorial() {
        return this;
    }
}
