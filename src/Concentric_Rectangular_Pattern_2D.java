import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Concentric_Rectangular_Pattern_2D
{
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {

        int n = A*2 - 1;
        int arr[][] = new int[n][n];
        int top=0,bottom=n-1;
        int left=0,right=n-1;
        int num = A;

        while(top<=bottom && left<=right)
        {
            for(int i=left;i<=right;i++)
            {
                arr[top][i]=A;
            }
            ++top;

            for(int i=top;i<=bottom;i++)
            {
                arr[i][right]=A;
            }
            --right;

            for(int i=right;i>=left;i--)
            {
                arr[bottom][i]=A;
            }
            --bottom;

            for(int i=bottom;i>=top;i--)
            {
                arr[i][left]=A;
            }
            ++left;

            --A;
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> a = new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                a.add(arr[i][j]);
            }
            ans.add(a);
        }
        return ans;
    }
}
