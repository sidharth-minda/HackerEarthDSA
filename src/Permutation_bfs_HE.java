/*
Permutation
Given a permutation of 1 to n, you need to perform some operations to make it into increasing order. Each operation is to reverse an interval  (a prefix). Your goal is to minimize the number of operations.

Input

The first line contains an integer  ().

The second line contains  space separated integers, representing the sequence .

Output

An integer representing the answer, that is, the minimum number of operations needed to make the permutation into increasing order.

SAMPLE INPUT 
3
3 1 2
SAMPLE OUTPUT 
2
*/



import java.util.*;
class Permutation_bfs_HE
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        StringBuilder src1 = new StringBuilder();
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            src1.append(arr[i]);
        }
        String src = src1.toString();
        Arrays.sort(arr);
        StringBuilder src2 = new StringBuilder();
        for(int i=0;i<n;i++)
        {
        	src2.append(arr[i]);
        }
        String dest = src2.toString();
        Queue<String> q = new LinkedList<>();
        q.add(src);
        HashMap<String, Integer> map = new HashMap<>();
        map.put(src,0);
        
        outer:while(!q.isEmpty())
        {
        	String p = q.poll();
        	for(int i=2;i<=p.length();i++)
        	{
        		StringBuilder curr = new StringBuilder(p);
        		StringBuilder temp = new StringBuilder(curr.substring(0,i));
        		temp.reverse();
        		curr.replace(0, i, temp.toString());
        		if(!map.containsKey(curr.toString()))
        		{
        			map.put(curr.toString(),map.get(p)+1);
        			q.add(curr.toString());
        			if(curr.toString().equals(dest))
        				break outer;
        		}
        	}
        }
        System.out.println(map.get(dest));
        sc.close();
    }
}

