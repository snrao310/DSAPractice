import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 3/27/2017.
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the
 * minutes (0-59).
 *
 * Each LED represents a zero or one, with the least significant bit on the right.
 *
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times
 * the watch could represent.
 *
 * Example:
 *
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should
 * be "10:02".
 *
 */
public class BinaryWatchLeetCode {

    public static List<String> readBinaryWatch(int num) {
        List<String> res=new ArrayList<>();
        if(num==0){res.add("0:00"); return res;}
        if(num>10) return res;

        for(int i=0;i<=num && i<=4;i++){
            List<Integer> hList=new ArrayList<>();
            List<Integer> mList=new ArrayList<>();
            backTrackFunction(i,hList,4,0);
            backTrackFunction(num-i,mList,6,0);
            for(int h:hList){
                if(h>=12) continue;
                for(int m:mList) {
                    if (m >= 60) continue;
                    res.add(h + ":" + ((m > 9) ? m : ("0" + m)));
                }
            }
        }
        return res;
    }

    private static void backTrackFunction(int num, List<Integer> list, int place, int current){
        if(place<num || num<0) return;
        if(place>=0 && num==0) {
            list.add(current);
            return;
        }

        for(int i=place-1;i>=0;i--){
            current+=(1<<i); //2^i
            backTrackFunction(num-1,list,i,current);
            current-=(1<<i);
        }
    }

    public static void main(String args[]){
        System.out.print(readBinaryWatch(1));
    }
}
