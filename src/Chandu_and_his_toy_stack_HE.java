import java.util.*;
public class Chandu_and_his_toy_stack_HE
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                b[i]=sc.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            int sum=0;
            for(int i=0;i<n;i++)
            {
                if(a[i]>b[i])
                    sum+=y*(a[i]-b[i]);
                else
                    sum+=x*(b[i]-a[i]);
            }
            System.out.println(sum);
            --t;
        }
        sc.close();
    }
}