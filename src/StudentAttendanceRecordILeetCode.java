/**
 * Created by S N Rao on 4/17/2017.
 *
 * You are given a string representing an attendance record for a student. The record only contains the following three
 * characters:
 *
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two
 * continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 *
 */
public class StudentAttendanceRecordILeetCode {

    public static boolean checkRecord(String s) {
        int absents=0, lates=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='A') absents++;
            if(ch=='L'){
                if(i>1 && s.charAt(i-1)==s.charAt(i-2) && s.charAt(i-1)=='L') lates++;
            }
        }
        if(absents<2 && lates==0) return true;
        return false;
    }

    public static void main(String args[]){
        System.out.print(checkRecord("PALLL"));
    }
}
