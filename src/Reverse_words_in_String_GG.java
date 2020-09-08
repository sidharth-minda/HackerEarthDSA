import java.util.*;
public class Reverse_words_in_String_GG
{
	public static void main (String args[])
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        String str=sc.next();
	        String res[]=str.split("\\.");
	        for(int i=res.length-1;i>=0;i--)
	        {
	            System.out.print(res[i]);
	            if(i!=0)
	                System.out.print(".");
	        }
	        System.out.println();
	        --t;
	    }
	    sc.close();
	}
}