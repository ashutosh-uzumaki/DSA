package dynamic_programming;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if ((sum + target) % 2 != 0 || sum + target < 0) return 0;
        int P = (sum + target) / 2;
        int[] dp = new int[P + 1];
        dp[0] = 1;
        for(int num: nums){
            for(int j=P; j>=num; j--){
                dp[j] += dp[j - num];
            }
        }

        return dp[P];
    }
}

/*
 * 🎯 TARGET SUM (LC 494) | 0/1 KNAPSACK (COUNTING VARIANT)
 *
 * 🔑 STATE: dp[j] = number of ways to form sum 'j' using processed numbers
 * 🧮 MATH REDUCTION:
 *    P - N = target, P + N = totalSum  =>  2P = totalSum + target  =>  P = (totalSum + target) / 2
 *    Reduces to: "Count subsets that sum exactly to P"
 * ⚠️ CRITICAL CHECK: if ((totalSum + target) % 2 != 0 || totalSum + target < 0) return 0;
 * 🧱 BASE: dp[0] = 1 (one way to make sum 0: pick empty subset)
 * 🔄 TRANSITION: dp[j] += dp[j - num]  (skip + include = accumulate ways)
 * 📏 LOOP ORDER: Outer: num in nums | Inner: j from P DOWN to num (backward → 0/1 property)
 * ⚡ SPACE: O(P) using 1D array
 * 🗣️ 1-LINER: "Convert ± target into subset sum P. Use backward 1D DP to accumulate ways, ensuring each element is used at most once."
 * ❌ BUGS TO AVOID:
 *    - Missing parity/negative check → WA/TLE
 *    - Forward loop → double counts (becomes unbounded knapsack)
 *    - dp[0] = 0 → breaks counting base
 */
