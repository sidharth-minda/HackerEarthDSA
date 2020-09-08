import java.util.*;
public class Longest_Increasing_Subsequence_GG
{
    static int n;
    static int arr[];
    static int dp[][];
    public static void main (String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            n = sc.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.nextInt();
            }
            dp = new int[n][301];
            for(int i=0;i<n;i++)
            {
                Arrays.fill(dp[i], -1);
            }
            System.out.println(dfs(0,0));
            --t;
        }
    }

    public static int dfs(int num, int maxi)
    {
        if(num==n)
            return 0;
        if(dp[num][maxi] != -1)
            return dp[num][maxi];

        dp[num][maxi] = dfs(num+1, maxi);
        if(arr[num] > maxi || maxi == 0)
            dp[num][maxi] = Math.max(dp[num][maxi], 1 + dfs(num+1, arr[num]));
        return dp[num][maxi];
    }
}