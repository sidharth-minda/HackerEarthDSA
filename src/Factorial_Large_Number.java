import java.util.*;
public class Factorial_Large_Number {
	static int res[];
    public String solve(int A) {
        res = new int[500];
        res[0]=1;
        int size=1;
        for(int i=2;i<=A;i++)
        {
            size = fact(i, size);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=size-1;i>=0;i--)
        {
            sb.append(res[i]);
        }
        return sb.toString();
    }
    
    public int fact(int n, int size)
    {
        int carry = 0 ;
        for(int i=0;i<size;i++)
        {
            int prod = n*res[i] + carry;
            res[i] = prod%10;
            carry = prod/10;
        }
        while(carry!=0)
        {
            res[size++] = carry%10;
            carry=carry/10;
        }
        return size;
    }
    
    public void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
    	System.out.println(solve(a));
    	sc.close();
    }
}

