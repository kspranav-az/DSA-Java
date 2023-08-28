package Backtracking;

public class Sudoku {

    public static boolean isSafe(int[][] b ,int r , int c , int num){
        for(int i = 0 ; i < b[0].length ; i++){
            if(b[r][i] == num){
                return false ;
            }
        }
        for (int[] ints : b) {
            if (ints[c] == num) {
                return false;
            }
        }
        int grid_i = (r/3) * 3, grid_j = (c/3) * 3;
        for(int i = grid_i ; i < grid_i + 3 ; i++){
            for (int j = grid_j ; j < grid_j + 3 ; j++){
                if(b[i][j] == num){
                    return false ;
                }
            }
        }
        return true ;
    }
    public static boolean sudokuSolver(int[][] board , int r , int c){

        if(r == board.length){
            return true;
        }
        int nextRow = c + 1 == board.length ? r + 1 : r ,
                nextCol = c + 1 == board.length ? 0 : c + 1 ;

        if(board[r][c] != 0){
            return sudokuSolver(board,nextRow,nextCol) ;
        }

        for(int i = 1 ; i < 10 ; i++){
            if(board[r][c]==0){
                if(isSafe(board,r,c,i)){
                    board[r][c] = i ;
                    if(sudokuSolver(board,nextRow,nextCol)){
                        return true ;
                    }
                    board[r][c] = 0 ;
                }
            }
        }
        return false;
    }

    public static void printBoard(int[][] board){
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print( ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
    public static void main(String[] args){
        int[][] sudoku = {
                {8,6,0,0,2,0,0,0,0},
                {0,0,0,7,0,0,0,5,9},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,6,0,8,0,0},
                {0,4,0,0,0,0,0,0,0},
                {0,0,5,3,0,0,0,0,7},
                {0,0,0,0,0,0,0,0,0},
                {0,2,0,0,0,0,6,0,0},
                {0,0,7,5,0,9,0,0,0}
        };
        printBoard(sudoku);
        sudokuSolver(sudoku,0,0);
        printBoard(sudoku);
    }
}
