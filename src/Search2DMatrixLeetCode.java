/**
 * Created by snrao on 12/21/16.
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following
 * properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 */
public class Search2DMatrixLeetCode {

    //2d binary search. For MxN matrix, complexity is O(logM+logN).
    public static boolean searchMatrix(int[][] matrix, int target) {
        int low=0,high=matrix.length-1;
        if(high==-1)
            return false;
        while (low<=high){
            int mid=(low+high)/2;
            if(matrix[mid][0]==target)
                return true;
            if(matrix[mid][0]>target)
                high=mid-1;
            else
                low=low+1;
        }


        int theRow=0;
        if(low!=matrix.length && matrix[low][0]<target)
            theRow=low;
        else if(high!=-1 && matrix[high][0]<target)
            theRow=high;
        else return false;

        low=0;high=matrix[0].length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(matrix[theRow][mid]==target)
                return true;
            if(matrix[theRow][mid]>target)
                high=mid-1;
            else
                low=low+1;
        }
        return false;
    }


    public static void main(String args[]){
        System.out.println(searchMatrix(new int[][]{{1,3,5,7}, {10,1,16,20},{23,30,34,50}},3));
        System.out.println(searchMatrix(new int[][]{{1}},0));
    }
}

