/*

Ashwin wants to make this Valentine special for Disha. So, he wants to collect maximum number of roses. Help him to collect maximum number of roses. Roses are kept in boxes and the boxes are further arranged in a N*M grid.
Ashwin can pick a box and get all the roses it contains,but the hack is that if you choose a box, the box immediately below it cannot be selected. So, help him collect the maximum number of Roses.


*NOTE* : Only one box can be selected from each row
INPUT:
There are T test cases.
For each test case, the first line consists of two integers N and M, denoting the number of rows and number of columns in matrix A respectively. Each of the following N lines consist of M space-separated integers, thus describing the grid.

OUTPUT:
For each test case, output the maximum number of roses Ashwin can collect.

CONSTRAINTS
1 <= T <= 10
2 <= N,M <= 10^5
4 <= N*M <= 10^6
1 <= A[i][j] <= 100

SAMPLE INPUT 
1
4 4
1 2 3 4
5 6 7 8
9 1 4 2
6 3 5 7

SAMPLE OUTPUT 
27

*/


import java.util.*;
import java.io.*;
public class Help_Ashwin
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int arr[][]=new int[n+1][m+1];
            for(int i=1;i<=n;i++)
            {
                st=new StringTokenizer(br.readLine());
                for(int j=1;j<=m;j++)
                {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            int max=0;
            int smax=0;
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                {
                    if(arr[i-1][j]==max)
                        arr[i][j]+=smax;
                    else
                        arr[i][j]+=max;
                }
                max=0;
                smax=0;
                for(int j=1;j<=m;j++)
                {
                    if(arr[i][j]>=max)
                    {
                        smax=max;
                        max=arr[i][j];
                    }
                    else if(arr[i][j]>smax)
                        smax=arr[i][j];
                }
            }
            System.out.println(max);
            --t;
        }
    }
}
