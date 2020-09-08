/*
  
 You are given a grid A of size , two integers () and Q tasks. Each task contains two integers, (). Each cell in the grid is either empty cells denoted by O (Capital English character 'o') or occupied cells denoted by . Initially, you are at (). Find the minimum number of steps in which you have to take to reach () from () without traversing the occupied cells.

In a single step, you can move from any cell (i,j) to the 4 neighboring cells i.e. (,j), (,j), (i,) and (i,) provided these cells are inside the grid A.

Input Format
The first line of input contains 3 space separated integers N, M and Q where N and M denotes the dimensions of the grid A and Q denotes the number of tasks.
Each of the next N lines contain a string of length M,  character in the  line of which is either O or  denoting that the cell () is empty or occupied.
The next line contains 2 space separated integers  and  denoting the source cell of the grid.
This is followed by Q lines each containing 2 space separated integers  and .

Output Format
Print the answer to each query on a new line. If there is no path between () and () , print .


SAMPLE INPUT 
3 3 2
O*O
OOO
*OO
2 2
1 1
1 2
SAMPLE OUTPUT 
2
-1
 
 */

import java.util.*;
import javafx.util.Pair;
class Grid_Dijkstra_Algo_HE
{
    static char arr[][];
    static int n=0;
    static int m=0;
    static int d[][];
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int q=sc.nextInt();
        arr=new char[n][m];
        d=new int[n][m];
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.next().toCharArray();
        }
      
        int a=sc.nextInt();
        int b=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            Arrays.fill(d[i],-1);
        }
        
        dijk(new Pair<Integer, Integer>(a-1,b-1));
        for(int i=0;i<q;i++)
        {
            int dx=sc.nextInt();
            int dy=sc.nextInt();
            System.out.println(d[dx-1][dy-1]);
        }
        sc.close();
    }
    
    public static void dijk(Pair<Integer, Integer> src)
    {
        int a=src.getKey();
        int b=src.getValue();
        boolean v[][]=new boolean[n][m];
        int X[]={1,0,-1,0};
        int Y[]={0,1,0,-1};
        d[a][b]=0;
        v[a][b]=true;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty())
        {
            Pair<Integer, Integer> p=q.poll();
            for(int i=0;i<4;i++)
            {
                int x1 =p.getKey() + X[i];
                int y1=p.getValue() + Y[i];
                if(x1>=0 && x1<n && y1>=0 && y1<m && !v[x1][y1] && arr[x1][y1]=='O' )
                {
                    d[x1][y1]=d[p.getKey()][p.getValue()]+1;
                    q.add(new Pair<Integer, Integer>(x1,y1));
                    v[x1][y1]=true;
                }
            }
        }
    }
    
  
}