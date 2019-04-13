package trie;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 *
 warmup to insert into trie - it is similar to inserting for a BT.  We first
 search for the key until we cannot find it.  If we find a previous key we replace
 the key value , else we insert a new node.


 */
public class BinarySearchTree {
    Node root;

    // instantiate whole tree
    public BinarySearchTree(int[] values) {
        for (int key:values) {
            insert(key,root);
        }
    }

    // recursively walk bst until key is found (in which case we replace),
    // or key is not found, in which case we create the new node.
    // Since this is recursive we consider we are in a subtree.
    // The subtree can be null, in which case we make the node.
    // The subtree can have a key = val , in which case we insert new node
    // Else we keep searching  either left or right
    void insert(int key, Node cur){
        if (cur == null) {
            cur = new Node();  //dah! cannot return a value
            return;
        }
        if (cur.val == key) return;
        if (key < cur.val) {
            insert(key, cur.left);
        } else {
            insert(key, cur.right);
        }

    }
    class Node{
        Node left, right;
        int val;
    }



    public static void main(String[] args) {
        int []values = {5,4,9, 3,0 ,6};
        BinarySearchTree binarySearchTree = new BinarySearchTree(values);



    }
}
