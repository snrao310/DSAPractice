/**
 * Created by S N Rao on 2/22/2017.
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 */
public class ReverseNodesInKGroupLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode head2=new ListNode(-1);
        head2.next=head;
        ListNode preva=head2, a=head, b=head;
        while(a!=null){
            int i=0;
            for(;i<k-1 && b.next!=null;i++)
                b=b.next;
            if(i!=k-1)
                return head2.next;

            ListNode nextStart=b.next;
            preva.next=b; preva=a;

            while(a!=b){
                ListNode anext=a.next;
                a.next=b.next;
                b.next=a;
                a=anext;
            }
            a=nextStart; b=nextStart;
        }
        return head2.next;
    }

    public static void main(String args[]){
        ListNode first=new ListNode(1);
        first.next=new ListNode(2);
        first.next.next=new ListNode(3);
        first.next.next.next=new ListNode(4);
        first.next.next.next.next=new ListNode(5);
        first=reverseKGroup(first,2);
        while(first!=null) {
            System.out.print(first.val + " ");
            first = first.next;
        }
    }
}
