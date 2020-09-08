import java.util.*;
public class Dividing_Array_Traveloka_HE
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		int j=0,k=0,c=0;
		int a[]=Arrays.copyOfRange(arr, 0, n/2);
		int b[]=Arrays.copyOfRange(arr, n/2, n);
		outer:for(int i=1;i<n/2;++i)
		{
			if(a[i]<=a[i-1])
			{
				if(j==0)
					j=i+1;
				while(j<n/2)
				{
					if(a[j]>a[i])
					{
						int temp=a[j];
						a[j]=a[i];
						a[i]=temp;
						--i;
						++j;
						continue outer;
					}
					++j;
				}
				while(k<n/2)
				{
					if(b[k]>a[i])
					{
						int temp=a[i];
						a[i]=b[k];
						b[k]=temp;
						--i;
						++k;
						continue outer;
					}
					++k;
				}
				a[i]=a[i-1]+1;
				++c;
			}
		}
		for(int i:a)
		{
			System.out.print(i+" ");
		}
		for(int i:b)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(c);
		sc.close();
	}
}
