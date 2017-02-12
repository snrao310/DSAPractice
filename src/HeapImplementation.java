import java.util.EmptyStackException;

/**
 * Created by S N Rao on 2/11/2017.
 */
public class HeapImplementation {

    public static class Heap {

        private int[] array;
        private int size;
        private int capacity;

        public Heap(int capacity){
            array=new int[capacity];
            size=0;
            this.capacity=capacity;
        }

        public void offer(int e) {
            if(size==capacity) return;
            size++;
            int i=size-1;
            while(i>0 && e<array[(i-1)/2]){
                array[i]=array[(i-1)/2];
                i=(i-1)/2;
            }
            array[i]=e;
        }

        public int leftChild(int i) {
            if(2*i+1<size) return 2*i+1;
            return -1;
        }

        public int rightChild(int i) {
            if(2*i+2<size) return 2*i+2;
            return -1;
        }

        public int pollMin() {
            if(size==0) throw new EmptyStackException();
            int min=array[0];
            array[0]=array[size-1];
            size--;
            heapify(0);
            return min;
        }

        private void swap(int i, int j){
            int temp=array[i];
            array[i]=array[j];
            array[j]=temp;
        }

        private void heapify(int i){
            int left=leftChild(i), right=rightChild(i), min=i;
            if(left!=-1 && array[left]<array[min])
                min=left;
            if(right!=-1 && array[right]<array[min])
                min=right;
            if(min!=i){
                swap(min,i);
                heapify(min);
            }
        }

        public boolean isEmpty(){
            return size==0;
        }
    }

    public static void main(String args[]) {
        Heap heap=new Heap(12);
        heap.offer(34); heap.offer(23);heap.offer(35);heap.offer(54);heap.offer(12);
        while(!heap.isEmpty()){
            System.out.print(heap.pollMin()+" ");
        }
    }

}
