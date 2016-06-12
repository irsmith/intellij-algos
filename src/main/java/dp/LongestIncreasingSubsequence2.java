package dp;


public class LongestIncreasingSubsequence2 {

	public static void main(String[] args) {
		int[] a2 = {200, 201, 100, 101, -10, 102 - 9, 103 - 8, -6, -5, 300, 301};
        int[] a = {300, 200, 201, 100, 101, 102 };

        int result = lis(a);
        System.out.println (result);

        System.out.format ("%d %b %n",result , (result ==3));
	}

    private static int lis(int[] a) {
        if (a.length == 0) return 0;

        int lis[] = new int[a.length+1];
        lis[0] = 1;
        for (int i = 1; i < a.length; i++) {

            int innerLIS = 0;
            int candidate  = a[i]; //want to add this to lis[j]
            for (int j = 0; j < i; j++) {
                 if (a[i] > a[j]) {
                     innerLIS = Math.max(innerLIS, lis[j]+1);
                 } else {
                     innerLIS = 1;
                 }
            }
            lis[i] = innerLIS;


        }
        int answ = Integer.MIN_VALUE;
        for (int k:lis) {
            answ = Math.max(lis[k], answ);
        }
        return answ;
    }




}