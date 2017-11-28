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
        Card[] database = new Card[6];
        //database[0] = new Card("Vampire Thrall", 1, 3, 3, 1, "null"); //image not done
        database[0] = new Card("Incompetent Rioter", 2, 5, 1, 1, "IncompetentRioter.png"); 
        database[1] = new Card("Slime", 3, 1, 5, 1, "Slime Card.png");
        database[2] = new Card("Default Hero", 4, 2, 1, 1,"DefaultHero.png");
        //database[4] = new Card("Just A Guy", 5, 5, 5, 2, "null");//image not done
        //database [5] = new Card("Fledgling Vampire", 6, 7, 3, 2, "null");//image not done
        //database[6] = new Card("Aware Wolf", 7, 3, 7, 2,"null");//image not done
        //database[7] = new Card("Hunter Apprentice", 8, 7, 7, 3,"null");//image not done 
        //database[8] = new Card("Hot Vampire", 9, 9, 5, 3, "null");//image not done
        //database[9] = new Card("Enchanted Armor", 10, 5, 9, 3, "null");//image not done
        //database[10] = new Card("Grumpy Gargoyle", 11, 9, 9, 4, "null");//image not done
        //databse[11] = new Card("Slampire", 12, 11, 7, 4, "null");//image not done
        //database[12] = new Card("Vampire Hunter", 13, 11, 11, 5, "null");//image not done
        database[3] = new Card("Grand Slampire", 14, 13, 9, 5, "Grand Slampire Card.png");
        database[4] = new Card("Raven Wraith", 15, 13, 13, 6, "RavenWraithCard.png");
        database[5] = new Card("The CARE^2", 16, 15, 11, 6, "Care2 Card.png");
        //database[16] = new Card("Count Kramer", 17, 17, 13, 7, "null);//image not done
        return database[n];
    }
}