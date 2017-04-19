/**
 * Created by S N Rao on 4/18/2017.
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 */
public class LinkedListCycleLeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    //Once both pointers are inside the loop, the faster one will always catch up with the slower pointer
    //as long as the difference in their speeds is coprime with the length of the loop (coprime means their
    //gcd is 1). Since the speed difference here is 1, its coprime with any loop-length and it will always
    //meet. Another way to think of this is that looking at the fast pointer as if its behind the slower one
    //in the loop, it is true that at every iteration,the distance between the pointers reduces by 1.
    //Eventually, they meet.
    public static boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode fast=head.next.next, slow=head.next;
        while(fast!=null){
            if(slow==fast)  return true;
            slow=slow.next;
            fast=fast.next;
            if(fast!=null) fast=fast.next;
        }
        return false;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(2);
        one.next=new ListNode(3);
        one.next.next=new ListNode(8);
        ListNode six=new ListNode(6);
        one.next.next.next=six;
        one.next.next.next.next=new ListNode(1);
        one.next.next.next.next.next=new ListNode(4);
        one.next.next.next.next.next.next=six;
        System.out.println(hasCycle(one));
    }
}
