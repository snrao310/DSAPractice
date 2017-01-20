/**
 * Created by S N Rao on 1/19/2017.
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 */
public class ReorderListLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){this.val=val;}
    }

    public static void reorderList(ListNode head) {
        if(head==null || head.next==null ||head.next.next==null) return;
        ListNode l1=head,l2=head;
        while(l2.next!=null){
            l1=l1.next;
            l2=l2.next;
            if(l2.next!=null) l2=l2.next;
        }
        ListNode t1=l1,t2=t1.next,t3=(t2!=null)?t2.next:null;
        t1.next=null;
        while(t2!=null){
            t2.next=t1;
            t1=t2; t2=t3; t3=(t3!=null)?t3.next:null;
        }
        ListNode forward=head,backward=l2,nextBack,nextFront;
        while(backward.next!=null){
            nextBack=backward.next;
            nextFront=forward.next;
            forward.next=backward;
            backward.next=nextFront;
            backward=nextBack;
            forward=nextFront;
        }
    }

    public static void main(String args[]){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next.next=new ListNode(7);

        reorderList(head);
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
}
