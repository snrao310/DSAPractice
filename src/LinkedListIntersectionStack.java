/**
 * Created by snrao on 9/17/16.
 */
public class LinkedListIntersectionStack {

    private static class Stack{
        private static class StackNode{
            public int data;
            public StackNode next;
        }

        public StackNode top;

        public void Stack(){
            top=null;
            top.next=null;
        }

        public void push(int data){
            StackNode node=new StackNode();
            node.data=data;
            node.next=top;
            top=node;
        }

        public int pop(){
            if(top==null){
                return -1;
            }

            int returnData=top.data;
            top=top.next;
            return returnData;
        }

        public boolean isEmpty(){
            return (top==null);
        }

        public int peek(){
            if(top==null){
                return -1;
            }
            return top.data;
        }
    }

    public static class ListNode{
        public int data;
        public ListNode next;
    }


    public static ListNode insert(ListNode head1, int[] input1){
        ListNode node1=null;
        ListNode node2=null;
        ListNode connection=null;

        for(int i=0;i<input1.length;i++){
            if(i==0){
                head1=new ListNode();
                head1.next=null;
                head1.data=input1[i];
                node1=head1;
            }
            else{
                node2=new ListNode();
                node2.data=input1[i];
                node2.next=null;
                node1.next=node2;
                node1=node2;
            }
        }


        return head1;
    }


    public static ListNode insertToSecond(ListNode head1, ListNode head2, int[] input2, int place){
        ListNode node1=null;
        ListNode node2=null;
        ListNode connection=head1;

        for(int i=0;i<place;i++){
            connection=connection.next;
        }

        for(int i=0;i<input2.length;i++){
            if(i==0){
                head2=new ListNode();
                head2.next=null;
                head2.data=input2[i];
                node1=head2;
            }
            else{
                node2=new ListNode();
                node2.data=input2[i];
                node2.next=null;
                node1.next=node2;
                node1=node2;
            }
        }

        node1.next=connection;
        return head2;
    }

    public static void findConnectingPoint(ListNode head1, ListNode head2){
        Stack stack1=new Stack();
        Stack stack2=new Stack();

        ListNode node=head1;
        while(node!=null){
            stack1.push(node.data);
            node=node.next;
        }

        node=head2;
        while (node!=null){
            stack2.push(node.data);
            node=node.next;
        }

        int dataAtConnection=-1;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            int i=stack1.pop();
            int j=stack2.pop();

            if(i==j){
                dataAtConnection=i;
            }
            else{
                System.out.println(dataAtConnection);
                break;
            }

        }
    }


    public static void main(String args[]){
        int input1[]={2,3,4,5,6,7,6};
        int input2[]={4,5,2,1};

        ListNode head1=null;
        ListNode head2=null;

        head1=insert(head1,input1);
        head2=insertToSecond(head1, head2, input2, 1);

        findConnectingPoint(head1, head2);
    }

}
