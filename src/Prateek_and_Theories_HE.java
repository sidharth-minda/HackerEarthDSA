import java.util.*;
public class Prateek_and_Theories_HE
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                b[i]=sc.nextInt();
            }
            TreeMap<Integer, Integer> map =new TreeMap<>();
            for(int i=0;i<n;i++)
            {
                if(!map.containsKey(a[i]))
                    map.put(a[i],1);
                else
                {
                    int c=map.get(a[i]);
                    map.put(a[i],c+1);
                }
                if(!map.containsKey(b[i]))
                    map.put(b[i],-1);
                else
                {
                    int c=map.get(b[i]);
                    map.put(b[i],c-1);
                }
            }
            int sum=0,max=0;
            for(Map.Entry<Integer, Integer> me: map.entrySet())
            {
                sum=sum+me.getValue();
                max=Math.max(sum,max);
            }
            System.out.println(max);
            --t;
        }
        sc.close();
    }
}