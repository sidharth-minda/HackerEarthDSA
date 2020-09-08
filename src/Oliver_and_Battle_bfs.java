import java.util.*;
class Oliver_and_Battle_bfs
{
	static class Pair
    {
        int x,y;
        public Pair(int x, int y)
        {
            this.x= x;
            this.y=y;
        }
    }
	
    public static int arr[][];
    public static boolean v[][];
    public static int vert = 0;
    static int x[] = {1,1,1,0,-1,-1,-1,0};
    static int y[] = {1,0,-1,-1,-1,0,1,1};
    static int n=0,m=0;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n][m];
            v = new boolean[n][m];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            int max=0,comp=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(arr[i][j] == 1 && !v[i][j])
                    {
                        bfs(i,j);
                        max = Math.max(max, vert);
                        ++comp;
                    }
                }
            }
            System.out.println(comp + " " + max);
            --t;
        }
    }

    public static void bfs(int a, int b)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a,b));
        v[a][b]=true;
        vert=1;
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            for(int i=0;i<8;i++)
            {
                int x1 = p.x + x[i];
                int y1 = p.y + y[i];
                if(canPlace(x1,y1) && arr[x1][y1] == 1 && !v[x1][y1])
                {
                    v[x1][y1] = true;
                    q.add(new Pair(x1,y1));
                    ++vert;
                }
            }
        }
    }

    public static boolean canPlace(int a, int b)
    {
        if(a<0 || a>=n || b<0 || b>=m)
            return false;
        return true;
    }
}