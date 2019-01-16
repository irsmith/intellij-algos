package cache;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

class Node {
   Object val;
   Node next;
   Node prev;
}
private int capacity;
private Map<Integer,Node> map;
private Node head;
private Node tail;
public int size;
public static final int EVICTION_CHUNK = 1;

// eviction policy is, fill to capacity then roll off
public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>(capacity);
    head = null;
}


// must be O(1) time
public void put(int key, Object value) {

     if (this.size == capacity) {
         //throw new RuntimeException("full");  no just roll off
         tail.prev.next = null;
     }
     if (value == null) throw new IllegalArgumentException("nn");

     //  add value to front of ll and keep pointer
     Node n = new Node();
     n.val = value;

     if (head == null) {
         head = new Node();

     } else {
         Node temp = head;
         head = n;
         n.next = temp;
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
      Node after = o.next;
    
      // remove o from middle of list (rewire before)
      before.next = after;
      after.prev = before;
      
      // put o in front
      head = o;
      o.next = savehead;
      o.prev = null;
      size--; // no!
      return o.val;
}


public static void main(String args[]) {


    int MAX=4;    
    LRUCache cache = new LRUCache(MAX);
        
    cache.put(1,"1");
    Assert.assertEquals(1, cache.size);
    
    
}










}