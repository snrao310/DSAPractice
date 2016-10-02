import java.util.EmptyStackException;

/**
 * Created by snrao on 10/1/16.
 */
public class BinaryTreeTraversals {

    public static class BinaryTreeNode{
        public int data;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    public static class Stack<T>{
        public static class StackNode<T>{
            T data;
            StackNode<T> next;
        }

        public StackNode<T> top;
        public int size;

        public Stack(){
            size=0;
        }

        public void push(T node){
            StackNode<T> snode=new StackNode<T>();
            snode.data=node;
            snode.next=top;
            top=snode;
            size++;
        }

        public T pop() throws EmptyStackException{
            if(top==null){
                throw new EmptyStackException();
            }

            T popped=top.data;
            top=top.next;
            size--;
            return popped;
        }

        public T peek() throws EmptyStackException{
            if(top==null){
                throw new EmptyStackException();
            }

            return top.data;
        }

        public int getSize(){
            return size;
        }

        public boolean isEmpty(){
            return (top==null);
        }

    }



    public static class Queue<T>{
        public static class QueueNode<T>{
            public T data;
            public QueueNode<T> next;
        }

        public QueueNode<T> front;
        public QueueNode<T> rear;
        public int size;

        public Queue(){
            size=0;
        }

        public void enqueue(T node){
            QueueNode<T> newNode=new QueueNode<T>();
            newNode.data=node;
            size++;

            if(rear!=null) {
                rear.next = newNode;
            }
            rear=newNode;
            if(front==null){
                front=newNode;
            }
        }

        public T dequeue() throws EmptyStackException{
            if(front==null){
                throw new EmptyStackException();
            }
            T data=front.data;
            front=front.next;
            size--;

            if(front==null)
                rear=null;

            return data;
        }

        public T peek() throws EmptyStackException{
            if(front==null){
                throw new EmptyStackException();
            }

            return front.data;
        }

        public int getSize(){
            return size;
        }

        public boolean isEmpty(){
            return (front==null);
        }
    }


    public static class QueueArray<T>{
        int MAX_CAPACITY=20;
        public T queue[]=(T[])new Object[MAX_CAPACITY];     //Awesome way to make generic arrays.
        public int front;
        public int rear;
        public int size;

        public QueueArray(){
            size=0;
            front=0;
            rear=0;
        }

        public void enqueue(T data) throws ArrayIndexOutOfBoundsException{
            if(size==MAX_CAPACITY)
                throw new ArrayIndexOutOfBoundsException();

            size++;
            queue[rear]=data;
            rear=(rear+1)%MAX_CAPACITY;
        }

        public T dequeue() throws EmptyStackException{
            if(size==0){
                throw new EmptyStackException();
            }
            size--;
            T data=queue[front];
            front=(front+1)%MAX_CAPACITY;
            return data;
        }

        public T peek() throws EmptyStackException{
            if(size==0){
                throw new EmptyStackException();
            }
            return queue[front];
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
        BinaryTreeNode two=new BinaryTreeNode(2);
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


    public static void preOrderTraverse(BinaryTreeNode node){
        System.out.print(node.data + " ");
        if(node.left!=null)
            preOrderTraverse(node.left);
        if(node.right!=null)
            preOrderTraverse(node.right);
    }

    public static void inOrderTraverse(BinaryTreeNode node){
        if(node.left!=null)
            inOrderTraverse(node.left);
        System.out.print(node.data + " ");
        if(node.right!=null)
            inOrderTraverse(node.right);
    }

    public static void postOrderTraverse(BinaryTreeNode node){
        if(node.left!=null)
            postOrderTraverse(node.left);
        if(node.right!=null)
            postOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }

    public static void preOrderTraverseIterative(BinaryTreeNode node){
        System.out.print("preOrderTraverseIterative:\t");
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        stack.push(node);
        while(!stack.isEmpty()){
            BinaryTreeNode curr=stack.pop();
            System.out.print(curr.data+" ");
            if(curr.right!=null){
                stack.push(curr.right);
            }
            if(curr.left!=null){
                stack.push(curr.left);
            }
        }
        System.out.println();
    }


    public static void inOrderTraverseIterative(BinaryTreeNode node){
        System.out.print("inOrderTraverseIterative:\t");
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        stack.push(node);
        BinaryTreeNode curr=node;

        while(!stack.isEmpty()){
            if(curr!=null && curr.left!=null){  //first push all the nodes on the left going downwards.
                stack.push(curr.left);
                curr=curr.left;
            }
            else{                               // then pop, print and push nodes on the right. Make sure same node
                curr=stack.pop();                // doesn't go through the if statement again. else its left children will be pushed again.
                System.out.print(curr.data+" ");
                curr=curr.right;
                if(curr!=null){
                    stack.push(curr);
                }
            }
        }
        System.out.println();
    }


    public static void postOrderTraverseIterative(BinaryTreeNode node){
        System.out.print("postOrderTraverseIterative:\t");
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        stack.push(node);
        BinaryTreeNode prev=null;

        while(!stack.isEmpty()){
            BinaryTreeNode curr=stack.peek();
            if(prev==null || curr==prev.right || curr==prev.left){  //moving down in the tree pushing nodes
                if(curr.left!=null){                //if there are left nodes we will push them only. No right nodes
                    stack.push(curr.left);          // Right nodes checked while coming back up.
                }
                else if(curr.right!=null){          //if no left nodes, then push right nodes, because then we won't go down and
                    stack.push(curr.right);         //come back up. So won't be checked while coming back up. So we push them now itself.
                }
            }
            else if(curr.left==prev){          //moving back upwards in the tree and exploring if any of them had right nodes.
                if(curr.right!=null){
                    stack.push(curr.right);
                }
            }
            else{                               //when prev==curr (no left or right nodes) or when both left and right nodes are explored.
                stack.pop();
                System.out.print(curr.data+" ");
            }
            prev=curr;
        }
        System.out.println();
    }


    public static void levelOrderTraverseIterative(BinaryTreeNode node){
        System.out.print("\nlevelOrderTraverse:\t");
//        Queue<BinaryTreeNode> queue=new Queue<BinaryTreeNode>();
        QueueArray<BinaryTreeNode> queue=new QueueArray<BinaryTreeNode>();
        queue.enqueue(node);

        while (!queue.isEmpty()){
            BinaryTreeNode curr=queue.dequeue();
            System.out.print(curr.data+" ");
            if(curr.left!=null){
                queue.enqueue(curr.left);
            }
            if(curr.right!=null){
                queue.enqueue(curr.right);
            }
        }

        System.out.println();
    }


    public static void main(String args[]){
        BinaryTreeNode root=createTree();

        System.out.print("preOrderTraverse:\t");
        preOrderTraverse(root);
        System.out.println();

        System.out.print("inOrderTraverse:\t");
        inOrderTraverse(root);
        System.out.println();

        System.out.print("postOrderTraverse:\t");
        postOrderTraverse(root);
        System.out.println();


        System.out.println();

        preOrderTraverseIterative(root);

        inOrderTraverseIterative(root);

        postOrderTraverseIterative(root);

        levelOrderTraverseIterative(root);
    }

}
