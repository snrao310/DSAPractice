package Done;

/**
 * Created by snrao on 12/10/16.
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we
 * are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */
public class OddEvenLinkedListLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){this.val=val;}
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode k=head;
        if(k==null || k.next==null)
            return head;
        ListNode l=k.next;

        while(l!=null && l.next!=null){
            ListNode i=k.next;
            ListNode j=l.next;
            l.next=j.next;
            k.next=j;
            j.next=i;

            k=k.next;
            l=l.next;
        }
        return head;
    }

    public static void main(String args[]){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        ListNode it=head;
        while(it!=null){
            System.out.print(it.val+" ");
            it=it.next;
        }
        System.out.println();

        oddEvenList(head);

        it=head;
        while(it!=null){
            System.out.print(it.val+" ");
            it=it.next;
        }
    }

}
