import java.util.List;

/**
 * Created by S N Rao on 2/3/2017.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes
 * first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 */
public class AddTwoNumbersIILeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first,second, result,t0,t3,t1=l1,t2=l2;
        int len1=0,len2=0,len3=0,count;
        while(t1!=null){t1=t1.next;len1++;}
        while(t2!=null){t2=t2.next;len2++;}
        if(len1>len2) {first=l1; second=l2;}
        else {first=l2;second=l1;}
        len3=Math.abs(len1-len2);
        count=0;
        result=null;
        while(first!=null){
            t0=new ListNode(first.val);
            t0.next=result;
            result=t0;
            first=first.next;
            if(count>=len3){
                t0.val+=second.val;
                second=second.next;
            }
            count++;
        }
        t1=result; t2=t1.next; t3=(t2!=null)?t2.next:null;
        t1.next=null;
        while(t2!=null){
            t2.next=t1;
            if(t1.val>9){
                t1.val%=10;
                t2.val++;
            }
            t1=t2; t2=t3; t3=(t2!=null)?t2.next:null;
        }
        if(t1.val>9){
            t1.val%=10;
            t0=new ListNode(1);
            t0.next=t1;
            t1=t0;
        }
        return t1;
    }

    public static void main(String args[]){
        ListNode first=new ListNode(7);
        first.next=new ListNode(2);
        first.next.next=new ListNode(4);
        first.next.next.next=new ListNode(3);
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
