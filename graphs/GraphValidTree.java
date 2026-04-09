package graphs;

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // Check cycle
        if(!dfs(0, -1, visited, adj)){
            return false;
        }

        // Check connectivity
        for(boolean v : visited){
            if(!v) return false;
        }

        return true;
    }

    private boolean dfs(int src, int par, boolean[] visited, List<List<Integer>> adj){
        visited[src] = true;

        for(Integer nbr: adj.get(src)){
            if(!visited[nbr]){
                if(!dfs(nbr, src, visited, adj)){
                    return false;
                }
            } else if(nbr != par){
                return false; // cycle
            }
        }

        return true;
    }
}
