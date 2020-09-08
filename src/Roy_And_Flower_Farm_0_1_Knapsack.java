/*

Roy is the owner of a flower plant farm and sells flower plants for a living.
Now the problem with flower plants is that they wither in a night if not taken care of. So at the end of the day, to make flower plants wither-resistant Roy uses special fertilizers.

There are N number of plants not sold on one particular day (say today), but Roy can sell them the next day (say tomorrow) if he fertilizes them tonight.


Roy sells a flower plant for Rs. X. Cost of fertilizing a plant is Rs. Y.
Currently Roy has P Rupees with him.

Given the selling price X and fertilizing cost Y of N plants, your task is to find minimum amount A (A ≤ P) that he should spend in fertilizing plants such that the total money he has after selling plants on the next day is maximized. Assume that all the fertilized plants are sold on the next day.

Input Format:
First line contains integer T - number of test cases.
Second line contains two space separated integers N and P.
Following N lines each contain two space separated integers X and Y.

Output Format:
Print the two space separated integers A and B in a new line for each test case.

Constraints:
1 ≤ T ≤ 10
1 ≤ N ≤ 100
1 ≤ X,Y ≤ 1000
1 ≤ P ≤ 10000

SAMPLE INPUT 
2
2 50
80 40
60 20

5 100
100 40
50 40
40 50
60 20
100 50

SAMPLE OUTPUT 
20 90
90 210

*/


import java.util.*;
class Roy_And_Flower_Farm_0_1_Knapsack
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int tot=sc.nextInt();
            int x[]=new int[n+1];
            int y[]=new int[n+1];
            int prof[]=new int[n+1];
            int dp[][]=new int[n+1][tot+1];
            for(int i=1;i<=n;i++)
            {
                x[i]=sc.nextInt();
                y[i]=sc.nextInt();
                prof[i]=x[i]-y[i];
            }
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=tot;j++)
                {
                    dp[i][j]=dp[i-1][j];
                    if(j>=y[i])
                        dp[i][j] = Math.max(dp[i][j], prof[i] + dp[i-1][j-y[i]]);
                }
            }
            
            int sum=dp[n][tot];
            int j=tot;
            int i=n;
            while(j>=0 && sum==dp[i][j])
            {
                --j;
            }
            ++j;
            System.out.println(j+" "+(tot+dp[n][tot]));
            --t;
        }
        sc.close();
    }
}