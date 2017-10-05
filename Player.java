
/**
 * Basic class containing player health, deck, and hand
 * 
 * @author Christina Kim 
 * @version 10/5/17
 */
public class Player
{
    int health;
    DeckBuilder playDeck;
    HandCards playHand;

    /**
     * Constructor for objects of class Player
     * @param h The amount of health the player has
     * @param d The DeckBuilder holding the player's deck of cards
     * @param c The player's hand of cards
     */
    public Player(int h, DeckBuilder d, HandCards c)
    {
        health = h;
        playDeck = d;
        playHand = c;
    }

    /**
     * Getter for health
     * @return The player's health value
     */
    public int getHealth() {
        return health;
    }
    /**
     * Setter for health
     * @param h The player's new health value
     */
    public void setHealth(int h) {
        health = h;
    }
    /**
     * Getter for player's deck
     * @return The player's deck
     */
    public DeckBuilder getDeck() {
        return playDeck;
    }
    /**
     * Setter for player's deck
     * @param d A DeckBuilder containing the player's deck
     */
    public void setDeck(DeckBuilder d) {
        playDeck = d;
    }
    /**
     * Getter for player's hand of cards
     * @return the player's hand
     */
    public HandCards getHand() {
        return playHand;
    }
    /**
     * Setter for player's hand of cards
     * @param c the new hand of cards
     */
    public void setHand(HandCards c) {
        playHand = c;
    }
}
