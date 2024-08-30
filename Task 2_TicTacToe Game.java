import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char player = 'X';
        int turns = 0;
        while (turns < 9) {
            printBoard();
            System.out.println("Player " + player + "'s turn. Enter row and column (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                if (checkWin(player)) {
                    printBoard();
                    System.out.println("Player " + player + " wins!");
                    return;
                }
                player = (player == 'X') ? 'O' : 'X';
                turns++;
            } else {
                System.out.println("Cell already taken. Try again.");
            }
        }
        printBoard();
        System.out.println("It's a draw!");
    }
}
