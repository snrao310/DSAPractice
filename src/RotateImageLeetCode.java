/**
 * Created by snrao on 12/19/16.
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Must do it in place.
 *
 */
public class RotateImageLeetCode {

    public static void rotate(int[][] matrix) {

        int minRow=0,maxRow=matrix.length-1,minCol=0,maxCol=matrix.length-1;

        while(minRow<maxRow){

            for(int i=minRow,k=0;i<maxRow;i++,k++){
                int temp1=matrix[minRow][i];
                int temp2=matrix[i][maxCol];
                int temp3=matrix[maxRow][maxCol-k];
                int temp4=matrix[maxRow-k][minCol];
                matrix[minRow][i]=temp4;
                matrix[i][maxCol]=temp1;
                matrix[maxRow][maxCol-k]=temp2;
                matrix[maxRow-k][minCol]=temp3;
            }

            minRow++;maxRow--;minCol++;maxCol--;
        }

    }

    public static void main(String args[]){
        int mat[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(mat);
        for(int[] m: mat){
            for(int i: m)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
