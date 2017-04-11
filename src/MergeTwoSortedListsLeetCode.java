import java.util.List;

/**
 * Created by S N Rao on 4/10/2017.
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the
 * nodes of the first two lists.
 *
 */
public class MergeTwoSortedListsLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val=val;}
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headPrev=new ListNode(-1);
        ListNode t1=l1, t2=l2, t3=headPrev;
        while(t1!=null || t2!=null){
            if(t1==null) {t3.next=t2; break;}
            else if(t2==null) {t3.next=t1; break;}
            else if(t1.val<t2.val) {t3.next=t1; t3=t1; t1=t1.next;}
            else{t3.next=t2; t3=t2; t2=t2.next;}
        }
        return headPrev.next;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(1);
        one.next=new ListNode(3);
        one.next.next=new ListNode(6);
        ListNode two=new ListNode(2);
        two.next=new ListNode(4);
        ListNode three=mergeTwoLists(one, two);
        while (three!=null){
            System.out.print(three.val+" ");
            three=three.next;
        }
    }
}
