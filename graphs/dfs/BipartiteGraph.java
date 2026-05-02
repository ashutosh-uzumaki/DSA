package graphs.dfs;

import java.util.*;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        int currColor = 1;

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(!dfs(i, graph, color, currColor)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int i, int[][] graph, int[] color, int currColor){
        color[i] = currColor;

        for(int nbr: graph[i]){
            if(color[nbr] == -1){
                if(!dfs(nbr, graph, color, 1 - currColor)){
                    return false;
                }
            }else if(color[nbr] == currColor){
                return false;
            }
        }

        return true;
    }
}
