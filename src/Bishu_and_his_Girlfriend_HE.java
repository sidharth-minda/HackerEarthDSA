import java.util.*;
import java.io.*;
public class Bishu_and_his_Girlfriend_HE{
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr[] = new ArrayList[n+1];
		boolean visited[] = new boolean[n+1];
		for(int i=1;i<=n;i++)
		{
			arr[i]=new ArrayList<>();
		}
		for(int i=0;i<n-1;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		int z = Integer.parseInt(br.readLine());
		ArrayList<Integer> Q = new ArrayList<>();
		for(int i=0;i<z;i++)
		{
			Q.add(Integer.parseInt(br.readLine()));
		}
		for(int i=1;i<=n;i++)
		{
			Collections.sort(arr[i]);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1]=true;
		int flag=0;
		outer:while(!q.isEmpty())
		{
			int p = q.poll();
			for(int i=0;i<arr[p].size();i++)
			{
				int x = arr[p].get(i);
				if(!visited[x])
				{
					visited[x]=true;
					q.add(x);
					if(Q.contains(x))
					{
						flag=x;
						break outer;
					}
				}
			}
		}
		System.out.println(flag);
	}
}
