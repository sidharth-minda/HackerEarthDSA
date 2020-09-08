public class Longest_Repeating_Subsequence_IB {

    public int anytwo(String A) {

        char c[] = A.toCharArray();
        int n = A.length();
        int dp[][] = new int[n+1][n+1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(c[i-1] == c[j-1] && i!=j)
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][n];
    }

}
