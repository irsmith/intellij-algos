package binaryTree;

/**
 * Created by issmith1 on 4/7/16.
 */
public class HeightBT {

    //2 approach, do in order traversal and verify values increase
    // pass in range and dfs
    public static void main(String[] args) {


        BTUtil.Node b40 = new BTUtil.Node(40,null,null);
        BTUtil.Node b18 = new BTUtil.Node(18,null, null);
        // BTUtil.Node b25 = new BTUtil.Node(25,null,null);
        BTUtil.Node b32= new BTUtil.Node(32,null,null);

        BTUtil.Node b31= new BTUtil.Node(31,b32,null);

        BTUtil.Node b20 = new BTUtil.Node(20,b18,b31);
        BTUtil.Node root = new BTUtil.Node(30,b20,b40);

        int r = h(root, -1);
        System.out.println(r);
    }

    /**
     *
     * @param root
     * @param cur
     * @return
     */
    private static int h(BTUtil.Node root, int cur) {
        if (root==null) return cur;
        int lefth=h(root.left, cur+1);
        int righth=h(root.right, cur+1);
        return Math.max(lefth,righth);
    }

}
