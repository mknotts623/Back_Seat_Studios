/**
 * Database of all cards in an array
 * 
 * commented-out database entries do not yet have images, but are put in order so they may be easily corrected later
 * when images are added, array indicies and image names will need to be corrected
 * @author Matthew Hurst
 * @version 1
 */
public class CardDatabase
{
    //variables passed in card: name, index, attack, defense, cost, image;

    public static Card CardDatabase(int n) {
        Card[] database = new Card[16];
        database[0] = new Card("Vampire Thrall", 1, 3, 3, 1, "Vampire\'s Thrall .png");
        database[1] = new Card("Incompetent Rioter", 2, 5, 1, 1, "IncompetentRioter.png"); 
        database[2] = new Card("Slime", 3, 1, 5, 1, "Slime.png");
        database[3] = new Card("Default Hero", 4, 5, 5, 2,"Default Hero.png");
        database[4] = new Card("Fledgling Vampire", 6, 7, 3, 2, "Fledgeling Vampire.png");
        database[5] = new Card("Awarewolf", 7, 3, 7, 2,"Awarewolf.png");
        database[6] = new Card("Hunter Apprentice", 8, 7, 7, 3,"Hunter\'s Apprentice.png"); 
        database[7] = new Card("Hot Vampire", 9, 9, 5, 3, "Hot Vampire.png");
        database[8] = new Card("Enchanted Armor", 10, 5, 9, 3, "Enchanted Armor.png");
        database[9] = new Card("Grumpy Gargoyle", 11, 9, 9, 4, "GrumpyGargoyle.png");
        database[10] = new Card("Slampire", 12, 11, 7, 4, "Slampire.png");
        database[11] = new Card("Vampire Hunter", 13, 11, 11, 5, "Vampire Hunter.png");
        database[12] = new Card("Grand Slampire", 14, 13, 9, 5, "Grand Slampire.png");
        database[13] = new Card("Raven Wraith", 15, 13, 13, 6, "RavenWraith.png");
        database[14] = new Card("The CARE^2", 16, 15, 11, 6, "Care2.png");
        database[15] = new Card("Count Kramer", 17, 17, 13, 7, "Count Kramer.png");
        return database[n];
    }
}