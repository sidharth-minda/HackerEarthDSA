public class Longest_Palindromic_Subsequence_IB {

    public int solve(String A) {
        char c[] = A.toCharArray();
        int n = A.length();
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            dp[i][i]=1;
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=i+1;j<n;j++)
            {
                if(c[i] != c[j])
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);

                else if((j-i) == 1)
                    dp[i][j] = 2;

                else
                    dp[i][j] = 2 + dp[i+1][j-1];
            }
        }
        return dp[0][n-1];
    }
}
