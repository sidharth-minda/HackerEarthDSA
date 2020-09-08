import java.util.*;
public class Parenthesis_Checker_GG
{
	public static void main (String args[])
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        String str=sc.next();
	        char c[]=str.toCharArray();
	        int n=c.length;
	        Stack<Character> st=new Stack<>();
	        int flag=0;
	        for(int i=0;i<n;i++)
	        {
	            if(c[i]=='(' || c[i]=='{' || c[i]=='[' )
	                st.push(c[i]);
	            else
	            {
	                if(st.isEmpty())
	                {
	                    flag=1;
	                    break;
	                }
	                char ch=st.pop();
	                if( (ch=='{' && c[i]!='}') || (ch=='(' && c[i]!=')') || (ch=='[' && c[i]!=']' ))
	                    {
	                        flag=1;
	                        break;
	                    }
	            }
	        }
	        if(flag==0 && st.isEmpty())
	            System.out.println("balanced");
	        else
	            System.out.println("unbalanced");
	        --t;
	    }
	    sc.close();
	}
}