import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 3/30/2017.
 *
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully
 * (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
 * spaces ' ' when necessary so that each line has exactly L characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 *
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 *
 * Note: Each word is guaranteed not to exceed L in length.
 *
 * Corner Cases:
 * A line other than the last line might contain only one word. What should you do in this case?
 * In this case, that line should be left-justified.
 *
 */
public class TextJustificationLeetCode {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            int spaceLen=1, curLen=0,numWords=0;
            StringBuilder line=new StringBuilder(),spaces=new StringBuilder();
            String w=words[i]; int j=i;

            //Counting words in this line.
            while(curLen+w.length()<=maxWidth){
                curLen+=(w.length()+1);
                numWords++; j++;
                if(j==words.length) break;
                w=words[j];
            }
            int lastWordIndex=i+numWords-1;
            curLen--;j=0;

            //Only one word or last line. Left-justified.
            if(numWords==1 || lastWordIndex==words.length-1){
                line.append(words[i]);
                for(int k=i+1;k<=lastWordIndex;k++) line.append(" "+words[k]);
                while(j++<maxWidth-line.length()) spaces.append(' ');
                res.add(line.toString()+spaces.toString());
            }

            //Else justify
            else{
                spaceLen+=(maxWidth-curLen)/(numWords-1);       //Remaining gap divided between all spaces
                while(j++<spaceLen) spaces.append(' ');
                int extraSpaces=(maxWidth-curLen)%(numWords-1);     //Remainder while dividing. Less than number of spaces.
                for(j=i;j<=lastWordIndex;j++){
                    line.append(words[j]);
                    if(j!=lastWordIndex)
                        line.append(spaces.toString());
                    if(extraSpaces!=0){                         //Giving one space from remainder to the spaces in order
                        line.append(' ');                       //of spaces from left to right till there are more.
                        extraSpaces--;
                    }
                }
                res.add(line.toString());
            }
            i=lastWordIndex;
        }
        return res;
    }

    public static void main(String args[]){
        List<String> list=fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification.",
                "That","is","so","great","justification.","That","is."},16);
        for(String s: list)
            System.out.println(s);
    }
}
