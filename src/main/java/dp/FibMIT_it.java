package dp;

/**
 * Created by irene on 4/23/16.
 * http://stackoverflow.com/questions/18659792/circular-arraylist-extending-arraylist
 */
public class FibMIT_it {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(rec_memosz2(n));
    }

    private static int rec_memosz2(int n) {
        Integer[] cach=new Integer[3];

        for (int j=0;j<= n;j++) {
            if (j < 2) {
                cach[(j%2)]=j;
            } else {
                int temp = cach[(j-2)%2]+cach[(j-1)%2];
                cach[j%2]=temp;

            }
        }
        return cach[n%2];
    }

    private static int rec_memo(int n) {
        Integer[] cach=new Integer[n+1];

        for (int j=0;j<= n;j++) {
            if (j < 2) {
                 cach[j]=j;
            } else {
                int temp = cach[j-2]+cach[j-1];
                cach[j]=temp;

            }
        }
        return cach[n];
    }
}
