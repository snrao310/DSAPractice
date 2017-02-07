/**
 * Created by S N Rao on 2/7/2017.
 *
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 *
 * Example:
 * Input:
 *  [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 *  ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 *
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 *
 */
public class DiagonalTraverseLeetCode {

    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0) return new int[0];
        int i=0,j=0,iIncr=-1,jIncr=1,resInd=0,m=matrix.length,n=matrix[0].length,total=m*n;
        int[] res=new int[m*n];
        if(m==1) return matrix[0];
        if(n==1) {
            for(int in=0;in<m;in++)res[in]=matrix[in][0];
            return res;
        }

        while(resInd!=m*n){
            if((i==0 || i==m-1)&&j+1<n){
                res[resInd++]=matrix[i][j++];
                res[resInd++]=matrix[i][j];
                iIncr=-iIncr; jIncr=-jIncr;
                i+=iIncr; j+=jIncr;
            }
            else if((j==0 || j==n-1)&&i+1<m){
                res[resInd++]=matrix[i++][j];
                res[resInd++]=matrix[i][j];
                iIncr=-iIncr; jIncr=-jIncr;
                i+=iIncr; j+=jIncr;
            }
            else if(i!=0 && j!=0 && i!=m-1 && j!=n-1){
                res[resInd++]=matrix[i][j];
                i+=iIncr; j+=jIncr;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res=findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}});
        for(int i: res)
            System.out.print(i+" ");
    }
}

