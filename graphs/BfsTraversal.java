package graphs;

import java.util.*;

public class BfsTraversal {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(0);

        int V = adj.size();
        boolean[] visited = new boolean[V];
        visited[0] = true;
        while(!queue.isEmpty()){
            int src = queue.poll();
            res.add(src);

            for(Integer nbr: adj.get(src)){
                if(!visited[nbr]){
                    queue.offer(nbr);
                    visited[nbr] = true;
                }
            }
        }
        return res;
    }
}
