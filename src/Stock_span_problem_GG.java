import java.util.*;
public class Stock_span_problem_GG
{
	public static void main (String args[])
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t>0)
	    {
	        int n=sc.nextInt();
	        int arr[]=new int[n];
	        for(int i=0;i<n;i++)
	        {
	            arr[i]=sc.nextInt();
	        }
	        int span[]=new int[n];
	        span[0]=1;
	        Stack<Integer> st=new Stack<>();
	        st.push(0);
	        for(int i=1;i<n;i++)
	        {
	            while(!st.empty() && arr[i]>=arr[st.peek()])
	            {
	                st.pop();
	            }
	            span[i]=(st.empty())?(i+1):(i-st.peek());
	            st.push(i);
	        }
	        for(int i:span)
	        {
	            System.out.print(i+" ");
	        }
	        System.out.println();
	        --t;
	    }
	    sc.close();
	}
}