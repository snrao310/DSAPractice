/**
 * Created by S N Rao on 8/23/2017.
 *
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 */
public class ReverseWordsInAStringLeetCode2 {

    public static String reverseWords(String s) {
        if(s.length()==0) return "";
        char[] st=s.toCharArray();
        reverse(st,0,st.length-1);
        reverseWordsOnly(st);
        return removeSpaces(st);
    }

    private static void reverse(char[] s,int start,int end){
        int mid=(end-start)/2;
        int n=end-start+1;
        for(int i=0;i<=mid;i++){
            char tem=s[i+start];
            s[i+start]=s[start+(n-i-1)];
            s[start+(n-i-1)]=tem;
        }
    }

    private static void reverseWordsOnly(char[] s){
        for(int i=0;i<s.length;i++){
            if(s[i]==' ') continue;
            else{
                int j=i;
                while(i<s.length && s[i]!=' ') i++;
                reverse(s,j,i-1);
            }
        }
    }

    private static String removeSpaces(char[] s){
        char prev=' ';
        int j=0;
        for(int i=0;i<s.length;i++){
            if(s[i]==' ' && (prev==' ')) continue;
            else s[j++]=s[i];
            prev=s[i];
        }
        if(j>0 && s[j-1]==' ') j--;
        return new String(s).substring(0,j);
    }


    public static void main(String args[]){
        System.out.println(reverseWords("  The sky is  blue  "));
        System.out.println(reverseWords(""));
    }
}
