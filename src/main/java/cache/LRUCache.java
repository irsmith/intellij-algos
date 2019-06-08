package cache;

import linkedList.LinkListUtil;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import linkedList.LinkListUtil.*;

public class LRUCache {

    private int capacity;
    private Map<Integer,Node> map;
    private Node head;
    private Node tail;
    public int size;
    public static final int EVICTION_CHUNK = 1;

    /**
     * while studying system design we design an LRU cache that is fronted by a map and
     * backed by a double linked list.
     *
     * //note that the size of the map is always capacity.  We track the size of the list
     *
     * each time we read a node it moves to top of list
     *
     *     eviction policy is, fill to capacity then roll off by one
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = null;
    }


    // must be O(1) time.  Add to head of list
    public void put(int key, Character value) {
        if (value == null) throw new IllegalArgumentException("value cannot be null");

        if (this.size == capacity) {
            //throw new RuntimeException("full");  no just roll off
            tail.prev.nxt = null;
            size--;
        }

        //  add value to front of ll and keep pointer
        Node n = new Node();
        n.v = value;

        if (head == null) {
            head = n;
            tail = n;
        } else {
            Node save = head;
            head = n;
            n.nxt = save;
            save.prev = n;
            n.prev = null;
        }

        // create a map entry  at head of the list(key,pointer)
        map.put(key,n);
        size++;
    }



    // must be O(1) time
    public Object get(int key) {
        Node o = map.get(key);
        if (o == null) return null;  //cache miss

        // move object to head of the list
        Node savehead = head;
        Node before = o.prev;
        Node after = o.nxt;

        // remove o from middle of list (rewire before)
        before.nxt = after;
        after.prev = before;

        // put o in front
        head = o;
        o.nxt = savehead;
        o.prev = null;
        size--; // no!
        return o.v;
    }


    public static void main(String args[]) {


        int MAX=3;
        LRUCache cache = new LRUCache(MAX);

        cache.put(1,'a');
        Assert.assertEquals(1, cache.size);
        LinkListUtil.print(cache.head);

        cache.put(2,'b');
        Assert.assertEquals(2, cache.size);
        LinkListUtil.print(cache.head);

        cache.put(3,'c');
        Assert.assertEquals(3, cache.size);
        LinkListUtil.print(cache.head);


    }










}