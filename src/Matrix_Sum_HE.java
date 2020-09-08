import java.util.*;
public class Matrix_Sum_HE
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int arr[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        int dp[][]=new int[m+1][n+1];
        for(int j=1;j<=n;j++)
        {
            dp[1][j]=dp[1][j-1]+arr[1][j];
        }
        for(int i=1;i<=m;i++)
        {
            dp[i][1]=dp[i-1][1]+arr[i][1];
        }
        for(int i=2;i<=m;i++)
        {
            for(int j=2;j<=n;j++)
            {
                dp[i][j]=dp[i-1][j]+dp[i][j-1]+arr[i][j]-dp[i-1][j-1];
            }
        }
        int q=sc.nextInt();
        while(q>0)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(dp[a][b]);
            --q;
        }
        sc.close();
    }
}