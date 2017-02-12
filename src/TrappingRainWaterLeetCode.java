import java.util.Stack;

/**
 * Created by S N Rao on 2/9/2017.
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 *
 */
public class TrappingRainWaterLeetCode {

    public static int trap(int[] height) {
        if(height.length<3) return 0;
        int[] nextGreaterOrEqual=findNextGreater(height);
        int[] largestOnRight=findLargestOnRight(height);
        int i=0,volume=0,next=0;
        while(i<height.length-1){
            int nGE=nextGreaterOrEqual[i];
            int lOR=largestOnRight[i];
            if(nGE!=-1){
                volume+=(height[i]*(nGE-i-1));
                i++; next=nGE;
            }
            else{
                volume+=(height[lOR]*(lOR-i-1));
                i++; next=lOR;
            }
            while(i!=next){
                volume-=height[i];
                i++;
            }
        }
        return volume;
    }

    private static int[] findNextGreater(int[] height){
        int[] res=new int[height.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<height.length;i++){
            while(!stack.isEmpty() && height[i]>=height[stack.peek()])
                res[stack.pop()]=i;
            stack.push(i);
        }
        while(!stack.isEmpty())
            res[stack.pop()]=-1;
        return res;
    }

    private static int[] findLargestOnRight(int[] height){
        int[] res=new int[height.length];
        int max=height.length-1;
        res[height.length-1]=-1;
        for(int i=height.length-2;i>=0;i--){
            res[i]=max;
            if(height[i]>height[max]) max=i;
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
