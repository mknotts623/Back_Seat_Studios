import java.util.ArrayList;

/**
 * Takes array of cards, places 40 of them in an arraylist
 * 
 * @Christina Kim 
 * @9/27/17
 */
public class DeckBuilder
{
    Stack<CardTutorial> deck;

    public DeckBuilder(CardTutorial[] d) {
        deck = new Stack<CardTutorial>();
        
        for(int i = 0; i<40; i++) {
            deck.push(d[i]);
        }
    }
    
    public CardTutorial drawCard() {
        return deck.pop();
    }
}
