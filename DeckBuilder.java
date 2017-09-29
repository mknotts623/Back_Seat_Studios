import java.util.ArrayList;

/**
 * Takes array of cards, places 40 of them in an arraylist
 * 
 * @Christina Kim 
 * @9/27/17
 */
public class DeckBuilder
{
    ArrayList<CardTutorial> deck;

    public DeckBuilder(CardTutorial[] d) {
        deck = new ArrayList<CardTutorial>();
        
        for(int i = 0; i<40; i++) {
            deck.add(d[i]);
        }
    }
}
