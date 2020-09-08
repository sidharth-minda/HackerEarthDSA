import java.util.*;
public class Big_P_and_Punishment_HE
{
	static int c=0;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int f = sc.nextInt();
			int s = sc.nextInt();
			ArrayList<Integer> arr[] = new ArrayList[n+1];
			for(int i=1;i<=n;i++)
			{
				arr[i] = new ArrayList<>();
			}
			for(int i=0;i<f;i++)
			{
				int a=sc.nextInt();
				int b=sc.nextInt();
				arr[a].add(b);
			}
			int st[] =new int[s+1];
			for(int i=1;i<=s;i++)
			{
				st[i]=sc.nextInt();
			}
			boolean v[] = new boolean[n+1];
			for(int i=1;i<=s;i++)
			{
				int a = st[i];
				if(!v[a])
				{
					dfs(a,v,arr);
				}
			}
			System.out.println(c);
			c=0;

		}
		sc.close();
	}

	public static void dfs(int n, boolean v[], ArrayList<Integer> arr[])
	{
		v[n]=true;
		++c;
		for(int i=0;i<arr[n].size();i++)
		{
			int p = arr[n].get(i);
			if(!v[p])
			{
				dfs(p,v,arr);
			}
		}
	}
}