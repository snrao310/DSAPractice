import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 4/14/2017.
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 */
public class PascalsTriangleIILeetCode {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        res.add(1);
        for(int i=1;i<=rowIndex;i++){
            int prev=1;
            for(int j=1;j<res.size();j++){
                int sum=prev+res.get(j);
                prev=res.get(j);
                res.set(j,sum);
            }
            res.add(1);
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(getRow(4)); //[1, 4 ,6, 4, 1]
    }
}
