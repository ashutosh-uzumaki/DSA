package graphs.dfs;

import java.util.*;

public class CycleInUndirectedGraph {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(hasCycle(i, -1, adjList, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(int src, int parent, List<List<Integer>> adjList, boolean[] visited){
        visited[src] = true;

        for(Integer nbr: adjList.get(src)){
            if(!visited[nbr]){
                if(hasCycle(nbr, src, adjList, visited)){
                    return true;
                }
            }else if(nbr != parent){
                return true;
            }
        }
        return false;
    }
}
