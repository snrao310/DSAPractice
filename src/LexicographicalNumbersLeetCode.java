import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 12/15/2016.
 *
 * Given an integer n, return 1 - n in lexicographical order.
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 */
public class LexicographicalNumbersLeetCode {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        backTrackOrder(result, n, 0);
        return result;
    }

    public static void backTrackOrder(List<Integer> list, int num, int prev) {
        if (prev * 10 > num)
            return;
        prev *= 10;
        for (int i = 0; i < 10; i++) {
            if (((prev + i) <= num) && ((prev + i) != 0)) {
                list.add(prev + i);
                backTrackOrder(list, num, prev + i);
            }
        }
    }

    public static void main(String args[]) {
        List<Integer> l = lexicalOrder(13);
        for (int i : l)
            System.out.print(i + " ");
    }

}
