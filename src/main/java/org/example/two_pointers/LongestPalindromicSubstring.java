package org.example.two_pointers;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int startPoint = 0;
        boolean[][] dp = new boolean[n + 1][n + 1];
        for(int length = 1; length <= n; length++){
            for(int i=0; i + length - 1 < n; i++){
                int j = i + length - 1;
                if(i == j){
                    dp[i][j] = true;
                }else if(i + 1 == j){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true);
                }

                if(dp[i][j] == true && maxLen < j - i + 1){
                    maxLen = j - i + 1;
                    startPoint = i;
                }
            }
        }
        String result = s.substring(startPoint, startPoint + maxLen);
        return result;
    }
}
