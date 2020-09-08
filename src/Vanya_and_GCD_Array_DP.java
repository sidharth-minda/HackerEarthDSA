import java.util.*;
class Vanya_and_GCD_Array_DP
{
    static int arr[];
    static long dp[][][];
    static int n;
    static int mod;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr = new int[n+1];
        dp = new long[n+1][101][101];
        for(int i=1;i<=n;i++)
        {
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=100;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        long count = 0;
        mod = 1000000007;
        count = dfs(1,0,0);
        System.out.println(count % mod);
    }

    public static long dfs(int num, int g, int maxi)
    {
        if(num==n+1)
        {
            if(g==1)
                return 1;
            else
                return 0;
        }
        if(dp[num][g][maxi] != -1)
            return dp[num][g][maxi];

        //dp[num][g] = (dfs(num+1, g, ) + dfs(num+1, gcd(arr[num], g))) % mod;
        long tot = dfs(num+1, g, maxi);
        if(arr[num] > maxi)
        {
            if(g == 0)
                tot += dfs(num+1, arr[num], arr[num]);
            else
                tot += dfs(num+1, gcd(arr[num], g), arr[num]);
        }
        return dp[num][g][maxi] = tot;
    }

    public static int gcd(int a, int b)
    {
        if(b==0)
            return a;
        return gcd(b, a % b);
    }
}