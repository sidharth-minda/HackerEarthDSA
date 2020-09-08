import java.util.Scanner;

public class SumofNumberOfFactors {
    static int max=(int)Math.pow(10,7);
    static int factor[];
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        factor = new int[max+1];
        for(int i=1;i<=max;i++)
        {
            factor[i]=i;
        }
        generatePrimeFactors();
        long dp[] = new long[max+1];
        long sum=0;
        dp[1]=1;
        for(int i=2;i<=max;i++)
        {
            dp[i] = dp[i-1] + numOfFactors(i);
        }
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int k = sc.nextInt();
            System.out.println(binarySearch(k,dp));
        }
        sc.close();
    }

    public static void generatePrimeFactors()
    {
        for(int i=2;i*i<=max;i++)
        {
            if(factor[i]==i)
            {
                for(int j=i*i;j<=max;j+=i)
                {
                    if(factor[j]==j)
                        factor[j]=i;
                }
            }
        }
    }

    public static long numOfFactors(int n)
    {
        long ans=1;
        int pow=1;
        int fact = factor[n];
        n/= factor[n];
        while(n!=1)
        {
            if(factor[n]==fact)
                ++pow;
            else
            {
                ans*=(pow+1);
                pow=1;
                fact = factor[n];
            }
            n/= factor[n];
        }
        ans*=(pow+1);
        return ans;
    }

    public static int binarySearch(int k, long dp[])
    {
        int l=0;
        int r=max;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if((dp[mid]==k) || (dp[mid]>k && dp[mid-1]<k))
                return mid;
            if(dp[mid]>k)
                r=mid+1;
            else
                l=mid;
        }
        return -1;
    }

}
