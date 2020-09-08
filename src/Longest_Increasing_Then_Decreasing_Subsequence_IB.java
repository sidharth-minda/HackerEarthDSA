import java.util.Arrays;
import java.util.List;

public class Longest_Increasing_Then_Decreasing_Subsequence_IB {

    public int longestSubsequenceLength(final List<Integer> A) {
        if(A.isEmpty())
            return 0;
        int n = A.size();
        int arr[] = new int[n];
        int k=0;
        for(int i: A)
        {
            arr[k++] = i;
        }
        int inc[] = new int[n];
        int dec[] = new int[n];
        Arrays.fill(inc,1);
        Arrays.fill(dec, 1);

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j] < arr[i] && inc[i] < inc[j] + 1)
                    inc[i] = inc[j] + 1;
            }
        }

        for(int i=n-2;i>=0;i--)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[j] < arr[i] && dec[i] < dec[j] + 1)
                    dec[i] = dec[j] + 1;
            }
        }

        int max =0;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max, inc[i] + dec[i] - 1);
        }
        return max;
    }
}