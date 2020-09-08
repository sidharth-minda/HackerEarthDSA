import java.util.*;
class Rhezo_Prime_Problems_DP_standard
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n+1];
        int pre[] = new int[n+1];
        for(int i=1;i<=n;i++)
        {
            arr[i] = sc.nextInt();
            pre[i] = pre[i-1] + arr[i];
        }
        boolean prime[] = new boolean[n+1];
        Arrays.fill(prime,true);
        ArrayList<Integer> p = new ArrayList<>();
        p.add(2);
        for(int i=3;i<=n;i+=2)
        {
            if(prime[i])
            {
                p.add(i);
                for(int j=i*i;j<=n;j+=i)
                {
                    prime[j]=false;
                }
            }
        }
        int dp[] = new int[n+1];
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1];
            for(int j=0;j<p.size() && p.get(j)<=i;j++)
            {
            	int a = i - p.get(j) - 1;
                if(a == -1)
                    dp[i]=Math.max(dp[i], pre[i]);
                else
                    dp[i] = Math.max(dp[i], pre[i] - pre[a+1] + dp[a]);
            }
        }
        System.out.println(dp[n]);
        sc.close();
    }
}