/**
 * Created by S N Rao on 4/13/2017.
 *
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 * Input: "Hello, my name is John"
 * Output: 5
 *
 */
public class NumberOfSegmentsInAStringLeetCode {

    public static int countSegments(String s) {
        int res= 0;
        String[] parts=s.split(" ");
        for(String p:parts)
            if(p.length()!=0) res++;
        return res;
    }

    public static void main(String args[]){
        System.out.print(countSegments("Hello, When will I get a job?"));
    }
}
