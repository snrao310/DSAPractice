package Done;

/**
 * Created by snrao on 12/28/16.
 *
 * Sort a linked list using insertion sort.
 *
 */
public class InsertionSortListLeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode curr=head;
        ListNode next=null;
        ListNode prev=null;
        while (curr!=null){
            next=curr.next;
            ListNode node=head;
            ListNode prev2=null;
            while (node!=curr && node.val<curr.val){
                prev2=node;
                node=node.next;
            }
            if(node!=curr){
                curr.next=node;
                if(prev!=null)
                    prev.next=next;
                if(prev2!=null)
                    prev2.next=curr;
                else
                    head=curr;
                curr=prev;
            }
            prev=curr;
            curr=next;
        }
        return head;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(2);
        one.next=new ListNode(3);
        one.next.next=new ListNode(8);
        one.next.next.next=new ListNode(6);
        one.next.next.next.next=new ListNode(1);
        one.next.next.next.next.next=new ListNode(4);
        one=insertionSortList(one);
        while (one!=null){
            System.out.print(one.val);
            one=one.next;
        }
    }
}
