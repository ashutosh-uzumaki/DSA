package graphs.bfs;

import java.util.*;

class OrangeInfo{
    int row;
    int col;
    int time;

    OrangeInfo(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int freshCnt = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<OrangeInfo> rottenOranges = new ArrayDeque<>();
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 2){
                    rottenOranges.add(new OrangeInfo(row, col, 0));
                }else if(grid[row][col] == 1){
                    freshCnt += 1;
                }
            }
        }
        int maxTime = Integer.MIN_VALUE;
        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, -1, 0, 1};
        while(!rottenOranges.isEmpty()){
            OrangeInfo curr = rottenOranges.poll();
            int row = curr.row;
            int col = curr.col;
            int time = curr.time;
            maxTime = Math.max(time, maxTime);

            for(int i=0; i<4; i++){
                int nRow = rowDir[i] + row;
                int nCol = colDir[i] + col;

                if(nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && grid[nRow][nCol] == 1){
                    grid[nRow][nCol] = 2;
                    freshCnt -= 1;
                    rottenOranges.add(new OrangeInfo(nRow, nCol, time+1));
                }
            }
        }

        if(freshCnt > 0){
            return -1;
        }

        return maxTime == Integer.MIN_VALUE ? 0 : maxTime;
    }
}
