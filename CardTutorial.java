import javafx.scene.image.ImageView;
/**
 * A class describing a card within the deck
 * Tutorial at https://www.youtube.com/watch?v=qL9MrneLiNU
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardTutorial
{
    private String cardName;
    private int attack;
    private int defense;
    private ImageView cardImage;
    
    /**
     * default constructor
     * @param cardName string as the name of the card
     * @param attack the attack strength of the card
     * @param defense the defense strength of the card
     * @param cardImage the image for the card to use
     */
    public CardTutorial(String cardName, int attack, int defense, ImageView cardImage) {
        this.cardName = cardName;
        this.attack = attack;
        this.defense = defense;
        this.cardImage = cardImage;
        this.cardImage.setFitHeight(240);
        this.cardImage.setFitWidth(148);
    }
    
    /**
     * gets the name of the card
     * @return the name of the card
     */
    public String toString() {
        return this.cardName;
    }
    
    /**
     * getter for the strength of an attack
     * @return attack strength
     */
    public int getAttack() {
        return this.attack;
    }
    
    /**
     * getter for the defense rating
     * @return defense
     */
    public int getDefense() {
        return this.defense;
    }
    
    /**
     * getter for the card image
     * @return image of the card
     */
    public ImageView getCardImage() {
        return this.cardImage;
    }
    
    /**
     * getter for the card tutorial
     * @return tutorial for the card
     */
    public CardTutorial getCardTutorial() {
        return this;
    }
}
