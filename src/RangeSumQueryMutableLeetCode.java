/**
 * Created by S N Rao on 1/25/2017.
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 *
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 */
public class RangeSumQueryMutableLeetCode {

    public static class NumArray {

        private int[] array;
        private int[] nums;
        public NumArray(int[] nums) {
            if(nums.length==0) return;
            this.nums=nums;
            int power=(int)Math.ceil((double)Math.log(nums.length)/(double)Math.log(2));
            int max_len=(int)Math.pow(2,power+1)-1;
            array=new int[max_len];
            fillArray(nums,0,0,nums.length-1);
        }

        public void fillArray(int[] nums,int pos,int s,int e){
            if(s==e) {
                array[pos]=nums[s];
                return;
            }

            int left=0,right=0;
            if(2*pos+1<array.length){
                fillArray(nums,2*pos+1,s,s+(e-s)/2);
                left=array[2*pos+1];
            }
            if(2*pos+2<array.length){
                fillArray(nums,2*pos+2,s+(e-s)/2+1,e);
                right=array[2*pos+2];
            }

            array[pos]=left+right;
        }

        public void update(int i, int val) {
            int low=0,high=nums.length-1,pos=0;
            array[pos]=array[pos]-nums[i]+val;
            while(low<high){
                int mid=low+(high-low)/2;
                if(i>mid){
                    low=mid+1;
                    pos=pos*2+2;
                    array[pos]=array[pos]-nums[i]+val;
                }
                else if(i<=mid){
                    high=mid;
                    pos=pos*2+1;
                    array[pos]=array[pos]-nums[i]+val;
                }
            }
            nums[i]=val;
        }

        public int sumRange(int i, int j) {
            return sum(i,j,0,nums.length-1,0);
        }

        private int sum(int i, int j,int low, int high, int pos){
            if(low==high) return nums[low];
            if(low==i && high==j) return array[pos];
            int mid=low+(high-low)/2;
            if(mid>=i && mid>=j)
                return sum(i,j,low,mid,2*pos+1);
            else if(mid<i && mid<j)
                return sum(i,j,mid+1,high,2*pos+2);
            else if(i<=mid && j>mid)
                return sum(i,mid,low,mid,2*pos+1) +sum(mid+1,j,mid+1,high,2*pos+2);
            else
                return 0;
        }
    }

    public static void main(String args[]){
        /**
         * Your NumArray object will be instantiated and called as such:
         * NumArray obj = new NumArray(nums);
         * obj.update(i,val);
         * int param_2 = obj.sumRange(i,j);
         */
        NumArray o=new NumArray(new int[]{-1});
        System.out.println(o.sumRange(0,0));
//        System.out.println(o.sumRange(2,4));
        o.update(0,1);
        System.out.println(o.sumRange(0,0));
//        System.out.println(o.sumRange(2,4));
    }


}
