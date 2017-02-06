import java.util.EmptyStackException;

/**
 * Created by S N Rao on 2/4/2017.
 */
public class StackImplementation {

    public static class StackList{
        private class StackNode{
            int val;
            StackNode next;
        }

        StackNode top;
        int size=0;

        public void push(int val){
            StackNode s=new StackNode();
            s.val=val;
            s.next=top;
            top=s;
            size++;
        }

        public int pop(){
            if(size==0) throw new EmptyStackException();
            int val=top.val;
            top=top.next;
            size--;
            return val;
        }

        public boolean isEmpty(){
            return size==0;
        }

        public int getSize(){
            return size;
        }
    }

    public static class StackArray{
        int MAX_SIZE=20;
        int[] stack=new int[MAX_SIZE];
        int top=-1;
        int size=0;

        public void push(int val){
            if(size==MAX_SIZE) return;
            size++;top++;
            stack[top]=val;
        }

        public int pop(){
            if(size==0) throw new EmptyStackException();
            size--;top--;
            return stack[top+1];
        }

        public boolean isEmpty(){
            return size==0;
        }

        public int getSize(){
            return size;
        }
    }

    public static void main(String args[]){
        StackList s=new StackList();
        s.push(4); s.push(5); s.push(7);
        System.out.println(s.pop()+" "+s.pop()+" "+s.isEmpty()+" "+s.pop()+" "+s.isEmpty());

        StackArray ss=new StackArray();
        ss.push(4); ss.push(5); ss.push(7);
        System.out.println(ss.pop()+" "+ss.pop()+" "+ss.isEmpty()+" "+ss.pop()+" "+ss.isEmpty());
    }
}
