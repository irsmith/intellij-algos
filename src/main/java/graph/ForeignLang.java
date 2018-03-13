package graph;

import java.util.Stack;

public class ForeignLang {
      static String words[] = {"baa", "abcd", "abca", "cab", "cad"};

//Given a sorted dictionary (array of words) of an alien language, find order of characters in the language. Examples:
//    Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
//    Output: Order of characters is 'b', 'd', 'a', 'c'
//    Note that words are sorted and in the given language "baa" comes before "abcd", therefore 'b' is before 'a' in output. Similarly we can find other orders.
//    Input:  words[] = {"caa", "aaa", "aab"}
//    Output: Order of characters is 'c', 'a', 'b'

    static  int adj[][] = new int[4][4];
    static Stack<Integer> stack = new Stack<>();
    static boolean[] visited = new boolean[4];
    public static void main(String[] args) {

        for (int i=0;i<words.length - 2;i++) {
            cmp(words[i], words[i + 1]);
        }

        for (int i = 0;i <adj.length;i++) {
            if (! visited[i]) {/////  why??
                dfs(i);
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    private static void dfs(int cur) {
        visited[cur] = true;  //base case

        for (int child : adj[cur]) {
            if (! visited[child]) {
                dfs(child);
            }
        }
        stack.push(cur);   // post traversal bread crumb trail
    }

    /*
     Find first char that is diff and enter a less-than
     relationship such that adj[i][j] true means adj[i] < adj[j]
     */
    static void cmp(String w1, String w2) {

        for (int i = 0;i < Math.min(w1.length(), w2.length()); i++) {

            if (w1.charAt(i) != w2.charAt(i)) {
                //System.out.format("%c is less than %c %n",w1.charAt(i) , w2.charAt(i));
                adj[w1.charAt(i) - 'a'][w2.charAt(i) - 'a'] = 1;
                break;
            }
        }

    }

}
