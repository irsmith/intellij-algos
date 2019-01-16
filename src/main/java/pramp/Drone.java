package pramp;

import java.io.*;
import java.util.*;

/* answ
function calcEnergyBasic(route):
    largestEnergyDeficit = 0
    energyBalance = 0

    for i from 1 to route.length-1:
        energyBalance = energyBalance + (route[i-1][2] - route[i][2])
            if (energyBalance < largestEnergyDeficit):
                largestEnergyDeficit = energyBalance

    return -1*(largestEnergyDeficit)
The basic solution

Imagine that you start the flight with an empty battery, but can charge the drone while it’s in the air.

In this case, your charging algorithm is simple. Just before your drone flies to the next point in route, you calculate whether the drone will incur any energy deficit. If so, you charge the drone with the exact amount of energy that will ensure that the energy level at the next is point is precisely zero. Otherwise, you don’t charge the drone. With this algorithm, the answer is simply the largest energy deficit you’ve encountered during the drone’s flight.

Applying this algorithm on the example provided above will show that the largest deficit occurs when the drone climbs from coordinate z = 6 to coordinate z = 15. Notice that at z = 6 the energy balance is +4. So climbing from 6 to 15 will bring the energy balance to 4 - (15 - 6) = -5. The largest deficit is therefore 5 which is also the minimal amount of energy the drone will need at the beginning of its flight to be able to finish it.
 */
class Drone {

    static int[][]  route = {{0,   2, 10},
            {3,   5,  0},
            {9,  20,  6},
            {10, 12, 15},
            {10, 10,  8}};
    
    static int calcDroneMinEnergy(int[][] route) {
        int largestEnergyDeficit = 0;
        int energyBalance = 0;

        for (int i = 1; i<  route.length; i++) {
            energyBalance = energyBalance + (route[i - 1][2] - route[i][2]);
            if (energyBalance < largestEnergyDeficit) {
                largestEnergyDeficit = energyBalance;
            }
        }
        return -1*(largestEnergyDeficit);
    }

    public static void main(String[] args) {
        System.out.println(calcDroneMinEnergy(route));
    }

    // works for this test case but in other test cases, the drone would crash if balance at N-1 before the min
    // was zero.
    static int calcDroneMinEnergy_wrong(int[][] route) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i=0;i< route.length; i++) {
            if (route[i][2] > max) {
                max = route[i][2];
            } else if (route[i][2] < min) {
                min = route[i][2];
            }
        }
        int initialHeight = route[0][2] - min;
        return max - min - initialHeight;
    }
    /*
    more elegant solution

    Time Complexity: O(N). We have a single loop that iterates once over route and conducts a constant
    number of operations at each iteration.

Space Complexity: O(1). We are using only one auxiliary variable in the algorithm, maxHeight, and it uses a constant amount of space.


    function calcDroneMinEnergy(route):
   maxHeight = route[0][2]

   for i from 1 to route.length-1:
       if (route[i][2] > maxHeight):
           maxHeight = route[i][2]

   return maxHeight - route[0][2]

     */

}