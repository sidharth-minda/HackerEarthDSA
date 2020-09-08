import java.util.*;
public class Game_of_Strengths_HE
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        long mod=(long)Math.pow(10,9)+7;
        while(t>0)
        {
            int n=sc.nextInt();
            long arr[]=new long[n];
            long max=0;
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextLong();
                max=(long)Math.max(max,arr[i]);
            }
            Arrays.sort(arr);
            int k=1-n;
            long sum=0;
            for(int i=0;i<n;i++)
            {
                sum=(sum+arr[i]*k)%mod;
                k+=2;
            }
            System.out.println((sum*max)%mod);
            --t;
        }
        sc.close();	
    }
}