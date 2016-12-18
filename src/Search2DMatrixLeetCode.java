/**
 * Created by snrao on 12/17/16.
 *Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 */
public class Search2DMatrixLeetCode {

    //Every iteration eliminates at least one row or column or one row or both. Can be more than one. But atleast
    //one is eliminated. So in m+n steps, we will have the answer.
    public static boolean searchMatrix(int[][] matrix, int target) {
        int currMinRow=0,currMaxRow=matrix.length-1,currMinCol=0,currMaxCol=matrix[0].length-1;
        while(currMaxCol>=currMinCol && currMaxRow>=currMinRow){
            if(matrix[currMinRow][currMinCol]==target)
                return true;
            else if(matrix[currMinRow][currMinCol]>target)
                return false;

            if(matrix[currMinRow][currMaxCol]==target)
                return true;
            else if(matrix[currMinRow][currMaxCol]>target)
                currMaxCol--;
            else
                currMinRow++;

            if(matrix[currMaxRow][currMaxCol]==target)
                return true;
            else if(matrix[currMaxRow][currMaxCol]<target)
                return false;

            if(matrix[currMaxRow][currMinCol]==target)
                return true;
            else if(matrix[currMaxRow][currMinCol]>target)
                currMaxRow--;
            else
                currMinCol++;

        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(searchMatrix(new int[][]
                                        {{1,  4,  7, 11, 15},
                                        {2,   5,  8, 12, 19},
                                        {3,   6,  9, 16, 22},
                                        {10, 13, 14, 17, 24},
                                        {18, 21, 23, 26, 30}},26));
    }
}
