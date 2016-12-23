import java.util.Stack;

/**
 * Created by snrao on 12/22/16.
 *
 * Suppose we abstract our file system by a string in the following manner:
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * dir
 *      subdir1
 *      subdir2
 *              file.ext
 *
 * We are interested in finding the longest (number of characters) absolute path to a file within our file system.
 * For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and
 * its length is 32 (not including the double quotes).
 *
 * Given a string representing the file system in the above format, return the length of the longest absolute
 * path to file in the abstracted file system. If there is no file in the system, return 0.
 *
 */
public class LongestAbsoluteFilePathLeetCode {

    public static class MyInteger{
        int val=0;
    }


    //files can start with spaces. strings can start with files and don't have to go inside folders they start with
    //screwed up requirements on leet code not specified properly.
    //basic idea is to use a stack and keep pushing increasing string lengths till a file is obtained.
    //If string length at this stage is greater than max, replace max.
    //Not backtracking on string, since we never go back in the input string, the string presents the file structure in
    //a strictly forward manner based on tabs. Algorithm also keeps going forward using number of tabs to determine
    //depth.
    public static int lengthLongestPath(String input) {
        Stack<Integer> stack=new Stack();
        int ind=input.indexOf("\n");
        if(ind<0) {
            if(input.contains("."))
                return input.length();
            else
                return 0;
        }
        else {
            stack.push(ind);
            input=input.substring(ind+1);
        }
        MyInteger myint=new MyInteger();
        myint.val=0;
        recurse(input,stack,myint,0);
        return myint.val;
    }

    public static void recurse(String s, Stack<Integer> stack, MyInteger max,int currDepth){
        if(s==null || s.equals(""))
            return;

        int ind=s.indexOf("\n");
        int nowEnd=ind,laterStart=ind;
        if(nowEnd==-1)
            nowEnd = s.length();
        String nowString=s.substring(0,nowEnd);
        String laterString="";
        if(laterStart!=-1)
            laterString=s.substring(laterStart+1);
        int depth=0;
        int i,newSum=0;
        for(i=0;i<nowString.length();i++){
            if(nowString.charAt(i)=='\t')
                depth++;
            else
                break;
        }
        nowString=nowString.substring(i);
        if(depth<=currDepth){
            for(i=0;i<=(currDepth-depth);i++){
                stack.pop();
            }
        }

        if(!stack.isEmpty())
            newSum=1+stack.peek();
        newSum+=nowString.length();
        if(nowString.contains(".")){
            if(newSum>max.val)
                max.val=newSum;
            recurse(laterString,stack,max,depth-1);
        }
        else{
            stack.push(newSum);
            recurse(laterString,stack,max,depth);
        }

    }

    public static void main(String args[]){
        System.out.println(lengthLongestPath("dir\n    file.txt"));
    }
}
