package binaryTree;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/

Given an array ‘pre[]’ that represents Preorder traversal of a spacial binary tree
 where every node has either 0 or 2 children. One more array ‘preLN[]’
 is given which has only two possible values ‘L’ and ‘N’. T


 */
public class ConstructSpecialBTgivenPre {
    static int pre[] =   {10,  30,  20,   5,   15};
    static char preLN[] = {'N', 'N', 'L', 'L', 'L'};

    public static void main(String[] args) {

           BTUtil.Node root = f(0);
           // root = iterative();
           System.out.println(root.toString());
    }

    static BTUtil.Node f(int i) {
        // iterator i gets pre and type ; if null return null;
        // make node
        // if Leaf make node and return;
        // if notLeaf recur(c.left) which returns the left node;
        // recur(c.right w returns r node;
        // hook them up and return
        if (pre.length == 0  || i == pre.length) return null;  //todo
        int valueC = pre[i];
        char type = preLN[i];

        BTUtil.Node cur = new BTUtil.Node(valueC);
        System.out.printf("creating node:%d of type:%c %n",cur.val,type);
        if (type =='L') return cur;
        cur.left  = f(++i);
        cur.right = f(i);
        return  cur;
    }

    static BTUtil.Node iterative() {

        Stack<BTUtil.Node> stack = new Stack<>();
        int i = 0;
        int valueC = pre[i];
        BTUtil.Node root = new BTUtil.Node(valueC);
        stack.push(new BTUtil.Node(valueC));
        while (! stack.isEmpty()) {
            BTUtil.Node n = stack.pop();
            char type = preLN[i];
            if (type == 'N') {
                // attach left or right child and push the child because it could be a N type
                int newval =  pre[i++];
                BTUtil.Node child = new BTUtil.Node(newval);
                if (n.left == null) {
                    n.left = child;
                } else if (n.right == null) {
                    n.right = child;
                }
                stack.push(child);
            }
        }
        return  root;
    }
}
