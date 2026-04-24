package graphs.dfs;

public class MaxAreaOfIsland {
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        rows = grid.length;
        cols = grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    int currPathArea = findAreaHelper(i, j, grid);
                    maxArea = Math.max(maxArea, currPathArea);
                }
            }
        }
        return maxArea;
    }

    private int findAreaHelper(int row, int col, int[][] grid){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;

        int upWardMove = findAreaHelper(row - 1, col, grid);
        int downWardMove = findAreaHelper(row + 1, col, grid);
        int leftWardMove = findAreaHelper(row, col - 1, grid);
        int rightWardMove = findAreaHelper(row, col + 1, grid);

        return 1 + upWardMove + downWardMove + leftWardMove + rightWardMove;
    }
}
