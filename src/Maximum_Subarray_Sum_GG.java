import java.util.*;
public class Maximum_Subarray_Sum_GG {
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		int curr_sum=0;
		int start=0,end=0,max=0,s=0;
		for(int i=0;i<n;i++)
		{
			curr_sum+=arr[i];
			if(arr[i]>curr_sum)
			{
				curr_sum=arr[i];
				s=i;
			}
			if(curr_sum>max)
			{
				max=curr_sum;
				start=s;
				end=i;
			}
		}
		for(int i=start;i<=end;i++)
		{
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}
