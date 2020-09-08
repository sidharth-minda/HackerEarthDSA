import java.util.*;
public class Little_Jhool_the_Devdas_HE 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		int sum=0;
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		if(sum%2==0)
		{
				Arrays.sort(arr);
				for(int i=0;i<n;i++)
				{
					if(arr[i]%2==1)
					{
						sum-=arr[i];
						break;
					}
				}
		}
		if(sum%2==0)
			System.out.println(":(");
		else
			System.out.println(sum);
		sc.close();
	}
}
