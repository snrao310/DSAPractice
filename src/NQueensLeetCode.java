import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by S N Rao on 2/7/2017.
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
 * queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *  "...Q",
 * "Q...",
 *  "..Q."],
 *
 * ["..Q.",  // Solution 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 *  ]
 *
 */
public class NQueensLeetCode {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        backTrackFunction(result,new ArrayList<String>(),0,n,new boolean[n],new boolean[2*n],new boolean[2*n]);
        return result;
    }



    private static void backTrackFunction(List<List<String>> list, List<String> tempList,
                                          int row, int n, boolean[] colDone, boolean[] dia1Done, boolean[] dia2Done) {
        if(row==n){
            list.add(new ArrayList(tempList));
            return;
        }
        char[] str=new char[n];
        Arrays.fill(str,'.');
        for(int col=0;col<n;col++){
            int d1ID=row+col;
            int d2ID=n-(row-col);
            if(!colDone[col] && !dia1Done[d1ID] && !dia2Done[d2ID]){
                colDone[col]=dia1Done[d1ID]=dia2Done[d2ID]=true;
                str[col]='Q'; tempList.add(new String(str));
                backTrackFunction(list, tempList, row+1, n, colDone, dia1Done, dia2Done);
                colDone[col]=dia1Done[d1ID]=dia2Done[d2ID]=false;
                str[col]='.'; tempList.remove(tempList.size()-1);
            }
        }
    }



    public static void main(String[] args) {
        List<List<String>> list=solveNQueens(4);
        for(List<String> l:list){
            for(String s: l)
                System.out.println(s);
            System.out.println();
        }
    }

}
