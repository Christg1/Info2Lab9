package Queens;
import java.util.Arrays;
import java.util.Iterator;
public class Queens {
	
	public static void main(String[] args) {
		int [][] chessboard= new int [7][7];
		fillboard(chessboard);
		printboard(chessboard);
		printRowAndColumnIndices(chessboard);

		}
	
	
	public static void fillboard(int chessboard [][]) {
		for(int i=0; i < chessboard.length; i++) {
			for(int j=0; j< chessboard[i].length;j++) {
				chessboard[i][j]=-1;
				
			}
			
		}
		
	}

	public static void printboard(int [][] board) {
		for(int i=0; i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+" ");
		
			}
			System.out.println();
		}
		
		
	}
	public static void printRowAndColumnIndices(int[][] matrix) {
        System.out.println("Row and Column indices:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + i + "][" + j+"],");
            }
            System.out.println();
        }
    }

}
