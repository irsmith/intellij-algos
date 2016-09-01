package sort;

import java.util.Arrays;
//http://articles.leetcode.com/here-is-phone-screening-question-from/
public class CountSort4 {

    public static void main(String[] args) {
        int data[] = {3, 4, 5, 1, 2, 1, 2, 2};
        int R = 26;

        Integer cnt[] = new Integer[R];
        for (int i = 0; i < cnt.length; i++) {
            cnt[i] = 0;
        }
        System.out.println("cum-init"+Arrays.asList(cnt));

        // for each data element increment the "map" of counts.  The key to the map is range (0,R)
        for (int i = 0; i < data.length; i++) {
            cnt[data[i]]++;
        }
        System.out.println("cum "+Arrays.asList(cnt));

        // change cnt to cumulative cnt
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] = cnt[i-1] + cnt[i];
        }

        System.out.println("cum-cnt "+Arrays.asList(cnt));


        Integer output[] = new Integer[data.length]; //todo dont think i need this.

//        int cidx=0;
//        for (int oidx = 0;oidx<output.length; oidx++){
//            while(cnt[cidx] > 0) {
//                output[oidx] = cidx;
//                System.out.println(Arrays.asList(output));
//
//                cnt[cidx]--;
//            }
//            cidx++;
//        }
        int j = 0;//output index
        for (int i=0;i<cnt.length;i++) {
            while ( cnt[i] > 0 && j < cnt[i]) {
                output[j] = i;
                j++;
            }
        }
        System.out.println(Arrays.asList(output));
    }

}
