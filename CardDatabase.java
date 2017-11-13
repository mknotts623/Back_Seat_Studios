
/**
 * Database of all cards in an array
 * 
 * @author Matthew Hurst
 * @version 1
 */
public class CardDatabase
{
 
    public static Card CardDatabase(int n) {
        Card[] database = new Card[3];
        database[0] = new Card("Slime", 0, 0, 2, 1, "slime.png");
        database[1] = new Card("Default Hero", 1, 2, 1, 1,"defaulthero.png");
        database[2] = new Card("Grand Slampire", 2, 13, 9, 5, "grandslampire.png");
        return database[n];
    }
}
