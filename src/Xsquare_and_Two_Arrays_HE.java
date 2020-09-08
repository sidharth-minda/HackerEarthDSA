import java.util.*;
public class Xsquare_and_Two_Arrays_HE
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int a[]=new int[n+1];
        int b[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            a[i]=sc.nextInt();
        }
        for(int i=1;i<=n;i++)
        {
            b[i]=sc.nextInt();
        }
        while(t>0)
        {
            int c=sc.nextInt();
            int p=sc.nextInt();
            int q=sc.nextInt();
            long sum=0l;
            for(int i=p;i<=q;i++)
            {
                if(c%2==0)
                    sum=sum+b[i];
                else
                    sum=sum+a[i];
                ++c;
            }
            System.out.println(sum);
            --t;
        }
        sc.close();
    }
}