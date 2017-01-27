/**
 * Created by S N Rao on 1/27/2017.
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 */
public class RemoveNthNodeFromEndOfListLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val=val;}
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode end=head,delete=head,prev=null;
        for(int i=0;i<n;i++) end=end.next;
        while(end!=null){
            prev=delete;
            end=end.next;
            delete=delete.next;
        }
        if(prev==null) return head.next;
        prev.next=delete.next;
        return head;
    }

    public static void main(String args[]){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head=removeNthFromEnd(head,2);
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }

}
