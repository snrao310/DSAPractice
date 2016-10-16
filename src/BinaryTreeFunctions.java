import sun.net.www.http.PosterOutputStream;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.InputMismatchException;
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
        public BinaryTreeNode nextSibling; //not required in all binary trees. Just for the sake of last question.

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
        BinaryTreeNode two= new BinaryTreeNode(2);
        BinaryTreeNode three=new BinaryTreeNode(3);
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

    public static void deleteElement(BinaryTreeNode node, int element){     //finding any leaf node and
        Queue queue=new Queue();                                           // replacing with element and
        queue.enqueue(node);                                               // deleting leaf node.
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

    public static void printAllRootToLeafPaths(BinaryTreeNode node, String s){
        s+=" "+node.data;   //works because strings are immutable. Thus this creates a new string.
                            // Wouldn't have worked if we were passing the same object.
                            // Eg: Wont work with string builder.
        if(node.left==null && node.right==null)
            System.out.println(s);
        else{
            if(node.left!=null)
                printAllRootToLeafPaths(node.left, s);
            if(node.right!=null)
                printAllRootToLeafPaths(node.right,s);
        }
    }

    public static BinaryTreeNode treeFromInOrderandPostOrder(int[] inOrder, int inStart, int inEnd,
                                                             int[] postOrder, int postStart, int postEnd){

        if(inStart==inEnd){
            if(postStart==postEnd && postOrder[postStart]==inOrder[inStart]){
                BinaryTreeNode node=new BinaryTreeNode(inOrder[inStart]);
                return node;
            }
            else{
                throw new InputMismatchException();
            }
        }

        BinaryTreeNode root=new BinaryTreeNode(postOrder[postEnd]);
        int offset=0;
        for(int i=inStart;i<inEnd;i++){
            if(inOrder[i]==root.data)
                break;
            else
                offset++;
        }
        root.left=treeFromInOrderandPostOrder(inOrder,inStart,inStart+offset-1,postOrder,postStart,postStart+offset-1);
        root.right=treeFromInOrderandPostOrder(inOrder,inStart+offset+1,inEnd,postOrder,postStart+offset,postEnd-1);

        return root;
    }

    public static void inOrderTraverse(BinaryTreeNode node){
        if(node==null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.data+" ");
        inOrderTraverse(node.right);
    }


    public static void postOrderTraverse(BinaryTreeNode node){
        if(node==null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data+" ");
    }

    public static int LCA(BinaryTreeNode node, int a ,int b){
        if(node==null)
            return -1;
        if(node.data==a || node.data==b)
            return node.data;

        int left=LCA(node.left,a,b);
        int right=LCA(node.right,a,b);
        if(left==-1 && right==-1)       //can actually skip this since last line will take care of this.
            return -1;                  //But just for better understanding, lets keep it.
        if(left!=-1 && right!=-1)
            return node.data;
        else{
            return (left!=-1)? left: right;
        }
    }


    public static void zigzagTraverse(BinaryTreeNode node){
        Queue queue=new Queue();
        Stack stack=new Stack();
        queue.enqueue(node);
        queue.enqueue(null);

        boolean leftToRight=true;
        while(!queue.isEmpty()){
            BinaryTreeNode curr=queue.dequeue();
            if(curr!=null){
                if(!leftToRight)
                    stack.push(curr);
                else
                    System.out.print(curr.data+" ");

                if(curr.left!=null)
                    queue.enqueue(curr.left);
                if(curr.right!=null)
                    queue.enqueue(curr.right);
            }
            else{
                if(!leftToRight){
                    while(!stack.isEmpty()){
                        System.out.print(stack.pop().data+" ");
                    }
                }
                if(!queue.isEmpty()) {
                    leftToRight = !leftToRight;
                    queue.enqueue(null);
                }
            }
        }
    }


    public static void getVSums(HashMap<Integer,Integer> map, BinaryTreeNode node, int column){
        if(node==null)
            return;

        if(map.containsKey(column))
            map.replace(column,map.get(column)+node.data);
        else
            map.put(column,node.data);

        getVSums(map,node.left,column-1);
        getVSums(map,node.right,column+1);
        return;
    }



    public static void verticalSums(BinaryTreeNode node){
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        getVSums(map,node,0);

        for(int k: map.keySet()){
            System.out.print("Column "+k+": "+map.get(k)+" ");
        }
    }


    public static void connectSiblings(BinaryTreeNode node){
        if(node==null)
            return;

        if(node.left!=null)
            node.left.nextSibling=node.right;

        if(node.right!=null)
            if(node.nextSibling!=null)
                node.right.nextSibling=node.nextSibling.left;
            else
                node.right.nextSibling=null;

        connectSiblings(node.left);
        connectSiblings(node.right);
    }


    public static void main(String args[]){
        //create dummy tree
        BinaryTreeNode root=createTree();

        //find max element in tree
        int max=findMaxValue(root);
        System.out.println("Max value in tree: "+max);

        //insert into tree
        root=insert(root,501);

        //search for node. see if exists or not.
        int find=50;
        boolean exists=search(root, find);
        if(exists)
            System.out.println(find+" Found");
        else
            System.out.println(find+" Not Found");

        //find size of tree (number of nodes)
        System.out.println("Size of tree: "+size(root));

        //find height using stack and queue. can also do with recursion.
        System.out.println("Height of tree with Stack method: "+findHeightWithStack(root));
        System.out.println("Height of tree with Queue method: "+findHeightWithQueue(root));

        //deleting an element
        int delete=501;
        System.out.println("Size before delete: "+size(root)+", "+delete+" Found? "+search(root,delete));
        deleteElement(root,delete);
        System.out.println("Size after delete: "+size(root)+", "+delete+" Found? "+search(root,delete));

        //print all root-to-leaf paths in the tree.
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("All Root to Leaf Paths:");
        printAllRootToLeafPaths(root,"");

        //build a tree from inOrder and postOrder traversal.
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Building a tree");
        int inOrder[]={4,2,5,1,6,3,7};
        int postOrder[]={4,5,2,6,7,3,1};
        BinaryTreeNode newTree=treeFromInOrderandPostOrder(inOrder,0,inOrder.length-1,postOrder,0,postOrder.length-1);
        inOrderTraverse(newTree);
        System.out.println();
        postOrderTraverse(newTree);


        //print least common ancestor of two nodes
        System.out.println();
        System.out.println();
        System.out.println();
        int a=9;
        int b=4;
        System.out.println("Least common ancestor of "+a+" and "+b+" is "+LCA(root,a,b));


        //print zigzag traversal of a tree
        System.out.println();
        System.out.println();
        System.out.println("Zigzag traversal:");
        zigzagTraverse(root);

        //print vertical sum of nodes in a tree
        System.out.println();
        System.out.println();
        System.out.println("Vertical Sums:");
        verticalSums(root);

        //connect siblings from left to right
        connectSiblings(root); //this method works only on a complete (balanced binary tree).
                                //for a generic binary tree, use level order traversal.
    }
}
