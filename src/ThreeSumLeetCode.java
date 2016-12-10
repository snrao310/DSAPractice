import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by snrao on 12/9/16.
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSumLeetCode {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == 0) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (nums[i] + nums[low] + nums[high] > 0) high--;
                else low++;
            }
        }
        return result;

    }

    public static void main(String args[]) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> k = threeSum(arr);
        for (List<Integer> l : k) {
            for (Integer m : l)
                System.out.print(m + " ");
            System.out.println();
        }

    }
}
