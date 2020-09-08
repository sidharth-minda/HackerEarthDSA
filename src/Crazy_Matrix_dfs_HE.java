import java.util.*;
public class Crazy_Matrix_dfs_HE
{
	static int x[] = {1,1,1,-1,-1,-1,0,0};
	static int y[] = {1,0,-1,1,0,-1,1,-1};
	static boolean v[][];
	static int n;
	static int arr[][];
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1][n+1];
		v = new boolean[n+1][n+1];
		boolean flag1=false, flag2=false;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1;i<=n;i++)
		{
			if(!v[1][i] && arr[1][i]==1)
			{
				flag1 = dfs(1,i,1);
				if(flag1)
					break;
			}
		}
		
		for(int i=1;i<=n;i++)
		{
			Arrays.fill(v[i], false);
		}
		
		for(int i=1;i<=n;i++)
		{
			if(!v[i][1] && arr[i][1]==2)
			{
				flag2 = dfs(i,1,2);
				if(flag2)
					break;
			}
		}
		
		if(flag1)
		{
			if(flag2)
				System.out.println("AMBIGUOUS");
			else
				System.out.println(1);
		}
		else if(flag2)
			System.out.println(2);
		else
			System.out.println(0);
		
		sc.close();
	}
	
	public static boolean dfs(int a, int b, int comp)
	{
		if((comp==1 && a==n) || (comp==2 && b==n) )
			return true;
		v[a][b] = true;
		for(int i=0;i<8;i++)
		{
			int x1 = a + x[i];
			int y1 = b + y[i];
			if(x1>=1 && x1<=n && y1>=1 && y1<=n && !v[x1][y1] && arr[x1][y1]==comp)
				if(dfs(x1,y1,comp) == true)
					return true;
		}
		return false;
	}
}