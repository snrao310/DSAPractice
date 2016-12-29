/**
 * Created by snrao on 12/28/16.
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 */
public class LinkedListCycleLeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slow=head.next;
        ListNode fast=head.next;
        if(fast!=null) fast=fast.next;
        //check if cycle exists
        while(fast!=null && slow!=fast){
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
        }
        if(slow==null || fast ==null || slow!=fast) return null;

        //find start of cycle
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
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
        System.out.println(detectCycle(one).val);
    }
}
