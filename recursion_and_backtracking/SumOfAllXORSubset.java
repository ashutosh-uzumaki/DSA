package recursion_and_backtracking;

public class SumOfAllXORSubset {
    private int totalSum; // 👈 Class-level field

    public int subsetXORSum(int[] nums) {
        totalSum = 0; // Reset
        helper(0, 0, nums);
        return totalSum;
    }

    private void helper(int idx, int currXor, int[] nums) {
        totalSum += currXor; // 👈 Modifies the field directly

        for (int i = idx; i < nums.length; i++) {
            helper(i + 1, currXor ^ nums[i], nums); // 👈 XOR accumulates naturally
        }
    }
}
