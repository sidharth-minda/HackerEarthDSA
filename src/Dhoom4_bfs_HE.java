/* Samarpit is the main hero of the Dhoom 4.He is trying to steal from the Code Bank Of Hackers.Samarpit has a key with an integer value printed on it. He also has N other keys with each key having its own specific value.Samarpit is trying to break the Lock for which he is supposed to get to the lock's key value. He can perform one type of operation.Take his own key and one of the other N keys and merge them.During merging Samarpit's Key value changes to product of both the keys modulus 100000.

For example if his key value was X and he took a key with value Y the his new key will be (X*Y)%100000.The other key that was used during the merging process remains along with other N-1 keys.

This entire process of merging takes 1 second.Now since he is in a hurry he asks to you to find the minimum time in which he could reach to the lock's key value.

Input:
The first line contains 2 integers they are Samarpit's Key value and the Lock's key value.
The second line contains N indicating the number of other keys Samarpit has.
Third line contains N space separated integers indicating the value of N other keys.

Output:
The minimum time required to get to the Lock's Key.If he is unable to reach that print -1.

Constraints:
1 ≤ N ≤ 1000
1 ≤ Value of all the keys ≤ 100000

SAMPLE INPUT 
3 30
3
2 5 7
SAMPLE OUTPUT 
2
Explanation
In the first second he can take make his own key to value 6 by multiplying it by 2.Then in the next second he can multiply his new key with 5 to get to 30.
*/



import java.util.*;
public class Dhoom4_bfs_HE
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int lock=sc.nextInt();
        int n=sc.nextInt();
        int arr[] = new int[n];
        int mod=100000;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        boolean v[] = new boolean[100001];
        int st[] = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        v[x]=true;
        int flag=0;
        while(!q.isEmpty())
        {
            int p=q.poll();
            for(int i=0;i<n;i++)
            {
                Long t=((long)p*arr[i]) % mod;
                int temp=t.intValue();
                if(!v[temp])
                {
                    v[temp]=true;
                    q.add(temp);
                    st[temp]=st[p]+1;
                    if(temp==lock)
                    {
                        flag=1;
                        break;
                    }
                }
            }
        }
        if(flag==1)
            System.out.println(st[lock]);
        else
            System.out.println(-1);
        sc.close();
    }
}