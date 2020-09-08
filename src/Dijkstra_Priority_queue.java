import java.util.*;
public class Dijkstra_Priority_queue
{
	static class Node implements Comparator<Node>
	{
		int v;
		int cost;
		Node()
		{
			
		}
		Node(int v, int cost)
		{
			this.v=v;
			this.cost=cost;
		}
		
		@Override
		public int compare(Node a, Node b)
		{
			if(a.cost<b.cost)
				return -1;
			if(a.cost>b.cost)
				return 1;
			return 0;
		}
	}
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<Node> arr[] = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
        {
        	arr[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++)
        {
        	int a=sc.nextInt();
        	int b=sc.nextInt();
        	int c=sc.nextInt();
        	arr[a].add(new Node(b,c));
        	arr[b].add(new Node(a,c));
        }
        Set<Integer> settled = new HashSet<>(n+1);
        int d[]=new int[n+1];
        Arrays.fill(d, 1000000000);
        d[1]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>(n, new Node());
        pq.add(new Node(1,0));
        while(!pq.isEmpty())
        {
        	Node p=pq.poll();
        	int u=p.v;
        	settled.add(u);
        	for(int i=0;i<arr[u].size();i++)
        	{
        		Node x=arr[u].get(i);
        		if(!settled.contains(x.v))
        		{
        			if(d[u]+x.cost <d[x.v])
        				d[x.v]=d[u]+x.cost;
        			pq.add(new Node(x.v, d[x.v]));
        		}
        	}
        }
        for(int i=2;i<=n;i++)
        {
        	System.out.print(d[i]+" ");;
        }
    }
}