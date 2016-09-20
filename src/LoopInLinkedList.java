/**
 * Created by snrao on 9/17/16.
 */
public class LoopInLinkedList {
    public static class ListNode{
        public int data;
        public ListNode next;
    }

    public static ListNode insert(ListNode head, int[] input,int loopNode){
        ListNode node1=null;
        ListNode node2=null;
        ListNode loopListNode=null;
        for(int i=0;i<input.length;i++){
            if(i==0){
                head=new ListNode();
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

            if(i==loopNode){
                loopListNode=node1;
            }
        }

//        node1.next=loopListNode;
        return head;
    }

    public static boolean findLoop(ListNode head){
        ListNode fast=head.next;
        if(fast!=null){
            fast=fast.next;
        }
        ListNode slow=head.next;

        while(fast!=slow && fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }
            slow=slow.next;
        }

        return (fast==slow);
    }


    public static void main(String[] args){
        ListNode head=null;
        int input[]={1,2,3,4,6,7,8,8,8,8,4};

        head=insert(head, input, 5);

        if(findLoop(head)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
