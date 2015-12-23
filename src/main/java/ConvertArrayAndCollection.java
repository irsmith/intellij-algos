import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertArrayAndCollection {

	public static void main(String[] args) {

		Integer[] arr = { 1, 2, 3 };

		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(3);

		Integer newArr[] = list.toArray(new Integer[list.size()]);

		System.out.println(newArr);

		System.out.println(Arrays.asList(2, 3, 4));
		System.out.println(Arrays.asList(arr));
		// http://stackoverflow.com/questions/2041778/how-to-initialize-hashset-values-by-construction
		// not time efficient since you are constructing an array, converting to a list and using that list to create a
		// set.

		Set<Integer> coins = new HashSet<Integer>(Arrays.asList(25, 10, 5, 1,1,1,1,1));
		System.out.println(coins);

	}
}
