/**
 * Created by S N Rao on 5/6/2017.
 *
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits
 * existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.
 *
 * Example 1:
 * Input: 12
 * Output: 21
 *
 * Example 2:
 * Input: 21
 * Output: -1
 *
 */
public class NextGreaterElementIIILeetCode {

    //Same thing as NextPermutationLeetCode. Find the last peak in the array in number and swap the number before the
    //peak with the smallest number after the peak [number that would comes after the (number before peak) in sorted
    //array of these elements]. Then, reverse everything from this last peak to the end of array. That's it. O(n) time.
    public static int nextGreaterElement(int num) {
        char[] n=Integer.toString(num).toCharArray();
        int lowest=-1, next=-1;
        for(int i=0;i<n.length-1;i++){
            if(n[i]<n[i+1]){
                lowest=i; next=i+1;
            }
            else if(lowest>=0 && n[i+1]>n[lowest])
                next=i+1;
        }

        if(lowest==-1) return -1;
        swap(n,lowest,next);
        reverse(n, lowest+1);
        long res=Long.parseLong(new String(n));
        if(res>Integer.MAX_VALUE) return -1;
        else return (int) res;
    }

    private static void swap(char[] n, int i,int j){
        char temp=n[i];
        n[i]=n[j];
        n[j]=temp;
    }

    private static void reverse(char[] n, int start){
        int size=n.length-start;
        for(int i=0;i<size/2;i++){
            swap(n,start+i,size-i-1+start);
        }
    }

    public static void main(String args[]){
        System.out.print(nextGreaterElement(1243));
    }
}
