import java.util.List;

/**
 * Created by S N Rao on 1/13/2017.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 */
public class AddTwoNumbersLeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode(-1);
        ListNode temp=l3;
        int carry=0;
        while(l1!=null || l2!=null){
            int one=(l1==null)?0:l1.val;
            if(l1!=null) l1=l1.next;
            int two=(l2==null)?0:l2.val;
            if(l2!=null) l2=l2.next;
            int val=one+two+carry;
            carry=0;
            if(val>9){
                val%=10;
                carry=1;
            }
            temp.next=new ListNode(val);
            temp=temp.next;
        }
        if(carry==1)
            temp.next=new ListNode(1);
        return l3.next;
    }

    public static void main(String args[]){
        ListNode first=new ListNode(1);
        first.next=new ListNode(4);
        first.next.next=new ListNode(9);
        ListNode second=new ListNode(5);
        second.next=new ListNode(6);
        second.next.next=new ListNode(4);
        first=addTwoNumbers(first,second);
        while(first!=null){
            System.out.print(first.val+" ");
            first=first.next;
        }
    }
}
