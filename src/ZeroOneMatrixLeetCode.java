import java.util.*;

/**
 * Created by S N Rao on 4/4/2017.
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 * Example 1:
 * Input:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Output:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * Example 2:
 * Input:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * Output:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * Note:
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 *
 */
public class ZeroOneMatrixLeetCode {

    static int[][] dirns= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    //BFS: Put all the 0s in the queues and then do bfs updating distances in the result matrix.
    public static List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> res=new ArrayList<>(matrix); //distances (result)
        if(matrix.size()==0) return res;
        int m=matrix.size(),n=matrix.get(0).size();
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix.get(i).get(j)==0){
                    queue.offer(new int[]{i,j});
                    visited[i][j]=true;
                    res.get(i).set(j,0); //redundant since its defined as a copy of matrix. Just for understanding.
                }
            }
        }

        //BFS
        queue.offer(null);
        int dist=0;
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            if(cur!=null){
                int i=cur[0], j=cur[1];
                for(int[] d:dirns){
                    int inew=i+d[0], jnew=j+d[1];
                    if(inew>=0 && inew<m && jnew>=0 && jnew<n && !visited[inew][jnew]){
                        visited[inew][jnew]=true;
                        queue.offer(new int[]{inew,jnew});
                        res.get(inew).set(jnew,dist+1);
                    }
                }
            }
            else {
                if(!queue.isEmpty())
                    queue.offer(null);
                dist++;
            }
        }
        return res;
    }

    public static void main(String args[]){
        List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(0,0,0)));
        list.add(new ArrayList<>(Arrays.asList(0,1,0)));
        list.add(new ArrayList<>(Arrays.asList(1,1,1)));
        List<List<Integer>> res=updateMatrix(list);

        for(List l: res)
            System.out.println(l);
    }
}
