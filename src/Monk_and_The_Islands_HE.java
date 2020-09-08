import java.util.*;
class Monk_and_The_Islands_HE
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int x=sc.nextInt();
            int z=0;
            ArrayList<Integer> arr[]=new ArrayList[n+1];
            boolean v[]=new boolean[n+1];
            int steps[]=new int[n+1];
            for(int i=1;i<=n;i++)
            {
                arr[i]=new ArrayList<Integer>();
            }
            for(int i=0;i<x;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                arr[a].add(b);
                arr[b].add(a);
            }
            Queue<Integer> q=new LinkedList<>();
            q.add(1);
            v[1]=true;
            while(!q.isEmpty())
            {
                int p=q.poll();
                for(int i=0;i<arr[p].size();i++)
                {
                    z=arr[p].get(i);
                    if(!v[z])
                    {
                        v[z]=true;
                        q.add(z);
                        steps[z]=steps[p]+1;
                    }
                }
            }
            System.out.println(steps[n]);
            --t;
        }
    }
}