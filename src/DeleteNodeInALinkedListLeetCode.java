/**
 * Created by S N Rao on 3/23/2017.
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should
 * become 1 -> 2 -> 4 after calling your function.
 *
 */
public class DeleteNodeInALinkedListLeetCode {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public static void deleteNode(ListNode node) {
        ListNode temp=node;
        while(temp.next.next!=null){
            temp.val=temp.next.val;
            temp=temp.next;
        }
        temp.val=temp.next.val;
        temp.next=null;
    }

    public static void main(String args[]){
        ListNode node=new ListNode(1);
        node.next=new ListNode(2); node.next.next=new ListNode(3); node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        deleteNode(node.next.next);
        while(node!=null) {
            System.out.print(node.val + " ");
            node=node.next;
        }
    }
}
