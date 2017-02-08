/**
 * Created by S N Rao on 2/7/2017.
 *
 * Follow up for N-Queens problem.
 *
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 */
public class NQueensIILeetCode {

    static int count=0;

    public static int totalNQueens(int n) {
        backTrackFunction(n,0,new boolean[n],new boolean[2*n],new boolean[2*n]);
        return count;
    }

    private static void backTrackFunction(int n, int row, boolean[] colDone, boolean[] dia1Done, boolean[] dia2Done){
        if(row==n){
            count++;
            return;
        }
        for(int col=0;col<n;col++){
            int d1ID=row+col;
            int d2ID=n-(row-col);
            if(!colDone[col] && !dia1Done[d1ID] && !dia2Done[d2ID]){
                colDone[col]=dia1Done[d1ID]=dia2Done[d2ID]=true;
                backTrackFunction(n, row+1, colDone, dia1Done, dia2Done);
                colDone[col]=dia1Done[d1ID]=dia2Done[d2ID]=false;
            }
        }
    }



    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }
}

