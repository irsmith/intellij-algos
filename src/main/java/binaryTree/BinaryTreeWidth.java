package binaryTree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;


public class BinaryTreeWidth {

    static BTUtil.Node root = null;

    static {
        BTUtil.Node b41 = new BTUtil.Node(41, null, null);
        BTUtil.Node b40 = new BTUtil.Node(40, b41, null);
        BTUtil.Node b18 = new BTUtil.Node(18, null, null);
        BTUtil.Node b32 = new BTUtil.Node(32, null, null);

        BTUtil.Node b31 = new BTUtil.Node(31, b32, null);

        BTUtil.Node b20 = new BTUtil.Node(20, b18, b31);
        root = new BTUtil.Node(30, b20, b40);
    }

    static Map<Integer,Integer> map = new HashMap<>();  // lhs=level, rhs = width

    public static void main(String[] args) {

        w(root,0 );
        Integer maxoverall = Integer.MIN_VALUE;
        for (int value : map.values()) {
            if (value > maxoverall) maxoverall = value;
        }
        System.out.println(maxoverall);
    }

    static void w(BTUtil.Node c, int level) {

        //base case
        if (c==null) return;

        if (map.get(level) == null) {
            map.put(new Integer(level),0);
        }
        map.put(level, map.get(level)+1);
        w(c.left, level+1);
        w(c.right, level+1);

    }
}
