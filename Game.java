import java.util.Random;
import java.util.Scanner;

public class Game {
    //              Objects
    public static char player;
    public static boolean game=true,CanMove = true;
    public static int move=0, count=0 ,RandNumber=0;
    public static char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'},
    };



    //                   Voids
    public static void checkWin(char[][] board) {
        // Check rows
        if (board[0][0] == player && board[0][1] == player && board[0][2] == player) {
            System.out.println("Player " + player + " has won! Congratulations!");
            System.exit(0);
        } else if (board[1][0] == player && board[1][1] == player && board[1][2] == player) {
            System.out.println("Player " + player + " has won! Congratulations!");
            System.exit(0);
        } else if (board[2][0] == player && board[2][1] == player && board[2][2] == player) {
            System.out.println("Player " + player + " has won! Congratulations!");
            System.exit(0);
        } else if (board[0][0] == player && board[1][0] == player && board[2][0] == player) {
            System.out.println("Player " + player + " has won! Congratulations!");
            System.exit(0);
        } else if (board[0][1] == player && board[1][1] == player && board[2][1] == player) {
            System.out.println("Player " + player + " has won! Congratulations!");
            System.exit(0);
        } else if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
            System.out.println("Player " + player + " has won! Congratulations!");
            System.exit(0);
        } else if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            System.out.println("Player " + player + " has won! Congratulations!");
            System.exit(0);
        } else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            System.out.println("Player " + player + " has won! Congratulations!");
            System.exit(0);
        }
    }




    public static void placePlayer(char player, int position) {
        int row = (position - 1) / 3; // Calculate row number
        int col = (position - 1) % 3; // Calculate column number

        if (board[row][col] >= '1' && board[row][col] <= '9') {
            // Space is empty, player can make their move
            board[row][col] = player;
            CanMove=true;
            count++;
        } else {
            // Space is already occupied
            System.out.println("This space is already occupied.");
            System.out.println();
            CanMove=false;
        }
    }


    public static void DrawCheck() {
        if (count==9) {
            System.out.println("Draw! Game over!");
            game=false;
        }
    }

    static void change() {
        if (CanMove) {
            player = (player == 'X') ? 'O' : 'X';
        }
    }

    static void DrawBoard(char[][] b){
        System.out.println("  "+b[0][0]+"  #  "+b[0][1]+"  #  "+b[0][2]);
        System.out.println("#################");
        System.out.println("  "+b[1][0]+"  #  "+b[1][1]+"  #  "+b[1][2]);
        System.out.println("#################");
        System.out.println("  "+b[2][0]+"  #  "+b[2][1]+"  #  "+b[2][2]);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        RandNumber = rand.nextInt(2);
        if (RandNumber==1) player = 'X';
        else player = 'O';
        while (game) {
            DrawBoard(board);
            System.out.println("You are player " + player + ". Choose position: ");
            move = scanner.nextInt();
            for (int i = 0; i < 9; i++) {
                System.out.println();
            }
            placePlayer(player, move);
            checkWin(board);
            DrawCheck();
            change();
        }
    }
}