import java.util.Scanner;

public class Javapedia {
    public static void main (String[] args) {
    
        //Task1: Ask the user: How many historical figures will you register?. 
        // Store the value in an int variable.

        Scanner scan = new Scanner(System.in);
        System.out.print("How many historical figures will you register? ");
        int num = scan.nextInt();
        scan.nextLine();
        //Task2: Make a 2D array named: database. 
        // The data we're going to submit will take the form of a table.

        String[][] database = new String[100][3];

        //Task3: Create a for loop that runs through every row in the database. 
        //The user needs to submit three values per row.

        for (int i=0; i< num; i++){
            System.out.println("Historical Figure "+(i+1));
            for(int j=0; j< database[i].length; j++){
                switch(j){
                    case 0 : System.out.print("\t. Name: "); break;
                    case 1 : System.out.print("\t. DOB: "); break;
                    case 2 : System.out.print("\t. Occupation: "); break;
                }             
                
                String valueInput = scan.nextLine();
                database[i][j] = valueInput;
            }
        }
        System.out.println("These are the values you stored:");
        print2DArray(database, num);

        System.out.print("\nWho do you want information on? ");
        String searchString = scan.nextLine();
        searchDatabase(database, searchString, num);
        scan.close();
    }

    /** 
     * Function name: searchDatabase
     * @param array (String[][])
     * @param searchString (String)
     * @param number (int)
     * Inside the function
     *  1. loops through the database and checks if the search string matches any of the rows in name columns
     *  2. if found, print the row in the prescribed fashion.
     * 
     */
    
    public static void searchDatabase(String[][] inputArray, String search, int number){
        for (int i=0; i<number; i++ ){
            if(inputArray[i][0].equalsIgnoreCase(search)){
                for(int j=0; j<inputArray[i].length; j++){
                    switch(j){
                        case 0: System.out.print("\tName: ");break; 
                        case 1: System.out.print("\tDOB: ");break; 
                        case 2: System.out.print("\tOccupation: ");break; 
                    }
                    System.out.println(inputArray[i][j]);
                }
            }
        }
    }

/**
 * Function name: print2DArray
 * @param array (String[][])
 *
 * Inside the function
 *  1. print the database
 *   - a tab of space precedes each row.
 *   - each value in database has one space from the other value.
 */
    public static void print2DArray(String[][] inputArray, int num){        
        for (int i=0 ; i< num; i++){
            System.out.print("\n\t");
            for(int j=0; j< inputArray[i].length; j++){
                System.out.print(inputArray[i][j]+ " ");
            }
        }
    }

}
