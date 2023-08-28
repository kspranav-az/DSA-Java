package Backtracking;

public class NQueens {

    public static void PrintBoard(char[][] board){
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char[][] board , int row , int col){
        // up
        for(int i = row - 1 ; i >= 0 ; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        // Diagonal left
        for(int i = row-1 , j = col-1 ; i >=0 && j >=0 ; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        // Diagonal Right
        for(int i = row-1 , j = col+1 ; i >=0 && j < board.length ; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens(char[][] board, int row){

        if(row == board.length){
            System.out.println("------------------------");
            PrintBoard(board);
            System.out.println("------------------------");
            return;
        }

        for(int col = 0 ; col < board.length ; col++){

            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                nQueens(board,row+1);
                board[row][col] = 'X';
            }
        }
    }

    public static void main(String[] args){
        int n = 6 ;
        char[][] ChessBoard = new char[n][n];

        for(int i = 0 ; i < ChessBoard.length  ; i++){
            for (int j = 0 ; j < ChessBoard.length ; j++){
                ChessBoard[i][j] = 'X';
            }
        }
        nQueens(ChessBoard,0);
    }
}
