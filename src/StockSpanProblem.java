/**
 * Created by S N Rao on 9/19/2016.
 */
public class StockSpanProblem {

    private static class Stack{
        private static class StackNode{
            public int data;
            public StackNode next;
        }

        public StackNode top;

        public void push(int data){
            StackNode node=new StackNode();
            node.data=data;
            node.next=top;
            top=node;
        }

        public int pop(){
            if(top==null){
                return -1;
            }
            int data=top.data;
            top=top.next;
            return data;
        }

        public int peek(){
            if(top==null){
                return -1;
            }
            return top.data;
        }

        public boolean isEmpty(){
            return (top==null);
        }

    }

    public static void findLongestSpan(int[] input){
        int pointer1=input.length;
        int pointer2=input.length;
        int span[input.length];
        Stack stack=new Stack();
        stack.push(input[input.length-1]);

        while(pointer1)

        while(pointer1!=0){
            pointer2--;
            if(input[pointer2]>input[pointer1]){
                span[pointer1]=(pointer2-pointer1);
                stack.pop();
                pointer1++;
            }
            else if(input[pointer2]<input[pointer1]){
                stack.push(input[pointer2]);
                pointer1--;
            }
        }
    }

    public static void main(String args[]){
        int input[]={1,4,6,4,7,3,8,9,12,2,10};

        findLongestSpan(input);
    }

}
