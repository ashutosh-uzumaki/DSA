package recursion_and_backtracking;

import java.util.*;

public class Subset {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        helper(0, new ArrayList<>(), nums);
        return ans;
    }

    private void helper(int idx, List<Integer> path, int[] nums){
        ans.add(new ArrayList<>(path));
        for(int i=idx; i<nums.length; i++){
            path.add(nums[i]);
            helper(i + 1, path, nums);
            path.remove(path.size() - 1);
        }
    }
}
