import java.util.Scanner;

/**
 * Created by snrao on 9/17/16.
 */
public class DeleteNthNodeFromEnd {
    private static class ListNode{
        public int data;
        public ListNode next;
    }

    public static ListNode insert(ListNode head, int[] input ){
        int length=input.length;
        head=new ListNode();
        ListNode node1=null;
        ListNode node2;
        for(int i=0;i<length;i++){
            if(i==0){
                head.data=input[i];
                head.next=null;
                node1=head;
            }
            else{
                node2=new ListNode();
                node2.data=input[i];
                node2.next=null;
                node1.next=node2;
                node1=node2;
            }
        }
        return head;
    }


    public static int getNthNodeFromEnd(int n, ListNode head){
        ListNode currNode=head;
        ListNode behind=head;

        for(int i=0;i<n;i++){
            currNode=currNode.next;
        }

        while (currNode.next!=null){
            currNode=currNode.next;
            behind=behind.next;
        }

        return behind.data;
    }



    public static void main(String args[]){

        ListNode head=null;
        int input[]={0,1,2,3,4,5,6};
        int n=2;
        head=insert(head, input);

        System.out.println(getNthNodeFromEnd(n, head));

    }
}
