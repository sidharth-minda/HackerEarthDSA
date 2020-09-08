import java.util.*;
public class Maximum_Length_Palindromic_Substring
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String str=sc.next();
            int n=str.length();
            char c[]=str.toCharArray();
            int dp[][]=new int[c.length][c.length];
            int max=1;
            for(int i=n-1;i>=0;i--)
            {
                for(int j=i;j<n;j++)
                {
                    if((c[i]==c[j]) && (j-i<=2 || dp[i+1][j-1]==1))
                    {
                        dp[i][j]=1;
                        max=Math.max(max, (j-i+1));
                    }
                }
            }
            if(isPrime(max))
                System.out.println("PRIME");
            else
                System.out.println("NOT PRIME");
            
            --t;
        }
        sc.close();

    }
    
    public static boolean isPrime(int n)
    {
        if(n==1)
            return false;
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
}