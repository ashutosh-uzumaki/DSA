package graphs.dfs;

import java.util.*;

public class CourseScheduleOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());

        for(int[] p : prerequisites){
            indegree[p[0]]++;
            adj.get(p[1]).add(p[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            order[idx++] = curr;

            for(int nbr : adj.get(curr)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }

        return idx == numCourses ? order : new int[0];
    }
}
