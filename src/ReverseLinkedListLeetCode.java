import java.util.List;

/**
 * Created by S N Rao on 3/29/2017.
 *
 * Reverse a singly linked list.
 *
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 */
public class ReverseLinkedListLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){val=x;}
    }

    public static ListNode reverseListIterative(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp1=head, temp2=head.next; temp1.next=null;
        while(temp2!=null){
            ListNode temp3=temp2.next;
            temp2.next=temp1;
            temp1=temp2;
            temp2=temp3;
        }
        return temp1;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseListRecursive(nextNode);
        nextNode.next=head; head.next=null;
        return newHead;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(1); one.next=new ListNode(2); one.next.next=new ListNode(3);
        one=reverseListIterative(one);

        ListNode temp=one;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();

        one=reverseListRecursive(one);
        temp=one;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
}
