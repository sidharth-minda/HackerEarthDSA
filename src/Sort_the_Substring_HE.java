import java.util.*;
public class Sort_the_Substring_HE
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String str=sc.next();
            int n=sc.nextInt();
            int m=sc.nextInt();
            String s=str.substring(n,m+1);
            char arr[]=s.toCharArray();
            Arrays.sort(arr);
            String s1=new String(arr);
            StringBuffer sb=new StringBuffer(s1);
            sb.reverse();
            s1=sb.toString();
            System.out.print( str.substring(0,n) + s1 + str.substring(m+1) );
            System.out.println();
            --t;
        }
        sc.close();
    }
}