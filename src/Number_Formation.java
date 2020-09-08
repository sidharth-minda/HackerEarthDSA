/*

You are given an array  of  integers. Each integer is a single digit number in the range . You are also given a number . Now, you need to count how many subsequences of the array  exist such that they form a  digit valid number.

A subsequence of size  is called a valid number if there are no leading zeros in the number formed.

Notes:

A subsequence of an array is not necessarily contiguous.
Suppose the given array is , then if you choose subsequence to be , then it is not a valid  digit number. Also, it will not be considered as a single digit number. A valid  digit number in the array is . Please go through the sample I/O for better understanding.
Input Fomat

The first line contains an integer  as input denoting the size of the array.
Next line contains  space separated integers that denote elements of the array.
Next line contains an integer .

Output Format

In the output, you need to print the count of valid  digit numbers modulo .

Constraints
1<=N<=10^5
1<=K<=30


SAMPLE INPUT 
5
1 1 0 1 0
3
SAMPLE OUTPUT 
9

*/


import java.util.*;
public class Number_Formation
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int dp[][]=new int[n+1][31];
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=k;j++)
            {
                if(j==1 && arr[i]==0)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]= (dp[i-1][j] + dp[i-1][j-1]) % 720720;
            }
        }
        if(k==1)
            System.out.println(n);
        else
            System.out.println(dp[n][k]);
        sc.close();
    }
}
