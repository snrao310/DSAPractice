/**
 * Created by snrao on 9/24/16.
 */
public class QueueWithArray {

    private static class QueueArray{
        public int front;
        public int rear;
        public int size;
        public int capacity;
        int queue[];

        public QueueArray(int capacity){
            front=0;
            rear=-0;
            size=0;
            this.capacity=capacity;
            queue=new int[capacity];
        }

        public void enqueue(int data) throws ArrayIndexOutOfBoundsException{
            if(size==capacity){
                throw new ArrayIndexOutOfBoundsException();
            }
            queue[rear]=data;
            rear=(rear+1)%capacity;
            size++;
        }

        public int dequeue() throws ArrayIndexOutOfBoundsException{
            if(size==0){
                throw new ArrayIndexOutOfBoundsException();
            }
            int data=queue[front];
            size--;
            front=(front+1)%capacity;
            return data;
        }

        public int peek() throws ArrayIndexOutOfBoundsException{
            if(size==0){
                throw new ArrayIndexOutOfBoundsException();
            }
            return queue[front];
        }

        public boolean isEmpty(){
            return (size==0);
        }

        public void printQueue(){
            for(int i=0;i<size;i++){
                System.out.print(" "+this.peek());
                this.enqueue(this.dequeue());
            }
            System.out.println();
        }
    }


    public static void main(String args[]){
        QueueArray queueArray=new QueueArray(5);
        queueArray.enqueue(6);
        queueArray.enqueue(7);
        queueArray.enqueue(8);
        queueArray.enqueue(2);
        queueArray.printQueue();
    }


}
