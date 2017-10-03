
/**
 * Database of all cards in an array
 * 
 * @author Matthew Hurst
 * @version 1
 */
public class CardDatabase
{
    public Card[] database = new Card[6];

    public CardDatabase() {
        database[0] = new Card("slime", 0, 0, 2, 1, "slime.png");
    }
}
