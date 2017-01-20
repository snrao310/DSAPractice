/**
 * Created by S N Rao on 1/20/2017.
 *
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 */
public class RotateListLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){this.val=val;}
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode t1=head,t2=head;
        int len=0,count=0;
        while(t1!=null){
            len++;
            t1=t1.next;
        }
        if(k>=len) k%=len;
        while(count!=k){
            count++;
            t2=t2.next;
        }
        t1=head;
        while(t2.next!=null){
            t1=t1.next;
            t2=t2.next;
        }
        t2.next=head;
        head=t1.next;
        t1.next=null;
        return head;
    }

    public static void main(String args[]){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next.next=new ListNode(7);

        head=rotateRight(head,2);
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
}
