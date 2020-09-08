import java.util.*;
public class Anagrams_GG
{
	public static void main (String args[])
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        String s1=sc.next();
	        String s2=sc.next();
	        long sum1=0;
	        long sum2=0;
	        for(int i=0;i<s1.length();i++)
	        {
	            sum1+=s1.charAt(i);
	        }
	        for(int i=0;i<s2.length();i++)
	        {
	            sum2+=s2.charAt(i);
	        }
	        if(sum1==sum2)
	            System.out.println("YES");
	        else
	            System.out.println("NO");
	        --t;
	    }
	    sc.close();
	}
}