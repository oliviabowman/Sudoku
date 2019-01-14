
import java.util.Random;

public class randomTable {
    //    public static final int row = 9;
//    public static final int col = 9;
    int row = 9;
    int col = 9;
    public static final int SIZE = 9;
    //    public static final int missing = 10;
//    int missing = 10;
    int[][] board;

    public randomTable(int row, int col) {
        this.row = row;
        this.col = col;
//        this.missing = missing;
        board = new int[row][col];

    }

    public boolean inRow(int row, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean inCol(int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean inSquare(int num, int row, int col) {
        int startOfRow = row - row % 3;
        int startOfCol = col - col % 3;

        for (int i = startOfRow; i < startOfRow + 3; i++) {
            for (int j = startOfCol; j < startOfCol + 3; j++){
                if (board[i][j] == num) {
                    return true;
                }
            }

        }

        return false;
    }

    public boolean isFine (int row, int col, int num) {
        if (!inSquare(num, row, col) && !inRow(row, num) && !inCol(col, num)) {
            return true;
        } else {
            return false;
        }
    }

    public void Fill(){
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                Random rand = new Random();
                int n = rand.nextInt(9) + 1;
                board[i][j] = n;


            }
        }
    }


    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int row = 9;
        int col = 9;
        randomTable board = new randomTable(row, col);
        board.Fill();
        board.print();
    }
}