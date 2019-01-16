package pramp;


/**
 * Deletion Distance
 The deletion distance of two strings is the minimum number of characters you need to delete in the two strings in order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3:

 By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
 We cannot get the same string from both strings by deleting 2 letters or fewer.
 Given the strings str1 and str2, write an efficient function deletionDistance that returns the deletion distance between them. Explain how your function works, and analyze its time and space complexities.

 Examples:

 input:  str1 = "dog", str2 = "frog"
 output: 3

 input:  str1 = "some", str2 = "some"
 output: 0

 input:  str1 = "some", str2 = "thing"
 output: 9

 input:  str1 = "", str2 = ""
 output: 0
 Constraints:

 [input] string str1
 [input] string str2
 [output] integer


 */
public class DeletionMin  {
    static String a = "bbba";
    static String b = "a";
    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }
    public static void main(String[] args) {

        Node n5= new Node(5);
        Node n3= new Node(3);
        Node r = new Node(0);
        r.children[0] = n5;
        r.children[1] = n3;


        System.out.println(DeletionMin.f(a,b));
        System.out.println(DeletionMin.f("dog","frog"));
        System.out.println(DeletionMin.f("some","some"));
        System.out.println(DeletionMin.f("some","thing"));

    }

    /*
      diagonal = dp[][];
      left = dp[i][j-1]
      top = dp[i-1][j]
     */
    private static int f(String a, String b) {
        int rv=Integer.MIN_VALUE;

        int N=a.length()+1;
        int M=b.length()+1;
        int dp[][] = new int[N][M];

        for (int i=0;i< N;i++) {
            dp[i][0] = i;
        }
        for (int i=0;i< M;i++) {
            dp[0][i] = i;
        }
        for (int i=1;i< N;i++) {
            for (int j=1;j< M; j++) {

                // if diagonal is less than top and left then cost=0 or 2 depending on char values
                // else if top is less than Min(diagonal, left) then cost=1 and dp[][] = top+1

                // else left is min and dp[][] = left+1;
                int cost = 0;
                if (dp[i-1][j-1] < Math.min(dp[i-1][j], dp[i][j-1])) {
                    if (b.charAt(j-1) != a.charAt(i-1)) {
                         cost=2;
                    }
                    dp[i][j] = dp[i-1][j-1] + cost;
                }  else if (dp[i-1][j] < Math.min(dp[i-1][j-1], dp[i][j-1])) {
                    dp[i][j] = dp[i-1][j] + 1;

                } else {
                    dp[i][j] = dp[i][j-1] + 1;
                }
            }
        }
        return dp[N-1][M-1];
    }
}
