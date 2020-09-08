import java.util.*;
class Collecting_Apples_DP
{
    static int milk[];
    static int apple[];
    static int dp[][];
    static int n;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0)
        {
            n=sc.nextInt();
            long enrg = sc.nextLong();
            milk = new int[n];
            apple = new int[n];
            dp = new int[n][n+1];
            for(int i=0;i<n;i++)
            {
                milk[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                apple[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                Arrays.fill(dp[i], -1);
            }
            if(enrg>n)
                enrg = n;
            int e = (int) enrg;
            System.out.println(dfs(0, --e));
        }
    }

    public static int dfs(int num, int e)
    {
        if(num == n || e<0)
            return 0;
        if(dp[num][e] != -1)
            return dp[num][e];
        int k = e-1+milk[num];
        dp[num][e] = dfs(num+1, k>n?n:k);
        if(e > 0)
            dp[num][e] = Math.max(dp[num][e], apple[num] + dfs(num+1, e-1));

        return dp[num][e];
    }
}