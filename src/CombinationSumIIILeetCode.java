import java.util.ArrayList;
import java.util.List;

/**
 * Created by snrao on 12/12/16.
 *
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers
 * from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
public class CombinationSumIIILeetCode {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        backTrackFunction(result,new ArrayList<>(), n, k,1);
        return result;
    }

    public static void backTrackFunction(List<List<Integer>> list, List<Integer> tempList,
                                         int remain, int sizeRemain, int start){
        if(remain==0 && sizeRemain==0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        if(remain<0 || sizeRemain<0)
            return;

        for(int i=start;i<10;i++){
            tempList.add(i);
            backTrackFunction(list,tempList,remain-i,sizeRemain-1,i+1);
            tempList.remove(tempList.size()-1);
        }
    }


    public static void main(String args[]){
        List<List<Integer>> l=combinationSum3(3,9);

        for(List<Integer> k: l){
            for(int p:k) {
                System.out.print(p + " ");
            }
            System.out.println();
        }

    }
}
