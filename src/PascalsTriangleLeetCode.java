import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 4/12/2017.
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class PascalsTriangleLeetCode {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> tempList=new ArrayList<>();
            if(i==0)
                tempList.add(1);
            else{
                List<Integer> oldList=res.get(res.size()-1);
                tempList.add(1);
                for(int j=1;j<oldList.size();j++)
                    tempList.add(oldList.get(j-1)+oldList.get(j));
                tempList.add(1);
            }
            res.add(tempList);
        }
        return res;
    }

    public static void main(String args[]){
        List<List<Integer>> list=generate(5);
        for(List<Integer> l:list)
            System.out.println(l);
    }
}
