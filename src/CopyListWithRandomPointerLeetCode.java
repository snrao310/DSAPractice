import java.util.HashMap;

/**
 * Created by S N Rao on 1/27/2017.
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in
 * the list or null.
 *
 * Return a deep copy of the list.
 *
 */
public class CopyListWithRandomPointerLeetCode {

    public static class RandomListNode{
        int label;
        RandomListNode next,random;
        RandomListNode(int label){this.label=label;}
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        HashMap<RandomListNode,RandomListNode> map=new HashMap<>();
        RandomListNode newHead=new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode temp=head.next,temp2=newHead;
        while(temp!=null){
            temp2.next=new RandomListNode(temp.label);
            temp2=temp2.next;
            map.put(temp, temp2);
            temp=temp.next;
        }
        temp=head; temp2=newHead;
        while(temp!=null){
            if(temp.random!=null)
                temp2.random=map.get(temp.random);
            else
                temp2.random=null;
            temp=temp.next;
            temp2=temp2.next;
        }
        return newHead;
    }

    public static void main(String args[]){
        RandomListNode head=new RandomListNode(1);
        head.next=new RandomListNode(2);
        head.next.next=new RandomListNode(3);
        head.random=head.next.next;
        head.next.next.random=head.next;
        head=copyRandomList(head);
        RandomListNode temp=head;
        while(temp!=null){
            System.out.print(temp.label+" ");
            temp=temp.next;
        }
        System.out.println();
        while(head!=null){
            System.out.print(head.label+" ");
            head=head.random;
        }
    }
}
