package recursion_and_backtracking;

import java.util.*;

public class CombinationSumTwo {
    class Solution {
        List<List<Integer>> ans;
        int[] candidates;
        int target;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            ans = new ArrayList<>();
            this.candidates = candidates;
            Arrays.sort(this.candidates);
            this.target = target;
            helper(0, 0, new ArrayList<>());
            return ans;
        }

        private void helper(int idx, int currSum, List<Integer> path) {
            if (currSum == target) {
                ans.add(new ArrayList<>(path));
                return; // All numbers > 0, so no need to continue
            }

            for (int i = idx; i < candidates.length; i++) {
                if (i > idx && candidates[i] == candidates[i - 1]) continue;

                if (currSum + candidates[i] > target) break;

                path.add(candidates[i]);
                helper(i + 1, currSum + candidates[i], path);
                path.remove(path.size() - 1);
            }
        }
    }
}
