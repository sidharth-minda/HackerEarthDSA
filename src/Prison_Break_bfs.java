import java.util.*;
public class Prison_Break_bfs {
	
	static int arr[][];
	static boolean v[][];
	static int n;
	static int x[] = {1,0,-1,0};
	static int y[] = {0,-1,0,1};
	static int count=0;
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			n = sc.nextInt();
			arr = new int[n][n];
			v = new boolean[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j] = sc.nextInt();
				}
			}
			dfs(0,0);
			System.out.println(count);
			count=0;
		}
		sc.close();
	}
	
	public static void dfs(int a, int b)
	{
		if(a==n-1 && b==n-1)
			++count;
		v[a][b]=true;
		for(int i=0;i<4;i++)
		{
			int x1 = a + x[i];
			int y1 = b + y[i];
			if(x1>=0 && y1>=0 && x1<n && y1<n && !v[x1][y1] && arr[x1][y1]!=1)
				dfs(x1,y1);
		}
		v[a][b]=false;
	}
}
