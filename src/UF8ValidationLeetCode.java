/**
 * Created by snrao on 12/21/16.
 *
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 *
 * For 1-byte character, the first bit is a 0, followed by its unicode code.
 * For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most
 * significant 2 bits being 10.
 *
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
 * The input is an array of integers. Only the least significant 8 bits of each integer is used to store the
 * data. This means each integer represents only 1 byte of data.
 */
public class UF8ValidationLeetCode {

    public static boolean validUtf8(int[] data) {
        int pos = 0, index = 0;
        for (int currByte : data) {
            if (index != pos) {                 //not a starting byte
                if ((currByte & 192) != 128)    //first two bits not be 10
                    return false;
            } else {                                //starting byte
                if ((currByte & 248) == 248)        //more than 4 1's at start
                    return false;
                else if ((currByte & 240) == 240)   //4 1's at start, 4 byte set
                    pos += 4;
                else if ((currByte & 224) == 224)   //3 1's at start, 3 byte set
                    pos += 3;
                else if ((currByte & 192) == 192)   //2 1's at start, 2 byte set
                    pos += 2;
                else if ((currByte & 128) == 0)     //0 at start, 1 byte set
                    pos += 1;
                else return false;

                if (pos > data.length)
                    return false;
            }
            index++;
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(validUtf8(new int[]{235, 140, 4}));
    }
}
