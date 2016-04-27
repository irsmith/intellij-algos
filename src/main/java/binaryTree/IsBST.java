package binaryTree;

/**
 * Created by issmith1 on 4/5/16.
 */
public class IsBST {
    static class Range {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        Range(int min, int max){
            this.max=max;
            this.min=min;

        }
    }
    //2 approach, do in order traversal and verify values increase
    // pass in range and dfs
    public static void main(String[] args) {


        BTUtil.Node b40 = new BTUtil.Node(40,null,null);
        BTUtil.Node b18 = new BTUtil.Node(18,null, null);
       // BTUtil.Node b25 = new BTUtil.Node(25,null,null);
        BTUtil.Node b31= new BTUtil.Node(311,null,null);

        BTUtil.Node b20 = new BTUtil.Node(20,b18,b31);
        BTUtil.Node root = new BTUtil.Node(30,b20,b40);

        boolean r = f(root, new Range(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(r);
    }

    private static boolean f(BTUtil.Node cur, Range range) {
        //base case
        if (cur==null) {
            return true;
        }
        //visit
        boolean status =  (cur.val > range.min) && (cur.val < range.max);
        if (status == false) return false;


        boolean left = f(cur.left, new Range( range.min ,cur.val));
        boolean right = f(cur.right, new Range( cur.val, range.max));

        return left && right;
    }


}
