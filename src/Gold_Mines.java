import java.util.*;
class Gold_Mines
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                arr[i][j]=sc.nextInt();
                arr[i][j]+=arr[i][j-1];
            }
        }
        int q=sc.nextInt();
        while(q>0)
        {
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            long sum=0l;
            for(int i=x1;i<=x2;i++)
            {
                sum+=arr[i][y2] - arr[i][y1-1];
            }
            System.out.println(sum);
            --q;
        }
        sc.close();
    }
}