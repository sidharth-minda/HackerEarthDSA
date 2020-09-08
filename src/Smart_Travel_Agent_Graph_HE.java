import java.util.*;
public class Smart_Travel_Agent_Graph_HE
{
	static boolean v[];
	static int max=0,min=Integer.MAX_VALUE,dest=0,n=0;
	static ArrayList<Integer> ans;
	static int arr[][];
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int r = sc.nextInt();
		arr= new int[n+1][n+1];
		v = new boolean[n+1];
		for(int i=1;i<=r;i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a][b] = c;
			arr[b][a] = c; 
		}
		int src = sc.nextInt();
		dest = sc.nextInt();
		int t = sc.nextInt();
		ans = new ArrayList<>();
		ans.add(src);
		dfs(src,ans);
		--max;
		for(int i:ans)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.print((int)Math.ceil((1.0*t)/max));
		sc.close();
	}

	public static void dfs(int src, ArrayList<Integer> l)
	{
		if(src==dest)
		{
			if(min > max)
			{
				max=min;
				ans=l;
			}
			return;
		}
		v[src] = true;
		for(int i=1;i<=n;i++)
		{
			if(!v[i] && arr[src][i]!=0)
			{
				int z = min;
				min = Math.min(min, arr[src][i]);
				ArrayList<Integer> temp = new ArrayList<>(l);
				temp.add(i);
				dfs(i,temp);
				min=z;
			}
		}
		v[src]=false;
	}
}