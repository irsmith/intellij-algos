package workingwith.arrayAndList;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertArrayAndCollection {

	public static void main(String[] args) {

        //sort list of comparables
		Integer[] spam = new Integer[] {99, 1, 2, 3 };
		List<Integer> sortableList = Arrays.asList(spam);
		sortableList.sort(null);

        //convert primitive array to list of objects -- only one liner is via boxing with
        // Java8 Streams API
		int[] primitivearr = { 1, 2, 3 };
        List<Integer> arrViaStreamsAPI = Arrays.stream(primitivearr).boxed().collect(Collectors.toList());

        // sort primitive array
        Arrays.sort(primitivearr);  //sorts in place
        System.out.println(Arrays.toString(primitivearr));

        // You can’t use the popular Arrays.asList to convert it directly, because boxing issue.
		//List<Integer> newArr = list.toArray(new Integer[arr.length]);
        //https://www.mkyong.com/java/java-how-to-convert-a-primitive-array-to-list/

        // Can print list of objects but not primitive list
		System.out.println(arrViaStreamsAPI);

		// can put a list of ints into 'asList', since each element in your arg list is boxed
		System.out.println(Arrays.asList(2, 3, 4));

		// ? what does this do?
		System.out.println(Arrays.asList(primitivearr)); //output is [[I@4411d970]


		// http://stackoverflow.com/questions/2041778/how-to-initialize-hashset-values-by-construction
		// not time efficient since you are constructing an array, converting to a list and using that list to create a
		// set.
		Set<Integer> coins = new HashSet<Integer>(Arrays.asList(25, 10, 5, 1,1,1,1,1));
		System.out.println(coins);


	}
}
