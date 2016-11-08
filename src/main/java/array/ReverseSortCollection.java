package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReverseSortCollection {

	Collections c;
	static List<Integer> list = Arrays.asList(4 ,5,6);
			//new ArrayList<Integer>();

	public static void main(String[] args) {
		System.out.println(list);
		Comparator<Integer> cmp = Collections.reverseOrder();
		Collections.sort(list, cmp);
		System.out.println(list);


	}
}
