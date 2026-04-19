package graphs.bfs;

import java.util.*;

public class MultiSourceBFSFloodFill {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distances = new int[n][m];
        for(int[] row: distances){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int[] source: sources){
            queue.add(new int[] {source[0], source[1]});
            grid[source[0]][source[1]] = source[2];
            distances[source[0]][source[1]] = 0;
        }

        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int[] source = queue.poll();
            int row = source[0];
            int col = source[1];
            int currColor = grid[row][col];
            int distance = distances[row][col];

            for(int i=0; i<4; i++){
                int nr = row+rowDir[i];
                int nc = col+colDir[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    if(distances[nr][nc] > (distance + 1)){
                        grid[nr][nc] = currColor;
                        distances[nr][nc] = distance + 1;
                        queue.add(new int[] {nr, nc});
                    }else if(distances[nr][nc] == (distance + 1) && grid[nr][nc] < currColor){
                        grid[nr][nc] = currColor;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return grid;
    }

}
