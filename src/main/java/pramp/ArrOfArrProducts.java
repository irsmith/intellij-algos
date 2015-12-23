package pramp;

import java.util.Arrays;

/*
 function calcProductArray(arr):
   n = length(arr)
   productArr = []
   for i from 0 to n-1:
      productArr[i] = 1
   product = 1
   for i from 0 to n-1:
      productArr[i] *= product
      product *= arr[i]
   product = 1
   for i from n-1 to 0:
      productArr[i] *= product
      product *= arr[i]
   return productArr
 */
public class ArrOfArrProducts {
	
	public static void main(String[] args) {
		int[] rv = calcProductArr(new int [] {2,3,4,5});
		System.out.println(Arrays.asList(rv)); //no!
		System.out.println(Arrays.toString(rv));  //oneliner

	}

	private static int[] calcProductArr(int[] a) {
		//int [] rv = new int[a.length];
         int[] productArr = new int[a.length];
         int N  = a.length;
         for (int i=0;i<N;i++){
        	 productArr[i]= 1;
         }
         // calc UP a iteravly 
         int product = 1;
         for (int i=0;i<N;i++){
        	 productArr[i]= productArr[i] * product;
        	 product = product * a[i];
        	 continue;
         }
         // calc DOWN a iteravly 
         product = 1;
         for (int i=N-1;i>=0;i--){
        	 productArr[i]= productArr[i] * product;
        	 product = product * a[i];
        	 continue;
         }
         return productArr;
	}

}
