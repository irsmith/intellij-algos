package TODO;


public class SpiralPrint {

    int[][] a = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {10,11,12},
            {13,14,15}
    };
    int offset=0;
    int N = a.length;
    int M = a[0].length;

    public static void main(String args[]) {
        new SpiralPrint().printspiral();
    }


     void printspiral() {
        int offset=0;
        while (offset < Math.min(M,N) - 2) {
            int row = offset;
            for (int j=offset; j< M -  offset -1; j++) {
                System.out.println(a[row][j]);
            }
            int col = M - offset - 1;
            for (int i=offset; i< N -  offset - 1; i++) {
                System.out.println(a[i][col]);
            }
            row = N - offset - 1;
            for (int j= M - offset -1; j > offset; j--) {
                System.out.println(a[row][j]);
            }
            col = offset;
            for (int i = N - 1 - offset; i > offset; i--){
                System.out.println(a[i][col]);
            }

            offset++;
        }


    }

}

