import java.math.BigInteger;
import java.util.*;
public class XSquare_And_Interesting_Sequences_HE 
{
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			long n=sc.nextLong();
			n=(n+1)/2;
			BigInteger pw=BigInteger.valueOf(n);
			BigInteger twosix=BigInteger.valueOf(26);
			BigInteger mod=BigInteger.valueOf(1000000009);
			System.out.println(twosix.modPow(pw, mod));
			--t;
		}
		sc.close();
	}
}
