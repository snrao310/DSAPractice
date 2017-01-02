/**
 * Created by snrao on 1/2/17.
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 *
 */
public class RemoveDuplicatesFromSortedListIILeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode last=null,prev=head,curr=head.next;
        while(curr!=null){
            if(prev.val==curr.val){
                curr=curr.next;
            }
            else{
                if(prev.next!=curr) {
                    if (last != null)
                        last.next = curr;
                    else
                        head=curr;
                }
                else
                    last=prev;
                prev=curr;
                curr=curr.next;
            }
        }
        if(prev.next!=null) {
            if(last==null) return null;
            last.next = null;
        }
        return head;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(2);
        one.next=new ListNode(3);
        one.next.next=new ListNode(5);
        one.next.next.next=new ListNode(5);
        one.next.next.next.next=new ListNode(7);
        one.next.next.next.next.next=new ListNode(7);

        one=deleteDuplicates(one);
        while (one!=null){
            System.out.print(one.val+" ");
            one=one.next;
        }
    }
}
