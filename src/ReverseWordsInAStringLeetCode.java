/**
 * Created by S N Rao on 1/26/2017.
 *
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 */
public class ReverseWordsInAStringLeetCode {

    public static String reverseWords(String s) {
        if(s.length()==0) return s;
        char[] st=s.toCharArray();
        reverse(st,0,st.length-1);
        reverseWordsReversed(st);
        return removeSpaces(st);
    }

    private static String removeSpaces(char[] st){
        int i=0,j=0;
        char prev=' ';
        while(i<st.length){
            if(st[i]==' ' && prev!=' ') {
                st[j] = st[i];
                j++;
            }
            else if(st[i]!=' '){
                st[j]=st[i];
                j++;
            }
            prev=st[i];
            i++;
        }
        if(j>0 && st[j-1]==' ') j--;
        return new String(st).substring(0,j);
    }

    private static void reverseWordsReversed(char[] st){
        String cur="";
        int start=0,end=0;
        for(int i=0;i<st.length;i++){
            if(st[i]!=' ') {
                cur+=st[i];
                end=i;
            }
            if(st[i]==' ' || i==st.length-1){
                if(!cur.equals(""))
                    reverse(st,start,end);
                cur="";
                start=i+1;
            }
        }
    }

    private static void reverse(char[] st,int s,int e){
        int i=0,n=(e-s)/2;
        for(i=0;i<=n;i++){
            char temp=st[i+s];
            st[i+s]=st[e-s-i+s];
            st[e-s-i+s]=temp;
        }
    }

    public static void main(String args[]){
        System.out.println(reverseWords("  The sky is  blue  "));
        System.out.println(reverseWords(""));
    }
}
