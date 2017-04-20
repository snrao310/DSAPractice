/**
 * Created by S N Rao on 4/20/2017.
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 */
public class PalindromeLinkedListLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val=val;}
    }

    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow=head, fast=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast!=null) fast=fast.next;
        }
        ListNode temp1=slow, temp2=slow.next, temp3=(temp2!=null)?temp2.next:null;
        while(temp2!=null){
            temp2.next=temp1;
            temp1=temp2; temp2=temp3; temp3=(temp2!=null)?temp2.next:null;
        }
        ListNode forward=head, backward=temp1;
        while(backward!=slow){
            if(forward.val!=backward.val) return false;
            forward=forward.next;
            backward=backward.next;
        }
        if(backward.val==forward.val) return true;
        else return false;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(1); one.next=new ListNode(6); one.next.next=new ListNode(6); one.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(one)); //true
    }
}
