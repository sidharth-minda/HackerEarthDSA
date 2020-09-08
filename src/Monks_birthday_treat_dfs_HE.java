import java.util.*;
class Monks_birthday_treat_dfs_HE
{
    static int c=0;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
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
            //arr[b].add(a);
        }
        boolean v[]=new boolean[n+1];
        int min=Integer.MAX_VALUE;
        for(int i =1;i<=n;i++) 
        {
            Arrays.fill(v,false);
            dfs(i, v, arr);
            min=Math.min(min,c);
            c=0;
        }
        System.out.println(min);
    }
    
    public static void dfs(int n, boolean v[], ArrayList<Integer> arr[])
    {
        ++c;
        v[n]=true;
        for(int i=0;i<arr[n].size();i++)
        {
            int a = arr[n].get(i);
            if(!v[a])
            {
                dfs(a,v,arr);
                
            }
        }
    }
}