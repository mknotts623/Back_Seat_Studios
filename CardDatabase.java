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
    //variables passed in card: name, index, attack, defense, cost, image, is permanent;

    public static Card CardDatabase(int n) {
        Card[] database = new Card[18];
        database[0] = new Card("Vampire Thrall", 1, 3, 3, 1, "Vampire's Thrall.png",true);
        database[1] = new Card("Incompetent Rioter", 2, 5, 1, 1, "IncompetentRioter.png",true); 
        database[2] = new Card("Slime", 3, 1, 5, 1, "Slime.png",true);
        database[3] = new Card("Default Hero", 4, 5, 5, 2,"Default Hero.png",true);
        database[4] = new Card("Fledgling Vampire", 6, 7, 3, 2, "Fledgeling Vampire.png",true);
        database[5] = new Card("Awarewolf", 7, 3, 7, 2,"Awarewolf.png",true);
        database[6] = new Card("Hunter Apprentice", 8, 7, 7, 3,"Hunter's Apprentice.png",true); 
        database[7] = new Card("Hot Vampire", 9, 9, 5, 3, "Hot Vampire.png",true);
        database[8] = new Card("Enchanted Armor", 10, 5, 9, 3, "Enchanted Armor.png",true);
        database[9] = new Card("Grumpy Gargoyle", 11, 9, 9, 4, "GrumpyGargoyle.png",true);
        database[10] = new Card("Slampire", 12, 11, 7, 4, "Slampire.png",true);
        database[11] = new Card("Vampire Hunter", 13, 11, 11, 5, "Vampire Hunter.png",true);
        database[12] = new Card("Grand Slampire", 14, 13, 9, 5, "Grand Slampire.png",true);
        database[13] = new Card("Raven Wraith", 15, 13, 13, 6, "RavenWraith.png",true);
        database[14] = new Card("The CARE^2", 16, 15, 11, 6, "Care2.png",true);
        database[15] = new Card("Count Kramer", 17, 17, 13, 7, "Count Kramer.png",true);
        database[16] = new Card("Rest In P3ace", 18, 0, 0, 8, "Rest In P3ace.png", false);
        database[17] = new Card("Junior Research", 19, 0, 0, 3, "Junior Research.png", false); 
        return database[n];
    }
}