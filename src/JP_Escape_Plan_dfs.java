import java.util.*;
class JP_Escape_Plan_dfs
{
	static class Pair
	{
		int x,y;
		public Pair(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	static int x[] = {1,0,-1,0};
	static int y[] = {0,-1,0,1};
    static int arr[][];
    static boolean v[][];
    static ArrayList<Pair> path;
    static int sx=0,sy=0,j=0,n=0,m=0;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int[n+1][m+1];
        v=new boolean[n+1][m+1];
        path = new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        sx = sc.nextInt();
        sy = sc.nextInt();
        j=sc.nextInt();
        path.add(new Pair(sx,sy));
        if(!dfs(sx,sy))
            System.out.println("NO");
        else
        {
            System.out.println("YES");
            System.out.println(path.size());
            for(Pair p:path)
            {
                System.out.println(p.x+" "+p.y);
            }
        }
        sc.close();

    }
    
    public static boolean dfs(int a, int b)
    {
        if(a==1 || a==n || b==1 || b==m)
            return true;
        v[a][b]=true;
        for(int i=0;i<4;i++)
        {
            int x1 = a + x[i];
            int y1 = b + y[i];
            if(x1>=1 && x1<=n && y1>=1 && y1<=m )
            {
                if(!v[x1][y1] && arr[x1][y1]<=arr[a][b] && arr[x1][y1]>=arr[a][b]-j)
                {
                    Pair p = new Pair(x1,y1);
                    path.add(p);
                    if(dfs(x1,y1))
                        return true;
                    path.remove(p);
                }
            }
        }
        return false;
    }

}