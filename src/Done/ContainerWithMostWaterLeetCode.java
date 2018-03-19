package Done;

/**
 * Created by snrao on 12/21/16.
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWaterLeetCode {

    //very non-intuitive but very concise method. Can't immediately see that it works. Proof by contradiction
    //provided in leetcode discussions.
    public static int maxArea(int[] height) {
        int leftWall = 0, rightWall = height.length - 1;
        int maxArea = 0;
        while (leftWall < rightWall) {
            maxArea = Math.max(maxArea, (rightWall - leftWall) * Math.min(height[leftWall], height[rightWall]));
            if(height[leftWall]<height[rightWall])
                leftWall++;
            else
                rightWall--;
        }
        return maxArea;
    }

    public static void main(String args[]) {
        System.out.println(maxArea(new int[]{1, 4, 5, 1}));
    }
}
