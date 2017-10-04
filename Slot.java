//By Josh Fickes
public class Slot //To be used in a 2D array in the main program.
{
    String location; //"hand" or "field"
    int player; //1 or 2
    Card whatCard = null;
        
    Slot(String whereItAt, int whoOwnsIt, Card whatCardIsInIt) {
        location = whereItAt;
        player = whoOwnsIt;
        whatCard = whatCardIsInIt;
    }
    
    public String getLocation() {
        return location;
    }
    public void setLocation(String whereItAt) {
        location = whereItAt;
    }
    public int getPlayer() {
        return player;
    }
    public void setPlayer(int whoOwnsIt) {
        player = whoOwnsIt;
    }
    public Card getCard() {
        return whatCard;
    }
    public void setCard(Card whatCardIsInIt) {
        whatCard = whatCardIsInIt;
    }
}
