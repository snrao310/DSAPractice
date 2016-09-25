import java.util.EmptyStackException;
import java.util.EnumMap;

/**
 * Created by snrao on 9/24/16.
 */
public class QueueReverseKElements {

    private static class Queue{
        private static class QueueNode{
            public int data;
            public QueueNode next;
        }

        private QueueNode first;
        private QueueNode rear;
        private int size=0;


        public void enqueue(int data){
            QueueNode node=new QueueNode();
            node.data=data;

            if(rear!=null){
                rear.next=node;
            }

            rear=node;

            if(first==null){
                first=node;
            }

            size++;
        }

        public int dequeue() throws EmptyStackException{
            if(first==null){
                throw new EmptyStackException();
            }
            int data=first.data;
            first=first.next;
            if(first==null){
                rear=null;
            }
            size--;
            return data;
        }

        public int peek() throws EmptyStackException{
            if(first==null){
                throw new EmptyStackException();
            }
            return first.data;
        }

        public boolean isEmpty(){
            return (first==null);
        }

        public int getSize(){
            return size;
        }

        public void print(){
            if(first==null)
                return;
            QueueNode node=first;
            while(node!=rear){
                System.out.print(node.data+" ");
                node=node.next;
            }
            System.out.print(node.data+"\n");
        }
    }


    public static class Stack{
        public static class StackNode{
            public int data;
            public StackNode next;
        }

        private StackNode top;
        private int size=0;


        public void push(int data){
            StackNode node=new StackNode();
            node.data=data;
            node.next=top;
            top=node;
            size++;
        }

        public int pop() throws EmptyStackException{
            if(top==null){
                throw new EmptyStackException();
            }

            int data=top.data;
            top=top.next;
            size--;
            return data;
        }

        public int peek(){
            return top.data;
        }

        public boolean isEmpty(){
            return (top==null);
        }

        public int getSize(){
            return size;
        }
    }

    public static void reverseK(Queue queue, int k){
        Stack stack=new Stack();
        for(int i=0;i<k;i++){
            stack.push(queue.dequeue());
        }

        while (!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }

        int size=queue.getSize();
        for(int i=0;i<size-k;i++){
            queue.enqueue(queue.dequeue());
        }
    }

    public static void main(String args[]){
        Queue queue=new Queue();

        int input[]={1,3,4,5,5,6,6,7,7,8,8,9,1,8,2};
        for(int i=0;i<input.length;i++){
            queue.enqueue(input[i]);
        }

        int k=4;
        reverseK(queue, k);
        queue.print();
    }

}
