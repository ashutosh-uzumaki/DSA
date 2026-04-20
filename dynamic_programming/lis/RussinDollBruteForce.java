package dynamic_programming.lis;

import java.util.*;

public class RussinDollBruteForce {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)->{
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        int maxLen = 1;
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
            }
        }

        return maxLen;
    }
}
