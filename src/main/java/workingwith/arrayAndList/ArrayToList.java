package workingwith.arrayAndList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;

/**
 * Created by issmith1 on 5/1/16.
 */
public class ArrayToList {

    public static void main(String[] args) {
        primitive();
        arrayOfObjects();


        // one line print primitive array  or array of objects
        System.out.println(Arrays.asList(2,3,5)); // emits [2, 3, 5]
        Integer a2[] = {0,1,2,3,4};
        System.out.println(a2); // emits [Ljava.lang.Integer;@5451c3a8
        // List<Integer> l2 =Arrays.asList(a); violates generics
        System.out.println( Arrays.asList(a2)); // emits [0, 1, 2, 3, 4]



    }

    private static void arrayOfObjects() {
        //instantiate in one line
        Integer [] ii = {new Integer(3),   new Integer(4)};
        // ----- object arr -------------------
        // init List in one line.
        List<Integer> alist = Arrays.asList(new Integer[]{2,3,4});
        System.out.println(alist);  //emits [2,3,4]

        // convert to List
        Integer[] integers = new Integer[] {1,2,3,4,5};
        List list21 =  Arrays.asList(integers); // Cannot modify returned list
        List list22 = new ArrayList<>(Arrays.asList(integers)); // good
        //List list23 = Arrays.stream(integers).collect(Collectors.toList()); //java8


        // subarray of list of objects
        Integer [] osubarray = Arrays.copyOfRange(integers, 1,2); //range [1:2) where end is exclusiv
        System.out.println(osubarray);  //emits [Ljava.lang.Integer;@30dae81
        System.out.println(Arrays.asList(osubarray));  // emits [2]
    }

    private static void primitive() {
//        // ----- primitive arr -------------------
//        int a[] = {0,1,2,3,4};
//
//        // jave8 primitive to list uses boxed()
//        int[] spam = new int[] { 1, 2, 3 };
//        List<Integer> list11 = Arrays.stream(spam)
//                .boxed()
//                .collect(Collectors.toList());
//        System.out.println(list11); //emists [1,2,3]
//
//        // subarray of primitives
//        int [] subarray = Arrays.copyOfRange(spam, 1,2);
//        System.out.println(subarray);  //[I@7cd84586
    }
}
