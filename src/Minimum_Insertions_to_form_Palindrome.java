import java.util.*;
public class Minimum_Insertions_to_form_Palindrome {
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			String str=sc.next();
			int n=str.length();
			char c[]=str.toCharArray();
			int dp[][]=new int[n][n];
			for(int i=n-2;i>=0;i--)
			{
				for(int j=i+1;j<n;j++)
				{
					if(c[i]==c[j])
						dp[i][j]=dp[i+1][j-1];
					else
						dp[i][j]=(Math.min(dp[i][j-1], dp[i+1][j]))+1;
				}
			}
			System.out.println(dp[0][n-1]);
			--t;
		}
		sc.close();
	}
}
