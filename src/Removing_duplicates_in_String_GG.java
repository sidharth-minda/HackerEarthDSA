import java.util.*;
public class Removing_duplicates_in_String_GG
{
	public static void main (String args[])
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    sc.nextLine();
	    while(t>0)
	    {
	        String str=sc.nextLine();
	        char c[]=str.toCharArray();
	        boolean v[]=new boolean[257];
	        for(int i=0;i<c.length;i++)
	        {
	        	if(!v[c[i]])
	        	{
	        		v[c[i]]=true;
	        		System.out.print(c[i]);
	        	}
	        }
	        System.out.println();
	        --t;
	    }
	    sc.close();
	}
}