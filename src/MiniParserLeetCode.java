/**
 * Created by snrao on 12/31/16.
 *
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Code is commented here coz internal implementation of NestedInteger is not provided by LeetCode.
 */
public class MiniParserLeetCode {

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */

/**
    public class Solution {
        public NestedInteger deserialize(String s) {
            NestedInteger nest=new NestedInteger();
            if(s.equals("") || s.equals("[]")) return nest;
            NestedInteger element=null;
            boolean noCommas=true,hasList=false,isList=false;
            String current="";
            if(s.charAt(0)=='[') {
                isList=true;
                s=s.substring(1,s.length()-1);
            }
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(Character.isDigit(ch) || ch=='-')
                    current+=ch;
                else if(ch=='['){
                    hasList=true;
                    int open=1;current+=s.charAt(i);
                    while (open!=0){
                        i++;
                        if(s.charAt(i)=='[') open++;
                        else if(s.charAt(i)==']') open--;
                        current+=s.charAt(i);
                    }
                    System.out.println(current);
                    element=deserialize(current);
                }
                if(ch==',' || i==s.length()-1){
                    if(ch==',') noCommas=false;
                    if(!hasList){
                        if(noCommas&&i==s.length()-1&&!isList) return new NestedInteger(Integer.parseInt(current));
                        nest.add(new NestedInteger(Integer.parseInt(current)));
                    }
                    else{
                        nest.add(element);
                        hasList=false;
                    }
                    current="";
                }
            }
            return nest;
        }
    }
    */
}
