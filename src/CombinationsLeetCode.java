import java.util.ArrayList;
import java.util.List;

/**
 * Created by snrao on 12/17/16.
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 */
public class CombinationsLeetCode {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        backTrackFunction(result,new ArrayList<>(),1,n,k);
        return result;
    }

    //backtrack function similar to permutations, combination sums, subset questions
    public static void backTrackFunction(List<List<Integer>> list, List<Integer> templist,
                                         int start,int n, int k){
        if(templist.size()==k)
            list.add(new ArrayList<>(templist));

        for(int i=start;i<=n;i++){
            templist.add(i);
            backTrackFunction(list,templist,i+1,n,k);
            templist.remove(templist.size()-1);
        }
    }

    public static void main(String args[]){
        List<List<Integer>> l=combine(4,2);
        for(List<Integer> li:l){
            for(int i:li)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
