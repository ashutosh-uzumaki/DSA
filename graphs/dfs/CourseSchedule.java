package graphs.dfs;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite: prerequisites){
            int x = prerequisite[1];
            int y = prerequisite[0];

            adj.get(x).add(y);
        }

        int[] state = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            if(state[i] == 0){
                if(dfs(i, state, adj)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int src, int[] state, List<List<Integer>> adj){
        state[src] = 1;

        for(int nbr: adj.get(src)){
            if(state[nbr] == 0){
                if(dfs(nbr, state, adj)){
                    return true;
                }
            }else if(state[nbr] == 1){
                return true;
            }
        }

        state[src] = 2;
        return false;
    }
}
