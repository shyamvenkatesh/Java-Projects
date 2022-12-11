import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {    

    public static int numOfMissedGuesses=0;
    public static char[] misses;

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "sppon", "stork", "swan",
    "table", "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {

        Scanner scan =  new Scanner(System.in);
        System.out.println("\t\t*****### Lets play hangman! ### *******");
        System.out.println("\t\t*****### ****************** ### *******");
        String gameWord = randomWord();
        int gameWordNumLetters = gameWord.length();
        System.out.println("* Delete Game word is : "+gameWord);
        char[] gameWordChars = gameWord.toCharArray();

        System.out.println(gallows[0]);
        System.out.print("Word: ");
        for(int i=0 ; i< gameWordNumLetters; i++){
            System.out.print(" _ ");
        }
        System.out.println("\n\n\nMisses:   "+Arrays.toString(misses));
        System.out.print("\n\nGuess:  ");
        char guessChar = scan.next().charAt(0);
        if (checkGuess(gameWord, guessChar)){
            updatePlaceholders();
            printPlaceholders();
            printMissedGuesses();
        }
        else{
            numOfMissedGuesses++;
            misses[numOfMissedGuesses-1] = guessChar;
            printMissedGuesses();
        }

    } // end of main

    
/*randomWord(): returns a random word from the list of random words.

checkGuess(): returns true if the user guessed a letter from the word correctly.

updatePlaceholders(): updates the placeholders when the user makes a correct guess.

printPlaceholders(): prints the placeholders.

printMissedGuesses(): prints guesses that the user missed.*/


    /***
     * Function name : randomWord
     * @param none 
     * Inside the function: pull a random word from the words string array * 
     * @return ramdom word as String
     */
    public static String randomWord(){
        int idx = new Random().nextInt(words.length);    
        return words[idx];
    }

    public static boolean checkGuess(String gameWord, char guessedChar){
        boolean isPresent = false;
        isPresent = gameWord.contains(gameWord);
        return isPresent;
    }

    public static void 

} //end of class





