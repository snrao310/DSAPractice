/**
 * Created by S N Rao on 12/14/2016.
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 */
public class UniqueBinarySearchTreesLeetCode {

    public static int numTrees(int n){
        if(n==0 || n==1)
            return 1;


        //Lets go for bottom up DP this time. Mainly coz we are going to need all elements under n to be filled.
        int[] DPArray=new int[n+1];
        DPArray[0]=1;
        DPArray[1]=1;
        for(int i=2;i<=n;i++){
            int temp=0;
            for(int j=0;j<i;j++){
                temp+=(DPArray[j]*DPArray[i-j-1]);
            }
            DPArray[i]=temp;
        }
        return DPArray[n];
    }

    public static void main(String args[]){
        System.out.print(numTrees(3));
    }
}
