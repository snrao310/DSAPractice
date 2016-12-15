/**
 * Created by snrao on 10/1/16.
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of
 * 1's in their binary representation and return them as an array.
 */
public class CountingBitsLeetCode {

    public static int[] countBits(int num) {
        int pointer=0;
        int result[]=new int[num+1];
        result[0]=0;
        if(num<1){              //trivial case. input is 0
            return result;
        }

        result[1]=1;
        for(int i=2;i<=num;i++){
            if((i & (i-1))==0){     //checking if number is power of 2. Awesome Bit manipulation method
                pointer=0;
            }
            result[i]=1+result[pointer];
            pointer++;
        }

        return result;
    }

    public static void main(String args[]){
        int result[]=countBits(5);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
