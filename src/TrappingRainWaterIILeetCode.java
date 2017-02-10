import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by S N Rao on 2/9/2017.
 *
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

 * Note:
 * Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
 *
 * Example:
 *
 * Given the following 3x6 height map:
 * [
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 * ]
 *
 * Return 4.
 *
 */
public class TrappingRainWaterIILeetCode {

    private static class Cell{
        int i;
        int j;
        int height;
        Cell(int i, int j,int height){this.i=i;this.j=j;this.height=height;}
    }

    static int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public static int trapRainWater(int[][] heightMap) {
        if(heightMap==null || heightMap.length<3) return 0;
        PriorityQueue<Cell> minHeap=new PriorityQueue<>(new Comparator<Cell>(){
            @Override
            public int compare(Cell o1,Cell o2){
                if(o1.height>o2.height) return 1;
                if(o1.height<o2.height) return -1;
                return 0;
            }
        });

        int m=heightMap.length, n=heightMap[0].length;
        boolean[][] visited=new boolean[m][n];


        //add all border edges into heap.
        for(int i=0;i<m;i++){
            visited[i][0]=visited[i][n-1]=true;
            minHeap.offer(new Cell(i,0,heightMap[i][0]));
            minHeap.offer(new Cell(i,n-1,heightMap[i][n-1]));
        }
        for(int i=1;i<n-1;i++){
            visited[0][i]=visited[m-1][i]=true;
            minHeap.offer(new Cell(0,i,heightMap[0][i]));
            minHeap.offer(new Cell(m-1,i,heightMap[m-1][i]));
        }

        //BFS traversal
        int result=0;
        while(!minHeap.isEmpty()){
            Cell c=minHeap.poll();
            for(int[] d: dirs){
                int i=c.i + d[0];
                int j=c.j + d[1];
                if(i>=0 && j>=0 && i<m && j<n && !visited[i][j]){
                    visited[i][j]=true;
                    Cell newCell=new Cell(i,j,heightMap[i][j]);
                    if(newCell.height < c.height) {
                        result+=(c.height-newCell.height);
                        newCell.height = c.height;
                    }
                    minHeap.offer(newCell);
                }
            }
        }
        return result;
    }

    public static void main(String args[]){
        System.out.print(trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
    }
}
