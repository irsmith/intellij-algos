package dp;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class WordBreak {

    static Set<String> dict = new HashSet<>();
    static boolean dp[][];
    static int breaks[][];
    static {
        dict.add("in");
        dict.add("va");
        dict.add("bed");
        dict.add("bath");
        dict.add("beyond");
        dict.add("abcde");

    }

    public static void main(String[] args) {
        String t1="bedbathbeyond";
        String t3="inva";
        String t4="bedbathbeyondx";
        String t5="bedbathbeyondinva";

        System.out.println(wb(t5));
    }

    private static boolean wb(String s) {
        boolean rv = true;
        dp = new boolean[s.length()][s.length()];
        breaks = new int[s.length()][s.length()];

        rv = f(s, 0, s.length());
        return rv;
    }

    // i,n,v,a
    // in, nv, va
    // inv nva
    // inva

    private static boolean f(String s, int lo, int hi) {

        int N=s.length();
        for (int len = 1;len <= N; len++ ) {
            for (int strt = 0; strt + len - 1 < N; strt++ ) {
                int end = strt + len - 1;
                String w = s.substring(strt, end+1);
                System.out.println("word:"+w);
                if (dict.contains(w)) {
                    dp[strt][end] = true;
                } else {
                    // try inserting break after i, try them all
                    for (int i = 0;i<w.length() - 1;i++) {
                        if (dp[strt][i] && dp[i+1][end]) {
                            dp[strt][end] = true;
                            // we made a true block by concatenation.  Record where the split was so we can answer q.
                            breaks[strt][end] = i;
                        }
                    }
                }
            }
            System.out.println(len);
        }
        System.out.println("breaks:" + report(s));
        return dp[0][N-1];

    }

    private static List<Integer> report(String a) {
        int N = a.length();
        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(20);
        List<Integer> answ = new ArrayList<>();
        q.add(breaks[0][N-1] );
        while (!q.isEmpty()) {
            Integer idx = q.poll();
            if (idx != 0) {
                q.add(breaks[0][idx]);
                //q.add(breaks[idx+1][N-1]);  you only need to add the left hand side.
                answ.add(idx);
            }
        }
        return answ;
    }

}
