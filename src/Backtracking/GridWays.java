package Backtracking;

public class GridWays {

    public static void main(String[] args){
        int[][] grid =
                {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
                };
        int ways = gridWays(grid,0,0 , 2 , 4);

        System.out.println(ways);
    }

    private static int gridWays(int[][] grid, int r, int c , int tr , int tc) {

        // Base Case

        if (r == tr  && c == tc ) {
            return 1 ;
        }
        if( r>=grid.length || c >=grid[0].length){
            return 0 ;
        }

        // BackTracking

        int r_ways = gridWays(grid,r+1,c , tr , tc);
        int l_ways = gridWays(grid,r,c+1, tr , tc);

        return r_ways + l_ways ;
    }
}
