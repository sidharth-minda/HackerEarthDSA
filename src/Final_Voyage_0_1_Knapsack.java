import java.util.*;
class Final_Voyage_0_1_Knapsack
{
    static int n;
    static int w;
    static int weight[];
    static int value[];
    static int dp[][];
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            n=sc.nextInt();
            w=sc.nextInt();
            weight=new int[n+1];
            for(int i=1;i<=n;i++)
            {
                weight[i]=sc.nextInt();
            }
            
            value=new int[n+1];
            for(int i=1;i<=n;i++)
            {
                value[i]=sc.nextInt();
            }
            dp=new int[n+1][w+1];

            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=w;j++)
                {
                    dp[i][j]=dp[i-1][j];
                    if(j>=weight[i])
                        dp[i][j]=Math.max(dp[i][j], value[i] + dp[i-1][j-weight[i]]);
                }
            }
            System.out.println(dp[n][w]);
            --t;
        }
        sc.close();
    }
}