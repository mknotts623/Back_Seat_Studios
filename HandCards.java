import java.util.ArrayList;
/**
 * Add and remove cards from hand (an ArrayList of CardTutorials)
 * 
 * @Christina Kim
 * @9/29/17
 */
public class HandCards
{
    ArrayList<CardTutorial> hand;
    
    public HandCards() {
        hand = new ArrayList<CardTutorial>();
    }
    
    public void addCard(DeckBuilder d) {
        hand.add(d.drawCard());
    }
    public CardTutorial playCard(CardTutorial c) {
        hand.remove(c);
        return c;
    }
}
