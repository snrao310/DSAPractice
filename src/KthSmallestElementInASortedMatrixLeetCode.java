import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by S N Rao on 2/1/2017.
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element
 * in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 */
public class KthSmallestElementInASortedMatrixLeetCode {

    //Very similar to FindKPairsWithSmallestSumLeetCode
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]<o2[0]) return -1;
                return 0;
            }
        });
        for(int i=0;i<matrix[0].length;i++) heap.add(new int[]{matrix[0][i],0,i});
        int pos=0,num=0;
        while (pos!=k){
            pos++;
            int[] array=heap.poll();
            num=array[0];
            int i=array[1]+1,j=array[2];
            if(i<matrix.length) heap.add(new int[]{matrix[i][j],i,j});
        }
        return num;
    }

    public static void main(String args[]){
        System.out.print(kthSmallest(new int[][]{{1,  5,  9},{10, 11, 13},{12, 13, 15}},8));
    }
}
