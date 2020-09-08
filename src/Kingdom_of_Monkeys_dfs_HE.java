import java.util.*;
class Kingdom_of_Monkeys_dfs_HE
{
    static long c=0l;
    static long x[];
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int e = sc.nextInt();
            ArrayList<Integer> arr[] = new ArrayList[n+1];
            for(int i=1;i<=n;i++)
            {
                arr[i] = new ArrayList<>();
            }
            for(int i=0;i<e;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                arr[a].add(b);
                arr[b].add(a);
            }
            x = new long[n+1];
            for(int i=1;i<=n;i++)
            {
                x[i]=sc.nextLong();
            }
            boolean v[] = new boolean[n+1];
            long max=0l;
            for(int i=1;i<=n;i++)
            {
                if(!v[i])
                {
                    c=x[i];
                    dfs(i, v, arr);
                    max=Math.max(max,c);
                }
            }
            System.out.println(max);
            --t;
        }
    }
    
    public static void dfs(int n, boolean v[], ArrayList<Integer> arr[])
    {
        Stack<Integer> s = new Stack<>();
        s.push(n);
        v[n]=true;
        while(!s.isEmpty())
        {
            int p=s.pop();
            for(int i=0;i<arr[p].size();i++)
            {
                int a=arr[p].get(i);
                if(!v[a])
                {
                    c+=x[a];
                    v[a]=true;
                    s.push(a);
                }
            }
        }
    }
}