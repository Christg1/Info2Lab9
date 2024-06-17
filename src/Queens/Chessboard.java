package Queens;

public class Chessboard {
    private int size;
    private int[][] board;

    public Chessboard(int size) {
        this.size = size;
        this.board = new int[size][size];
    }

    public void placeQueen(int row, int col) {
        board[row][col] = 1;
    }

    public void removeQueen(int row, int col) {
        board[row][col] = 0;
    }

    public boolean isSafe(int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < size; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public boolean solve(int row) {
        if (row >= size) {
            return true; // All queens are placed
        }

        for (int col = 0; col < size; col++) {
            if (isSafe(row, col)) {
                placeQueen(row, col);
                if (solve(row + 1)) {
                    return true;
                }
                removeQueen(row, col); // Backtrack
            }
        }

        return false; // No solution found for this configuration
    }

    public void printSolutions() {
        if (!solve(0)) {
            System.out.println("No solutions found");
        } else {
            System.out.println("Found solution(s):");
            printBoard();
        }
    }

    private void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard(8);
        chessboard.printSolutions();
    }
}
	