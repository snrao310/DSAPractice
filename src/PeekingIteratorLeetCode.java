import java.util.Iterator;

/**
 * Created by snrao on 12/21/16.
 *
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator
 * that support the peek() operation -- it essentially peek() at the element that will be returned by the next
 * call to next().
 *
 */
public class PeekingIteratorLeetCode {
    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.htm
    class PeekingIterator implements Iterator<Integer> {

        Iterator<Integer> iterator;
        boolean peeked;
        int peekedVal;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator=iterator;
            peeked=false;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if(!peeked){
                peeked=true;
                peekedVal=iterator.next();
            }
            return peekedVal;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if(peeked){
                peeked=false;
                return peekedVal;
            }
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            if(peeked)
                return true;
            return iterator.hasNext();
        }
    }
}
