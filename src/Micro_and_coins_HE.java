import java.util.*;
public class Micro_and_coins_HE
{
    static int arr[][];
    static boolean v[];
    static int n;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
        n=sc.nextInt();
        int m=sc.nextInt();
        arr=new int[n+1][n+1];
        v=new boolean[n+1];
        for(int i=0;i<m;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a][b]=1;
            arr[b][a]=1;
        }
        v[1]=true;
        if(dfs(1,1))
            System.out.println("Yes");
        else
            System.out.println("No");
        --t;}
     } 
    public static boolean dfs(int vert, int sum)
    {
        if(sum==n*(n+1)/2)
            return true;
        for(int j=2;j<=n;j++)
        {
            if(arr[vert][j]==1 && !v[j])
            {
                v[j]=true;
                if(dfs(j,sum+j))
                    return true;
                v[j]=false;
            }
        }
        return false;
    }
}