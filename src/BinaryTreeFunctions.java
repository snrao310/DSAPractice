import java.util.EmptyStackException;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * Created by snrao on 10/8/16.
 */
public class BinaryTreeFunctions {

    public static class BinaryTreeNode{
        public int data;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int data){
            this.data=data;
        }
    }

    public static class Stack{
        public BinaryTreeNode stack[]=new BinaryTreeNode[20];
        public int top=0;
        public int size=0;


        public void push(BinaryTreeNode node) throws ArrayIndexOutOfBoundsException{
            if(size==20){
                throw new ArrayIndexOutOfBoundsException();
            }
            size++;
            stack[top+1]=node;
            top++;
        }

        public BinaryTreeNode pop() throws EmptyStackException{
            if(size==0){
                throw new EmptyStackException();
            }
            size--;
            BinaryTreeNode node=stack[top];
            top--;
            return node;
        }

        public BinaryTreeNode peek(){
            return stack[top];
        }

        public int getSize(){
            return size;
        }

        public boolean isEmpty(){
            return (size==0);
        }
    }



    public static class Queue{
        public static class QueueNode{
            public BinaryTreeNode data;
            public QueueNode next;
        }

        public QueueNode front=null;
        public QueueNode rear=null;
        public int size=0;

        public void enqueue(BinaryTreeNode node){
            QueueNode newNode=new QueueNode();
            newNode.data=node;
            if(rear!=null) {
                rear.next = newNode;
            }
            rear=newNode;
            if(front==null){
                front=newNode;
            }
            size++;
        }

        public BinaryTreeNode dequeue() throws EmptyStackException{
            if(size==0){
                throw new EmptyStackException();
            }
            size--;
            BinaryTreeNode node=front.data;
            front=front.next;
            if(front==null){
                rear=null;
            }
            return node;
        }

        public BinaryTreeNode peek(){
            return front.data;
        }

        public int getSize(){
            return size;
        }

        public boolean isEmpty(){
            return (size==0);
        }
    }

    public static BinaryTreeNode createTree(){
        BinaryTreeNode root=new BinaryTreeNode(1);
        BinaryTreeNode two= new BinaryTreeNode(20);
        BinaryTreeNode three=new BinaryTreeNode(30);
        BinaryTreeNode four=new BinaryTreeNode(4);
        BinaryTreeNode five= new BinaryTreeNode(5);
        BinaryTreeNode six= new BinaryTreeNode(6);
        BinaryTreeNode seven= new BinaryTreeNode(7);
        BinaryTreeNode eight= new BinaryTreeNode(8);
        BinaryTreeNode nine= new BinaryTreeNode(9);
        root.left=two; two.left=three; three.left=five; two.right=four; root.right=six; six.left=seven; seven.right=nine; six.right=eight;
        return root;
    }


    public static int findMaxValue(BinaryTreeNode node){
        if(node==null){
            return 0;
        }
        int max=Math.max(findMaxValue(node.left),findMaxValue(node.right));
        return Math.max(node.data,max);
    }

    public static boolean search(BinaryTreeNode node, int value){
        if(node==null){
            return false;
        }
        return (search(node.left,value) || search(node.right,value) || (node.data==value));
    }


    public static BinaryTreeNode insert(BinaryTreeNode root, int data){
        if(root==null)
            root=new BinaryTreeNode(data);
        else{
            insertHelper(root, data);
        }
        return root;
    }

    public static void insertHelper(BinaryTreeNode node, int data){
        if(node.data>data){
            if(node.left!=null)
                insertHelper(node.left,data);
            else
                node.left=new BinaryTreeNode(data);
        }
        else{
            if(node.right!=null)
                insertHelper(node.right,data);
            else
                node.right=new BinaryTreeNode(data);
        }
    }


    public static int size(BinaryTreeNode node){
        if(node==null)
            return 0;
        return size(node.left)+size(node.right)+1;
    }


    public static int findHeightWithStack(BinaryTreeNode node){
        int maxHeight=0;
        Stack stack=new Stack();
        stack.push(node);
        BinaryTreeNode prev=null;

        while(!stack.isEmpty()){
            BinaryTreeNode curr=stack.peek();
            if(prev==null || prev.left==curr || prev.right==curr){
                if(curr.left!=null)
                    stack.push(curr.left);
                else if(curr.right!=null)
                    stack.push(curr.right);
            }

            else if(curr.left==prev){
                if(curr.right!=null)
                    stack.push(curr.right);
            }

            else{
                stack.pop();
            }

            prev=curr;
            if(stack.getSize()>maxHeight){
                maxHeight=stack.getSize();
            }
        }

        return maxHeight;
    }


    public static int findHeightWithQueue(BinaryTreeNode node){
        int height=1;
        Queue queue=new Queue();
        queue.enqueue(node);
        queue.enqueue(null);

        while(!queue.isEmpty()){
            BinaryTreeNode currNode=queue.dequeue();
            if(currNode!=null) {
                if (currNode.left != null) {
                    queue.enqueue(currNode.left);
                }
                if (currNode.right != null) {
                    queue.enqueue(currNode.right);
                }
            }
            else{
                if(!queue.isEmpty()) {
                    queue.enqueue(null);
                    height++;
                }
            }
        }
        return height;
    }

    public static BinaryTreeNode findNode(BinaryTreeNode node, int element){
        if(node==null)
            return null;
        BinaryTreeNode found;
        if(node.data==element)
            return node;
        found=findNode(node.left,element);
        if(found!=null)
            return found;
        found=findNode(node.right,element);
        if(found!=null)
            return found;
        return null;
    }

    public static void deleteElement(BinaryTreeNode node, int element){
        Queue queue=new Queue();
        queue.enqueue(node);
        BinaryTreeNode theNode;
        BinaryTreeNode leafNode;
        BinaryTreeNode parentNode;

        theNode=findNode(node, element);
        if(theNode==null)
            return;

        leafNode=node;
        parentNode=leafNode;
        while(true){
            if(leafNode.left==null && leafNode.right==null)
                break;
            else if(leafNode.left!=null) {
                parentNode = leafNode;
                leafNode = leafNode.left;
            }
            else {
                parentNode = leafNode;
                leafNode = leafNode.right;
            }
        }

        theNode.data=leafNode.data;
        if(parentNode.left==leafNode)
            parentNode.left=null;
        else if(parentNode.right==leafNode)
            parentNode.right=null;
    }



    public static void main(String args[]){
        BinaryTreeNode root=createTree();
        int max=findMaxValue(root);
        System.out.println("Max value in tree: "+max);

        root=insert(root,501);
        BinaryTreeNode nd=root.left;
        nd=null;

        int find=50;
        boolean exists=search(root, find);
        if(exists)
            System.out.println(find+" Found");
        else
            System.out.println(find+" Not Found");

        System.out.println("Size of tree: "+size(root));

        System.out.println("Height of tree with Stack method: "+findHeightWithStack(root));
        System.out.println("Height of tree with Queue method: "+findHeightWithQueue(root));

        int delete=501;
        System.out.println("Size before delte: "+size(root)+", "+delete+" Found? "+search(root,delete));
        deleteElement(root,delete);
        System.out.println("Size after delte: "+size(root)+", "+delete+" Found? "+search(root,delete));

    }
}
