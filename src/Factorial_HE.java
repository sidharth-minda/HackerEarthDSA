import java.util.*;
public class Factorial_HE
{
	static long dp[]=new long[100000];
	static int mod=(int)Math.pow(10, 9)+7;
	static int last=1;
	public static void main(String args[]) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		dp[0]=1;
		dp[1]=1;
		while(t>0)
		{
			int n=sc.nextInt();
			if(n>last)
				System.out.println(fact(n));
			else
				System.out.println(dp[n]);
			--t;
		}
		sc.close();
	}
	
	public static long fact(int n)
	{
		for(int i=last+1;i<=n;i++)
		{
			dp[i]=(i*dp[i-1])%mod;
		}
		last=n;
		return dp[n];
	}
}