/**
 * Created by snrao on 10/15/16.
 */
public class ConfusionTests {

/* CONFUSION WITH POINTERS*/

    public static class BinaryTreeNode {
        public int data;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

    public static BinaryTreeNode createTree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode two = new BinaryTreeNode(20);
        BinaryTreeNode three = new BinaryTreeNode(30);
        BinaryTreeNode four = new BinaryTreeNode(4);
        BinaryTreeNode five = new BinaryTreeNode(5);
        BinaryTreeNode six = new BinaryTreeNode(6);
        BinaryTreeNode seven = new BinaryTreeNode(7);
        BinaryTreeNode eight = new BinaryTreeNode(8);
        BinaryTreeNode nine = new BinaryTreeNode(9);
        root.left = two;
        two.left = three;
        three.left = five;
        two.right = four;
        root.right = six;
        six.left = seven;
        seven.right = nine;
        six.right = eight;
        return root;
    }


    public static void mainn(String[] args) {
        BinaryTreeNode root = createTree();
        System.out.println(root);
        delete(root);               //deleting root with void
        System.out.println(root);
        root = deleteProper(root);  //deleting root passing pointer.
        System.out.println(root);
    }

    public static void delete(BinaryTreeNode root) {
        root = null;
    }

    public static BinaryTreeNode deleteProper(BinaryTreeNode root) {
        root = null;
        return root;
    }

/* GENERAL RULE: IF YOU WILL CHANGE THE POINTER YOU ARE PASSING, INSIDE THE FUNCTION, THEN YOU NEED TO RETURN THE
* NEW POINTER BACK AND REPLACE THE OLD ONE IN CALLING FUNCTION. WITH LINKED LIST, IF YOU ADD ELEMENT TO BEGINNING
* AND UPDATE HEAD, YOU MUST RETURN HEAD. IF YOU CREATE NEW HEAD WHEN THERE WERE NO ELEMENTS IN THE LIST, YOU MUST
* RETURN HEAD. IN TREES, IF YOU ARE DELETING A TREE THEN YOU ASSIGN ROOT TO NULL IN A FUNCTION AND RETURN THE ROOT
* AND REPLACE IN THE CALLING FUNCTION.
*
* WHEN A POINTER IS PASSED TO A FUNCTION, A COPY OF THE POINTER IS PASSED, WHICH POINTS TO THE SAME LOCATION AS THE
* ORIGINAL POINTER. CHANGING THE DATA TO WHICH THE COPY POINTS TO, INSIDE THE FUNCTION WILL CHANGE THE DATA EVEN IN
* THE CALLING FUNCTION. HOWEVER, CHANGING THE POINTER INSIDE THE FUNCTION WILL MAKE IT POINT TO A DIFFERENT LOCATION
* BUT THE POINTER IN THE CALLING FUNCTION WILL STILL POINT TO THE SAME LOCATION. TILL IT IS REPLACED BY THE NEW
* POINTER THAT THE FUNCTION RETURNS.*/







/* CONFUSION WITH STRINGS IMMUTABILITY. Can be hadled using string builders.*/

    public static void main(String arg[]) {
        String str = "This";
        System.out.println(str);

        str += " is";
        System.out.println(str);

        changeString(str);
        System.out.println(str);
        System.out.println();

        StringBuilder strBld=new StringBuilder("This");
        System.out.println(strBld.toString());

        strBld.append(" is");
        System.out.println(strBld.toString());

        changeStringBuilder(strBld);
        System.out.println(strBld.toString());
    }

    public static void changeString(String str) {
        str += " string";    //This won't change the string. Its a new object. String is immutable.
    }

    public static void changeStringBuilder(StringBuilder strBld){
        strBld.append(" stringBuilder"); //This will change the string builder. Its the same object.
    }

    /* SO YOU NEED TO USE STRINGBUILDER IF YOU WANT TO CHANGE STRING INSIDE A FUNCTION. STRING IMMUTABILITY
     * IS ACTUALLY QUITE USEFUL IN FUNCTIONS, SINCE YOU DON'T NEED TO BE CAREFUL ABOUT CHANGING THE SAME
     * OBJECT. BUT ITS ALWAYS GOOD TO BE CAREFUL.
     */

}