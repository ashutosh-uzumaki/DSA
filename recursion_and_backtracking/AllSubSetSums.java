package recursion_and_backtracking;

import java.util.*;

public class AllSubSetSums {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        helper(0, 0, arr, ans);
        return ans;
    }

    private void helper(int idx, int currSum, int[] arr, List<Integer> ans){
        ans.add(currSum);

        for(int i=idx; i<arr.length; i++){
            helper(i + 1, currSum + arr[i], arr, ans);
        }
    }
}
