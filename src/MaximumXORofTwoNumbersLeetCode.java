/**
 * Created by snrao on 12/13/16.
 */
public class MaximumXORofTwoNumbersLeetCode {

    public static class TreeNode{
        TreeNode one;
        TreeNode zero;
    }

    public static int findMaximumXOR(int[] nums) {
        TreeNode root=new TreeNode();

        //Constructing the trie and getting maxXOR while constructing itself.
        // Can do it in a separate loop after constructing also.
        int maxXOR=0;
        for(int i=0;i<nums.length;i++){
            TreeNode curr=root;
            TreeNode opposite=root;
            int XOR=0;
            for(int j=31;j>=0;j--){     //32 bits. Integer limit
                int mask=1<<j;
                if((mask & nums[i]) != 0){
                    if(curr.one==null)
                        curr.one=new TreeNode();
                    curr=curr.one;

                    if(opposite.zero!=null) {
                        opposite = opposite.zero;
                        XOR |= mask;
                    }
                    else
                        opposite=opposite.one;
                }
                else{
                    if(curr.zero==null)
                        curr.zero=new TreeNode();
                    curr=curr.zero;

                    if(opposite.one!=null){
                        opposite=opposite.one;
                        XOR |= mask;
                    }
                    else
                        opposite=opposite.zero;
                }
            }
            if(XOR>maxXOR)
                maxXOR=XOR;
        }

        return maxXOR;
    }

    public static void main(String args[]){
        int[] nums={3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums));
    }

}
