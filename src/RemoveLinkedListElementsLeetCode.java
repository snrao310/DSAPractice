import java.util.List;

/**
 * Created by S N Rao on 4/20/2017.
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 */
public class RemoveLinkedListElementsLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val=val;}
    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode headPrev=new ListNode(-1);
        headPrev.next=head;
        ListNode temp1=headPrev, temp2=head, temp3=head.next;
        while(temp2!=null){
            if(temp2.val==val)
                temp1.next=temp3;
            else
                temp1=temp1.next;
            temp2=temp2.next;
            temp3=(temp2==null)?null:temp2.next;
        }
        return headPrev.next;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(1); one.next=new ListNode(6); one.next.next=new ListNode(5); one.next.next.next=new ListNode(6);
        removeElements(one,6);
        while (one!=null){
            System.out.print(one.val+" ");
            one=one.next;
        }
    }
}
