/**
 * Created by S N Rao on 4/3/2017.
 *
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is
 * used.
 *
 * Note:
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero
 * character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 *
 * Example 1:
 * Input:
 * 26
 * Output:
 * "1a"
 *
 * Example 2:
 * Input:
 * -1
 * Output:
 * "ffffffff"
 *
 */
public class ConvertANumberToHexadecimalLeetCode {

    //Can do it in the way we do decimal to binary by dividing by 16 and appending remainders. And then have to handle
    //negative number by subtracting each character from 15, adding 1 to last character. And then propogating carry.
    //But this method is much more awesome.
    public static String toHex(int num) {
        if(num==0) return "0";
        StringBuilder sb=new StringBuilder();
        while(num!=0){
            sb.append(intToHex(num&15));
            num >>>= 4; //Its not >> but >>>. >> will copy the sign bit. 10000 will become 11000 with >>, and 01000 with >>>.
        }               //>> is called arithmetic shift. >>> is logical shift.
        return sb.reverse().toString();
    }

    private static char intToHex(int i){
        if(i<10) return (char)(i+'0');
        return (char)('a' +(i-10));
    }

    public static void main(String args[]){
        System.out.println(toHex(-2));
        System.out.println(toHex(21));
    }
}
