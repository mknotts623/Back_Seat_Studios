import java.util.ArrayList;

/**
 * Takes array of cards, places 40 of them in an arraylist
 * 
 * @Christina Kim 
 * @9/30/17
 */
public class DeckBuilder
{
    Stack<Card> deck;
    /**
     * Constructor for objects of class DeckBuilder
     * @param d Array of Cards used as database
     */
    public DeckBuilder(Card[] d) {
        deck = new Stack<Card>();
        
        for(int i = 0; i<40; i++) {
            deck.push(d[i]);
        }
    }
    
    /**
     * Gives player top Card from deck to place in hand, pops that card off of deck
     * @return top Card from Stack<card> deck
     */
    public Card drawCard() {
        return deck.pop();
    }
    
}
