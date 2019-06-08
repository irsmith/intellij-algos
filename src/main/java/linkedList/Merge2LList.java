package linkedList;

/*
 * need to keep it simple, yest handle complexity of first pointer
 * could be null or one list is exhausted
 */
public class Merge2LList {
    static boolean aexhaust = false;
    static boolean bexhast = false;

    public static void main(String[] args) {


        LinkListUtil.Node x = new LinkListUtil.Node('x', null);
        LinkListUtil.Node d = new LinkListUtil.Node('d', x);
        LinkListUtil.Node b = new LinkListUtil.Node('b', d);

        LinkListUtil.Node g = new LinkListUtil.Node('g', null);
        LinkListUtil.Node e = new LinkListUtil.Node('e', g);
        LinkListUtil.Node c = new LinkListUtil.Node('c', e);
        LinkListUtil.Node a = new LinkListUtil.Node('a', c);

        LinkListUtil.Node lista = a;
        LinkListUtil.Node listb = b;


        LinkListUtil.print(lista);
        LinkListUtil.print(listb);

        LinkListUtil.Node newh=merge(lista, listb);
        LinkListUtil.print(newh);
    }

    private static LinkListUtil.Node merge(LinkListUtil.Node alist, LinkListUtil.Node blist) {
        LinkListUtil.Node result = new LinkListUtil.Node('0',null);
        LinkListUtil.Node res = result;
        LinkListUtil.Node a = alist;
        LinkListUtil.Node b = blist;

        //while (!(aexhaust && bexhast)) {

        while (!aexhaust || !bexhast) {
            if (bexhast) {
                res.nxt = a;

                if (a.nxt == null) aexhaust=true; else a=a.nxt;
            } else if (aexhaust) {
                res.nxt =b;
                if (b.nxt == null) bexhast = true; else b=b.nxt;
            } else if (a.v <= b.v) {
                 res.nxt = a;
                if (a.nxt == null) aexhaust=true; else a=a.nxt;

            } else {
                 res.nxt = b;
                if (b.nxt == null) bexhast = true; else b=b.nxt;

            }
            res=res.nxt;
        }
        return result.nxt;

    }
}
