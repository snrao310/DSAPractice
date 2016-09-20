/**
 * Created by snrao on 9/20/16.
 */
public class FirstSmallerElementOnRight {


    private static class StackWithArray{
        public int top;
        int stack[];
        int length;

        public StackWithArray(int length){
            this.length=length;
            top=-1;
            stack=new int[length];
        }

        public void push(int data){
            if(top==length-1){
                System.out.println("No Space");
                return;
            }
            stack[top+1]=data;
            top++;
        }

        public int pop(){
            if(top==-1) return -1;

            top--;
            return stack[top+1];
        }

        public int peek(){
            if(top==-1) return -1;

            return stack[top];
        }

        public boolean isEmpty(){
            return (top==-1);
        }
    }

    public static void findFistSmallElementOnRight(int[] input){
        int answer[]=new int[input.length];
        StackWithArray stack=new StackWithArray(20);
        stack.push(0);

        for(int i=1;i<input.length;i++){
                while(!stack.isEmpty() && input[i]<input[stack.peek()]){
                    int k=stack.pop();
                    answer[k]=i;
                }
                stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.pop()]=-1;
        }

        for(int i=0;i<input.length;i++){
            System.out.print(answer[i] + " ");
        }
    }

    public static void main(String args[]){
        int input[]={1,2,4,3,6,8,16,23,7,3,8,12};
        findFistSmallElementOnRight(input);
    }
}
