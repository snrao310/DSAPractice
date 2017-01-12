/**
 * Created by S N Rao on 1/12/2017.
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 *
 */
public class SortListLeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(){}
        ListNode(int x) { val = x; }
    }

    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode head1=head,head2=head;
        while(head2!=null){
            head2=head2.next;
            if(head2!=null){
                head2=head2.next;
                if(head2!=null)
                    head1=head1.next;
            }
        }head2=head1.next;
        head1.next=null;
        head1=head;

        head1=sortList(head1);
        head2=sortList(head2);
        ListNode head3=new ListNode(),temp=head3;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                temp.next=head1;
                head1=head1.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
            }
            temp=temp.next;
            temp.next=null;
        }
        if(head1!=null) temp.next=head1;
        else temp.next=head2;

        return head3.next;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(2);
        one.next=new ListNode(3);
        one.next.next=new ListNode(5);
        one.next.next.next=new ListNode(6);
        one.next.next.next.next=new ListNode(9);
        one.next.next.next.next.next=new ListNode(7);

        one=sortList(one);
        while(one!=null){
            System.out.print(one.val+" ");
            one=one.next;
        }
    }
}
