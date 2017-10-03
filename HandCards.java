import java.util.ArrayList;
/**
 * Add and remove cards from hand (an ArrayList of Cards)
 * 
 * @author Christina Kim
 * @version 9/30/17
 */
public class HandCards
{
    ArrayList<Card> hand;
    
    /**
     * Constructor for objects of class HandCards
     */
    public HandCards() {
        hand = new ArrayList<Card>();
    }
    
    /**
     * Adds Card from top of Stack<Card> deck to hand ArrayList
     * @param d DeckBuilder used to assemble and hold the deck to be played
     */
    public void addCard(DeckBuilder d) {
        hand.add(d.drawCard());
    }
    
    /**
     * Removes Card from ArrayList, returns card to be used in play
     * @param c Selected Card to be played
     * @return Selected Card once removed from ArrayList
     */
    public Card playCard(Card c) {
        hand.remove(c); //note to self: research ArrayList to double check that this actually works
        return c;
    }
    
}
