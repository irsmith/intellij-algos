package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given an array of words, find all shortest unique prefixes to represent
 *  each word in the given array. Assume that no word is prefix of another.

 Input: arr[] = {"zebra", "dog", "duck", "dove"}
 Output: dog, dov, du, z
 Explanation: dog => dog
 dove = dov
 duck = du
 z   => zebra


 http://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/

 */

public class ShortestUnique {
    public static void main(String[] args) {
        String  arr[] = {"zebra", "dog", "duck", "dove"};
        System.out.println(f(arr));

    }

    private static List<String> f(String[] data) {
        List<String> rv = new ArrayList<>();
        Trie trie = new Trie(data);
        printTrie(trie.root);
        for (String word: data) {

        }
        return rv;
    }

    static class Node {

        Node[] arr = new Node[26];
        boolean keyend = false;
    }
    static class Trie {
        Node root = new Node();
        public Trie(String[] data) {
            for (String word: data) {
                put(word);
            }
        }

        /** add a word to our trie.*/
        void put(String word) {
            Node cur = root;

            for (int i = 0;i<word.length();i++) {
                int idx = word.charAt(i) - 'a';

                if (cur.arr[idx] == null) {
                    // create new outdegree for 'd' for example
                    cur.arr[idx] = new Node();
                }
                cur = cur.arr[idx];
                if (i == word.length()-1) cur.keyend = true;

            }

        }
    }

    private static void printTrie(Node root) {

        Node cur=root;
        System.out.println(Arrays.asList(cur.arr));


        for (int i=0;i<cur.arr.length;i++)  {
            if (cur.arr[i] != null) {
                printTrie(cur.arr[i]);
            }
        }


    }
}
