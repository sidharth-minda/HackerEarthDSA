import java.util.Arrays;

public class Select_Stocks
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int curr[]= {10,125,158,1,210,104,243,238,161,227,264};
		int fut[]= {10,298,268,287,84,267,64,269,284,273,96};
		int sav=449;
		selectStock(curr,fut,sav);
		System.out.println(max);
	}
	static int max=0;
	public static void selectStock(int curr[], int fut[], int sav)
	{
		int n=curr.length;
		boolean v[]=new boolean[n];
		for(int i=0;i<n;i++)
		{
			Arrays.fill(v, false);
			dfs(curr[i],i,fut[i]-curr[i],sav,v,curr,fut);
		}
	}
	
	public static void dfs(int tot, int i, int prof, int sav, boolean v[],int curr[], int fut[])
	{ 
		if(tot>sav)
				return;
		max=Math.max(max, prof);
		v[i]=true;
		for(int j=0;j<v.length;j++)
		{
			if(j==i)
			continue;
			if(!v[j])
			dfs(tot+curr[j], j, prof+fut[j]-curr[j],sav,v,curr,fut);
		}
	}

}
