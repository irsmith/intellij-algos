package TODO;

public class EditDistance {

    //https://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
    //https://www.youtube.com/watch?v=b6AGUjqIPsA
    //https://www.google.com/search?q=youtube+edit+distance&oq=youtube+edit+distance&aqs=chrome..69i57j0j69i64.6631j0j7&sourceid=chrome&ie=UTF-8
    static final char xfrom [] = {'a','b','c','d','e','f'};
    static final char yto [] =   {'a','z','c','e','d'};
    static int N = xfrom.length + 1;
    static int M = yto.length + 1;
    static int dp[][] = new int[M][N];

    public static void main(String[] args) {
        // empty string to string of length one.
        for (int x = 1; x < N; x++) {
            dp[0][x] = x;
        }
        for (int y=1; y < M; y++) {
            dp[y][0] = y;
        }

        for (int y=1; y < M; y++) {
            for (int x=1; x <  N ; x++) {
                boolean isSame = (xfrom[x-1] == yto[y-1]);
                int diag = dp[y-1][x-1];
                int minOf3 = Math.min(Math.min(dp[y-1][x], dp[y][x-1]), diag);
                int cost = isSame ? 0 : 1;
                dp[y][x] = minOf3 + cost;
            }
        }
        System.out.println(dp[dp.length -1][dp[0].length -1]);
    }
}
