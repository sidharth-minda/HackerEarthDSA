import java.util.*;
public class String_permutation_GG
{
	public static void main (String args[])
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        String s=sc.next();
	        char c[]=s.toCharArray();
	        Arrays.sort(c);
	        String str=new String(c);
	        sperm("", str);
	        System.out.println();
	        --t;
	    }
	    sc.close();
	}
	public static void sperm(String ans, String str)
	{
	    if(str.isEmpty())
	        System.out.print(ans+" ");
	    for(int i=0;i<str.length();i++)
	    {
	        sperm(ans+str.charAt(i),str.substring(0,i)+str.substring(i+1));
	    }
	}
}