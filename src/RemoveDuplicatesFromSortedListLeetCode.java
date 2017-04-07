/**
 * Created by S N Rao on 4/7/2017.
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 */
public class RemoveDuplicatesFromSortedListLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp=head.next,prev=head;
        while(temp!=null){
            if(temp.val!=prev.val)
                prev=temp;
            else
                prev.next=temp.next;
            temp=temp.next;
        }
        return head;
    }

    public static void main(String args[]){
        ListNode first=new ListNode(7);
        first.next=new ListNode(2);
        first.next.next=new ListNode(2);
        first.next.next.next=new ListNode(2);

        first=deleteDuplicates(first);
        while(first!=null){
            System.out.print(first.val+" ");
            first=first.next;
        }
    }

}
