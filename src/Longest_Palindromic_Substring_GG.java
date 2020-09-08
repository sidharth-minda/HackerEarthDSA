import java.util.*;
public class Longest_Palindromic_Substring_GG {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			String str=sc.next();
			int len=str.length();
			boolean dp[][]=new boolean[len][len];
			for(int i=0;i<len;i++)
			{
				dp[i][i]=true;
			}
			int max=0;
			int start=0,end=0;
			for(int i=len-2;i>=0;i--)
			{
				for(int j=i+1;j<len;j++)
				{
					if(str.charAt(i)==str.charAt(j) && (dp[i+1][j-1] ||  j-i==1 ) )
					{
						dp[i][j]=true;
						if((j-i+1)>=max)
						{
							max=j-i+1;
							start=i;
							end=j;
						}
					}
				}
			}
			System.out.println(str.substring(start, end+1));
			--t;
		}
		sc.close();
	}
}
