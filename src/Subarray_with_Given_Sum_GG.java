import java.util.*;
public class Subarray_with_Given_Sum_GG
{
	public static void main (String args[])
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    outer:while(t>0)
	    {
	        int n=sc.nextInt();
	        int sum=sc.nextInt();
	        long arr[]=new long[n+1];
	        for(int i=1;i<=n;i++)
	        {
	            arr[i]=sc.nextLong();
	        }
	        long curr_sum=0;
	        int start=1;
	        for(int i=1;i<=n;i++)
	        {
	            curr_sum+=arr[i];
	            while(curr_sum>sum)
	            {
	                curr_sum-=arr[start];
	                ++start;
	            }
	            if(curr_sum==sum)
	            {
	                System.out.println(start+" "+i);
	                --t;
	                continue outer;
	            }
	            
	        }
	        System.out.println(-1);
	        --t;
	    }
	    sc.close();
	}
}