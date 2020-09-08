import java.util.*;
class Pink_and_Blue_dfs
{
    static ArrayList<Integer> arr[];
    static boolean v[];
    static char g[];
    static char c[];
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        arr = new ArrayList[n+1];
        v = new boolean[n+1];
        g = new char[n+1];
        c = new char[n+1];
        for(int i=1;i<=n;i++)
        {
            arr[i] = new ArrayList<>();
        }
        for(int i=1;i<=n;i++)
        {
            char ch = sc.next().charAt(0);
            g[i] = (ch=='B')?'B':'P';
        }
        for(int i=1;i<=m;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        int c1=0,c2=0,min=Integer.MAX_VALUE;
        dfs(1,'B');
        for(int i=1;i<=n;i++)
        {
            if(g[i] != c[i])
                ++c1;
        }
        Arrays.fill(v,false);
        dfs(1,'P');
        for(int i=1;i<=n;i++)
        {
            if(g[i] != c[i])
                ++c2;
        }
        min=Math.min(c1,c2);
        if(min!=0)
            System.out.println(min);
        else
            System.out.println("Not Possible");
        sc.close();
    }

    public static void dfs(int n, char color)
    {
        v[n]=true;
        c[n]=color;
        for(int i=0;i<arr[n].size();i++)
        {
            int p = arr[n].get(i);
            if(!v[p])
            {
                if(color == 'B')
                    c[p] = 'P';
                else
                    c[p] = 'B';
                dfs(p,c[p]);
            }
        }
    }
}