import java.util.*;
public class Maximum_Non_Contiguous_Subarray {
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int n=sc.nextInt();
			int arr[]=new int[n];
			int max=Integer.MIN_VALUE;
			int prev=Integer.MIN_VALUE;
			int sum=0;
			for(int i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++)
			{
				sum+=arr[i];
				if(arr[i]>sum)
					sum=arr[i];
				if(prev>sum)
					sum=prev;
				max=Math.max(max, sum);
				prev=sum;
			}
			System.out.println(max);
			--t;
		}
		sc.close();
	}
}
