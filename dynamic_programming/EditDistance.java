package dynamic_programming;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for(int i=1; i<=m; i++){
            char a = word1.charAt(i - 1);
            for(int j=1; j<=n; j++){
                char b = word2.charAt(j - 1);
                if(a == b){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int delete = dp[i-1][j];
                    int insert = dp[i][j-1];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(delete, Math.min(insert, replace));
                }
            }
        }
        return dp[m][n];
    }
}
