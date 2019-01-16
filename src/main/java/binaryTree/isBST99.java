package binaryTree;


public class isBST99 {


    public static void main(String[] args) {
        BTUtil.Node node = new BTUtil.Node(3);
        System.out.println(isbst( node, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    static boolean isbst(BTUtil.Node cur, int min, int max) {


        if (cur == null) return true;
        if (cur.val > max || cur.val < min) {
            return  false;
        }
        boolean isleftbst = isbst(cur.left, min, cur.val);

        boolean islrigtbst = isbst(cur.right, cur.val, max);

        return isleftbst && islrigtbst;

    }
}
