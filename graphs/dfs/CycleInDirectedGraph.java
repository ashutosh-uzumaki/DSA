package graphs.dfs;

import java.util.*;

public class CycleInDirectedGraph {
    public boolean isCyclic(int V, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        // code here
        int[] state = new int[V];
        for(int i=0; i<V; i++){
            if(state[i] == 0 && dfs(i, adj, state)){
                return true;
            }
        }
        return false;
    }
    private boolean dfs(int i, List<List<Integer>> adj, int[] state){
        state[i] = 1;

        for(int nbr: adj.get(i)){
            if(state[nbr] == 0){
                if(dfs(nbr, adj, state))return true;
            }else if(state[nbr] == 1){
                return true;
            }
        }

        state[i] = 2;
        return false;
    }
}
