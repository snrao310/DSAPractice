import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 12/15/2016.
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 */
public class GrayCodeLeetCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        result.add(0);
        grayBackTrack(n,0,result);
        return result;
    }


    //Backtracking solution
    public static void grayBackTrack(int bits, int num, List<Integer> list){
        if(bits==0)
            return;

        grayBackTrack(bits-1,num,list);
        num=list.get(list.size()-1);
        int mask= 1<<(bits-1);
        if((num & mask)==0)
            num |= mask;
        else
            num ^= mask;

        list.add(num);
        grayBackTrack(bits-1,num,list);
    }


    public static void main(String args[]){
        List<Integer> l=grayCode(2);
        for(int i:l){
            System.out.print(i+" ");
        }
    }

}
