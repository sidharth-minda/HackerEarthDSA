import java.util.*;
class Bino_Sum_Pascal_Triangle
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        long dp[][]=new long[1001][1001];
        long mod=1000000009;
        for(int i=0;i<=1000;i++)
        {
            dp[i][0]=1;
            dp[i][i]=1;
        }
        for(int i=1;i<=1000;i++)
        {
            for(int j=1;j<=i;j++)
            {
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % mod;
            }
        }
        while(t>0)
        {
            int n=sc.nextInt();
            int p=sc.nextInt();
            long sum=0l;
            for(int i=0;i<=p;i++)
            {
                sum=(sum+dp[n][i])%mod;
            }
            System.out.println(sum);
            --t;
        }
        sc.close();
    }
}