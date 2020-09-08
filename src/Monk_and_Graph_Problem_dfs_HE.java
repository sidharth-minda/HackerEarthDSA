/*

Monk and his graph problems never end. Here is one more from our own Monk:
Given an undirected graph with N vertices and M edges, what is the maximum number of edges in any connected component of the graph.

The graph may have multiple edges and self loops.

Input Format:
The first line of input consists of two space separated integers N and M, denoting number of vertices in the graph and number of edges in the graph respectively.
Following M lines consists of two space separated each a and b, denoting there is an edge between vertex a and vertex b.

Output Format:
The only line of output consists of answer of the question asked by Monk.


SAMPLE INPUT 
6 3
1 2
2 3
4 5
SAMPLE OUTPUT 
2



*/

import java.util.*;
class Monk_and_Graph_Problem_dfs_HE
{
    static int edges=0;
    static ArrayList<Integer> arr[];
    static boolean v[];
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
        {
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<e;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        v = new boolean[n+1];
        int max=0;
        for(int i=1;i<=n;i++)
        {
            if(!v[i])
            {
                dfs(i);
                max=Math.max(max,edges/2);
                edges=0;
            }
        }
        System.out.println(max);
    }
    public static void dfs(int n)
    {
        Stack<Integer> s = new Stack<>();
        s.push(n);
        v[n]=true;
        while(!s.isEmpty())
        {
            int p=s.pop();
            for(int i=0;i<arr[p].size();i++)
            {
                ++edges;
                int a = arr[p].get(i);
                if(!v[a])
                {
                    v[a]=true;
                    s.push(a);
                }
            }
        }
    }
}