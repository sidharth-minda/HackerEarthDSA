import java.util.*;
public class Is_Product_Perfect_Square {
	public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        long total=(long)n*(n-1)/2;
        long count=0;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                long prod=(long)arr[i]*arr[j];
                long sq=(long)Math.sqrt(prod);
                if(sq*sq == prod )
                    ++count;
            }
        }
        System.out.printf("%.6f", (double)count/total);
        sc.close();
    }
}
