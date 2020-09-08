import java.util.Scanner;

public class Strings {


    public static void main(String[] args) {
        /* Your class should be named Main.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */

        // Write your code here
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int mul = sc.nextInt();
            long arr[] = new long[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.nextLong();
            }
            long curr_sum=0l;
            long max_sum=1l*Integer.MIN_VALUE;
            long curr_low=0l;
            int s=0,start=0,end=0;
            long min_sum=1l*Integer.MAX_VALUE;

            if(mul<0)
            {
                for(int i=0;i<n;i++)
                {
                    curr_low += arr[i];
                    if(arr[i]<curr_low)
                    {
                        curr_low = arr[i];
                        s=i;
                    }
                    if(curr_low<min_sum)
                    {
                        min_sum=curr_low;
                        start=s;
                        end=i;
                    }
                }
                for(int i=start;i<=end;i++)
                {
                    arr[i]*=mul;
                }
            }

            for(int i=0;i<n;i++)
            {
                curr_sum += arr[i];
                if(arr[i]>curr_sum)
                {
                    curr_sum=arr[i];
                }
                max_sum = Math.max(max_sum, curr_sum);
            }
            long ans = max_sum;
            if(mul>0)
                ans = Math.max(ans, max_sum*mul);
            System.out.println(ans);
        }

    }

}
