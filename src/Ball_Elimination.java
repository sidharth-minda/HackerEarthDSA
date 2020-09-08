/*
 
You have a sequence of balls. Every ball has a color. You can eliminate any single ball and pay one pound. Also you can eliminate any two neighboring balls which have the same colors for no cost.
Find minimal amount you need to spend to eliminate all balls.

Input Format:
First line contains single integer n -- number of balls.
Second line contains n space-separated integers  -- colors of balls.

Output Format:
Single integers -- minimal cost of elimination of all balls.


SAMPLE INPUT 
3
2 1 2
SAMPLE OUTPUT 
1

*/

import java.util.*;
public class Ball_Elimination
{
    static int arr[];
    static int dp[][];
    static int n;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        dp=new int[n][n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(dfs(0, n-1));
        sc.close();
    }
    
    public static int dfs(int i, int j)
    {
        if(i>j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        dp[i][j]=1+dfs(i+1,j);
        for(int k=i+1;k<=j;k++)
        {
            if(arr[i]==arr[k])
            {
                dp[i][j]=Math.min(dp[i][j], dfs(i+1, k-1) + dfs(k+1,j));
            }
        }
        return dp[i][j];
    }
}