import java.util.*;
public class Odd_Even_Subarrays_HE
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(arr[i]%2==1)
                arr[i]=-1;
            else
                arr[i]=1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        long count=0;
        map.put(arr[0],1);
        map.put(0,1);
        for(int i=1;i<n;i++)
        {
            arr[i]+=arr[i-1];
            if(!map.containsKey(arr[i]))
                map.put(arr[i], 0);
            count+=map.get(arr[i]);
            map.put(arr[i], map.get(arr[i])+1 );
        }
        System.out.println(count);
        sc.close();
    }
}