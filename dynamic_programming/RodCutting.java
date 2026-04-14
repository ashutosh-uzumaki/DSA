package dynamic_programming;

public class RodCutting {
    public int cutRod(int[] price) {
        int[] dp = new int[price.length + 1];
        for(int i=1; i<=price.length; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i], price[j-1] + dp[i - j]);
            }
        }

        return dp[price.length];
    }
}
