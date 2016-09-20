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
        int span[]=new int[input.length];
        Stack stack=new Stack();
        stack.push(input.length-1);

        for(int i=input.length-2;i>=0;i--){
            while(!stack.isEmpty() && input[i]>input[stack.peek()]){
                int k=stack.pop();
                span[k]=k-i;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int k=stack.pop();
            span[k]=k+1;
        }

        for(int i=0;i<input.length;i++){
            System.out.print(span[i]+ " ");
        }
    }

    public static void main(String args[]){
        int input[]={1,4,6,4,7,3,8,9,12,2,10};

        findLongestSpan(input);
    }

}
