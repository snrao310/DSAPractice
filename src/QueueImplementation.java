import java.util.EmptyStackException;

/**
 * Created by S N Rao on 2/4/2017.
 */
public class QueueImplementation {

    public static class QueueList{
        public class QueueNode{
            int val;
            QueueNode next;
        }

        QueueNode front,back;
        int size=0;

        public void enqueue(int val){
            QueueNode s=new QueueNode();
            s.val=val;

            if(back!=null)
                back.next=s;
            else
                front=s;

            back=s;
            size++;
        }

        public int dequeue(){
            if(size==0) throw new EmptyStackException();
            int val=front.val;
            front=front.next;
            if(front==null) back=null;
            size--;
            return val;
        }

        public int getSize(){
            return size;
        }

        public boolean isEmpty(){
            return size==0;
        }
    }

    public static class QueueArray{
        int MAX_SIZE=20;
        int[] queue=new int[MAX_SIZE];
        int front=0,back=0,size=0;

        public void enqueue(int val){
            if(size==MAX_SIZE) return;
            size++;
            queue[back]=val;
            back=(back+1)%MAX_SIZE;
        }

        public int dequeue(){
            if(size==0) throw new EmptyStackException();
            size--;
            int val=queue[front];
            front=(front+1)%MAX_SIZE;
            return val;
        }

        public int getSize(){
            return size;
        }

        public boolean isEmpty(){
            return size==0;
        }
    }

    public static void main(String args[]){
        QueueList q=new QueueList();
        q.enqueue(5);q.enqueue(54);q.enqueue(76);
        System.out.println(q.dequeue()+" "+q.getSize()+" "+q.isEmpty()+" "+q.dequeue()+" "+q.dequeue()+" "+q.isEmpty());

        QueueArray qq=new QueueArray();
        qq.enqueue(5);qq.enqueue(54);qq.enqueue(76);
        System.out.println(qq.dequeue()+" "+qq.getSize()+" "+qq.isEmpty()+" "+qq.dequeue()+" "+qq.dequeue()+" "+qq.isEmpty());
    }
}
