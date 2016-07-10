package graph.dfs;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

import java.util.PriorityQueue;

/**
 * Created by irene on 6/19/16.
 */
public class EWeightedDigraph {
    public static void main(String[] args) {

        String file =  "/Users/irene/workspace/sedgewick/src/main/resources//algs4-data/tinyEWD.txt";


        In in = new In(file);
        edu.princeton.cs.algs4.EdgeWeightedDigraph G = new edu.princeton.cs.algs4.EdgeWeightedDigraph(in);
        System.out.println("xxx"+G);

//        Graph g = new Graph(new In(
//                "/Users/irene/workspace/sedgewick/src/main/resources//algs4-data/tiny.txt"));
        PriorityQueue<Edge> q = new PriorityQueue<>();

    }
}
