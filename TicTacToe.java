import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    static int maxTurns = 9;
    public static void main(String[] args) {
        
        //Task 1: Create an array
        char[][] board = new char[3][3];

        for (int i=0; i< board.length; i++){
            for (int j=0; j<board[i].length; j++){
                board[i][j] = '_';
            }
        }

        //Task 2 : Print the board
        System.out.println("Lets Play TicTacToe!");
        printBoard(board);
        
        char[] turns = new char[maxTurns];

        //Task 3 : Taking turns        
        for (int i =0; i<maxTurns ; i++){
            if(i%2 == 0){
                turns[i]='X';
            }
            else{
                turns[i]='O';
            }
        }

        for (int i =0; i<maxTurns ; i++){
            System.out.println("Turn: "+turns[i]);
            if (turns[i] == 'X') {
                int[] X_pos = askUser(board);
                populateBoard(board, X_pos, 'X');
                printBoard(board);
            } else {
                int[] O_pos = askUser(board);
                populateBoard(board, O_pos, 'O');
                printBoard(board);
            }
            int points = checkWin(board);
            if (points == 3) {
                System.out.println("X wins !!");
                break;
              } else if (points == -3){
                System.out.println("O wins !!");
                break;
              }
                
        }
    }

    public static void populateBoard(char[][] board, int[] pos, char ch){
        board[pos[0]][pos[1]] = ch;
    }

/**
 * Function name -- askUser <-------
 * @param board (char[][] board)
 * @return spot (int[])
 *
 * Inside the function
 *     1. Asks the user: - pick the row and column:
 *     2. If the spot is taken, ask the user to choose again.
 *     3. Return the row and column in an int[] array.
 *
 */
    public static int[] askUser(char[][] board){
        int[] pos = new int[2];
        System.out.print("Pick a row and column: ");        
        pos[0] = scan.nextInt();
        pos[1] = scan.nextInt();
        while(pos[0] >2 && pos[1] > 2){
            System.out.print("Please enter valid positions: ");
            pos[0] = scan.nextInt();
            pos[1] = scan.nextInt();
        }
        while(board[pos[0]][pos[1]]!='_'){
            System.out.print("Spot taken, try again: ");
            pos[0] = scan.nextInt();
            pos[1] = scan.nextInt();
        }    
        return pos;    
    }

/**
 * Function name - printBoard()
 * @param board (char[][])
 *
 * Inside the function:
 *   1. print a new line.
 *   2. print the board.
 *    - separate each row by two lines.
 *    - each row precedes a tab of space
 *    - each character in the grid has one space from the other character
  */
    public static void printBoard(char[][] array){
        for (int i=0; i< array.length; i++){
            System.out.print("\n\n\t");
            for (int j=0; j<array[i].length; j++){
                System.out.print(array[i][j]+ " ");
            }
        }
        System.out.println("\n");
    }

/**
 * Function name - checkWin <-------
 * @param board (char[][])
 * @return count (int)
 *
 * Inside the function:
 *   1. Make a count variable that starts at 0.
 *   2. Check every row for a straight X/O  (Task 7)
 *   3. Check every column for a straight X/O  (Task 8)
 *   4. Check the left diagonal for a straight X/O  (Task 9).
 *   5. Check the right diagonal for a straight X/O  (Task 10).
 */
public static int checkWin(char[][] board){
    int count = 0;
    
    for (int i = 0; i < 3; i++){
        count = 0; // reset
        //every row
        for (int j=0; j< 3; j++){
            if (board[i][j] == 'X') {
                count++;
            }
            else if (board[i][j] == 'O'){
                count--;
            }
        }
        if (count == 3 || count == -3)return count;
    }
    
        //every column
        for (int i = 0; i < 3; i++){
            count = 0; // reset
            for (int j=0; j< 3; j++){
                if (board[j][i] == 'X') {
                    count++;
                }
                else if (board[j][i] == 'O'){
                    count--;
                }
            }
            if (count == 3 || count == -3)return count;
        }
        count = 0;//reset
        //left diagonal 00, 11, 22
        for (int i = 0; i < 3; i++){
            if(board[i][i] == 'X'){
                count ++;
            }
            else if (board[i][i] == 'O'){
                count --;
            }
            if (count == 3 || count == -3)return count;
        }
        count = 0;
        //right diagonal - 02, 11, 20
        for (int i = 0; i < 3; i++){
            if(board[2-i][i] == 'X'){
                count ++;
            }
            else if (board[2-i][i] == 'O'){
                count --;
            }
            if (count == 3 || count == -3)return count;
        }      
        
    return count;
    }
}
