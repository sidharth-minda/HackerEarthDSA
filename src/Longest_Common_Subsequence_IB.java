public class Longest_Common_Subsequence_IB {

    public int solve(String A, String B) {
        char a[] = A.toCharArray();
        char b[] = B.toCharArray();
        int dp[][] = new int[a.length+1][b.length+1];
        for(int i=1;i<=a.length;i++)
        {
            for(int j=1;j<=b.length;j++)
            {
                if(a[i-1]==b[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[a.length][b.length];
    }
}
