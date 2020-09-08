import java.util.*;
class Little_Shino_and_K_Ancestor_dfs_HE
{
    static class Node
    {
        int x;
        int y;
        Node(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    static ArrayList<Integer> arr[];
    static int x[];
    static boolean v[];
    static int k=0;
    static int org=0;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        k = sc.nextInt();
        arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
        {
            arr[i] = new ArrayList<>();
        }
        x = new int[n+1];
        for(int i=1;i<=n;i++)
        {
            x[i] = sc.nextInt();
        }
        for(int i=1;i<=n-1;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[b].add(a);
        }
        v = new boolean[n+1];
        
        for(int i=1;i<=n;i++)
        {
            Arrays.fill(v,false);
            //org=x[i];
            System.out.print(dfs(i,0) + " ");
            
        }
    }
    
    public static int dfs(int n, int dist)
    {
        Stack<Node> s = new Stack<>();
        s.push(new Node(n,0));
        v[n]=true;
        int res=-1;
        outer:while(!s.isEmpty())
        {
            Node p = s.pop();
            for(int i=0;i<arr[p.x].size();i++)
            {
                int a = arr[p.x].get(i);
                if(!v[a])
                {
                    v[a]=true;
                    s.push(new Node(a, p.y + 1));
                }
            }
            if(p.y==k && x[p.x]==x[n])
            {
                res=p.x;
                break outer;
            }
        }
        return res;
    }
}