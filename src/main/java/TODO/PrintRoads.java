package TODO;

public class PrintRoads {
//5		3
//     0 1 0 0 0
//        1 0 1 1 0
//        0 1 0 0 0
//        0 1 0 0 0
//        0 0 0 0 0


    static int a[][] = {
            {0,1,0,0,0},
            {1,0,1,1,0},
            {0,1,0,0,0},
            {0,1,0,0,0},
            {0,0,0,0,0}
    };

    public static void main(String[] args) {
        int cnt = 0;
        for (int i=0; i< a.length;i++) {
            for (int j=i+1; j< a[0].length; j++) {
                if (a[i][j] == 1) cnt++;
            }

        }
        System.out.println(cnt);
    }



}
