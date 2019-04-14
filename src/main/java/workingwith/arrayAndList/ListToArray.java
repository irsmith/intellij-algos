package workingwith.arrayAndList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by issmith1 on 5/1/16.
 * http://stackoverflow.com/questions/2607289/converting-array-to-list-in-java
 */
public class ListToArray {

    public static void main(String[] args) {

        // instantiate List in one line
        List<Integer> e = Arrays.asList(1,2);

        // convert List e to a[] where arr is an Object
        Integer[] arr = e.toArray(new Integer[e.size()]);
        System.out.println(arr); //emit [Ljava.lang.Integer;@5451c3a8
        System.out.println(Arrays.asList(arr)); // [1. 2]
        //NOTE !  Integer[] arr = e.toArray(); // imcompat types, require Integer[] found Object[]

        // convert List e to a[] where arr[] is primitive --
        int[] array = new int[e.size()];
        for(int i = 0; i < e.size(); i++) {
            array[i] = e.get(i);
        }
        System.out.println(Arrays.asList(array)); // [[I@2626b418]

        // sublist
        List<Integer> dataList = Arrays.asList(4,5,6,7,8,9,10);
        dataList = dataList.subList(2, 12 > dataList.size() ? dataList.size() : 38);
        System.out.println(dataList);//[6, 7, 8, 9, 10]


    }
}
