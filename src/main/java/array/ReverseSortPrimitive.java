package org.skup.array;

import java.util.Arrays;

public class ReverseSortPrimitive {
    // calc mid then swap around mid using one or 2 pointer
	
	// java does not have reverse sort by comparator
	public static void main(String[] args) {
		
	double[] array = new double[1048576];
	//http://stackoverflow.com/questions/215271/sort-arrays-of-primitive-types-in-descending-order
	Arrays.sort(array);
	// reverse the array
	for(int i=0;i<array.length/2;i++) {
	     // swap the elements
	     double temp = array[i];
	     array[i] = array[array.length-(i+1)];
	     array[array.length-(i+1)] = temp;
	}
	}
}
