package recursion;

import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
/*
greedy team formation

For an upcoming programming contest, Roy is forming some teams from the nn students of his university. A team can have any number of contestants.

Roy knows the skill level of each contestant. To make the teams work as a unit, he should ensure that there is no skill gap between the contestants of the same team. In other words, if the skill level of a contestant is xx, then he has either the lowest skill level in his team or there exists another contestant with skill level of x−1x−1 in the same team. Also, no two contestants of the same team should have same skill level. Note that a contestant can write buggy code and thus can have a negative skill level.

The more contestants on the team, the more problems they can attempt at a time. So, Roy wants to form teams such that the smallest team is as large as possible.

Input Format

The first line of input contains t (1≤t≤100)t (1≤t≤100), the number of test cases.

Each case contains an integer n (0≤n≤105)n (0≤n≤105), the number of contestants, followed by nn space separated integers. The ithith integer denotes the skill level of ithith contestant. The absolute values of skill levels will not exceed 109109.

The total number of contestants in all cases will not exceed 106106.

Output Format

For each test case, print the size of smallest team in a separate line.

Sample Input

4
7 4 5 2 3 -4 -3 -5
1 -4
4 3 2 3 1
7 1 -2 -3 -4 2 0 -1
Sample Output

3
1
1
7

java -Xdebug -agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n Solution


Explanation

For the first case, Roy can form two teams: one with contestants with skill levels {-4,-3,-5} and the other one with {4,5,2,3}. The first group containing 3 members is the smallest.

In the second case, the only team is {-4}

In the third case, the teams are {3} , {1,2,3}, the size of the smaller group being 1.

In the last case, you can build a group containing all the contestants. The size of the group equals the total number of contestants.
 */
public class Solution {

    /* Makes all teams. Returns overall min */
    static int proc(Queue<Integer> a){
        if (a.size()==0 || a.size()==1) return a.size();
        int overallSetSizeMin=Integer.MAX_VALUE;

        while (a.size() >0) {
            int cur = a.remove();
            int curSetSizeMin = 1;
            while (a.size() >0) {
                 int next = a.remove();
                 if (next == cur) {
                     a.add(next);
                 } else if (next == cur + 1) {
                     curSetSizeMin++;
                 } else {
//                     cur=next;
                     overallSetSizeMin = Math.min(overallSetSizeMin,++curSetSizeMin);
                 }
            }


        }
        return overallSetSizeMin;
    }

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();
        for (int i=0;i<T;i++) {
            int N=s.nextInt();
           // s.nextLine(); no!  first element is the length
            int arr[] = new int[N];
            Queue<Integer> a = new LinkedBlockingDeque<>();

            for (int j=0;j<N;j++){
                arr[j]=s.nextInt();
            }
            Arrays.sort(arr);
            for (int j=0;j<N;j++){
                a.add(arr[j]);
            }
            s.nextLine();
            System.out.println(proc(a));//Arrays.asList(a));
        }
    }
}