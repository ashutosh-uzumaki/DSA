package dynamic_programming;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int start = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(i == j){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = ((s.charAt(i) == s.charAt(j)) && (j - i < 2 || dp[i + 1][j - 1]));
                }

                if(dp[i][j] && (maxLen < j - i + 1)){
                    maxLen = Math.max(maxLen, j - i + 1);
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
