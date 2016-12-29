/**
 * Created by snrao on 12/28/16.
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater
 * than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartitionListLeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }


    public static ListNode partition(ListNode head, int x) {
        ListNode nextBeg=head;
        ListNode prevEnd=null;
        while (nextBeg!=null && nextBeg.val<x){
            prevEnd=nextBeg;
            nextBeg=nextBeg.next;
        }
        if(nextBeg==null) return head;
        if(prevEnd!=null)
            prevEnd.next=null;
        ListNode check=null;
        ListNode prev=null;
        if(prevEnd!=null)
            check=head;
        while (check!=null){
            if(check.val>=x){
                if(prev!=null){
                    prev.next=check.next;
                    check.next=nextBeg;
                    nextBeg=check;
                    check=prev.next;
                }
                else{
                    head=check.next;
                    check.next=nextBeg;
                    nextBeg=check;
                    check=head;
                }
            }
            else {
                prev = check;
                check=check.next;
            }
        }
        check=nextBeg;
        prev=null;
        while (check!=null){
            if(check.val<x){
                if(prev!=null){
                    prev.next=check.next;
                    check.next=null;
                    if(prevEnd!=null)
                        prevEnd.next=check;
                    else
                        head=check;
                    prevEnd=check;
                    check=prev.next;
                }
                else{
                    head=check.next;
                    check.next=nextBeg;
                    nextBeg=check;
                    check=head;
                }
            }
            else {
                prev=check;
                check=check.next;
            }
        }
        if(prevEnd!=null)
            prevEnd.next=nextBeg;
        return head;
    }

    public static void main(String args[]){
//        ListNode one=new ListNode(2);
//        one.next=new ListNode(3);
//        one.next.next=new ListNode(8);
//        one.next.next.next=new ListNode(6);
//        one.next.next.next.next=new ListNode(1);
//        one.next.next.next.next.next=new ListNode(4);
        ListNode one=new ListNode(1);
        one.next=new ListNode(3);
        one.next.next=new ListNode(2);
        one=partition(one,3);
        while (one!=null){
            System.out.print(one.val);
            one=one.next;
        }
    }
}
