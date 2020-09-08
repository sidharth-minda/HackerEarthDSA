import java.util.*;
class Happy_Vertices_dfs
{
    static ArrayList<Integer> arr[];
    static boolean v[];
    static int child[];
    static int count=0;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        arr = new ArrayList[n+1];
        v = new boolean[n+1];
        child = new int[n+1];
        for(int i=1;i<=n;i++)
        {
            arr[i] = new ArrayList<>();
        }
        for(int i=1;i<=m;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        for(int i=1;i<=n;i++)
        {
            if(!v[i])
                dfs(i);
        }
        System.out.println(count);
    }

    public static void dfs(int n)
    {
        v[n]=true;
        int c=0;
        for(int i=0;i<arr[n].size();i++)
        {
            int p = arr[n].get(i);
            if(!v[p])
            {
                ++c;
                dfs(p);
            }
        }
        child[n]=c;
        for(int i=0;i<arr[n].size();i++)
        {
            if(child[arr[n].get(i)] > child[n])
                ++count;
        }
    }
}