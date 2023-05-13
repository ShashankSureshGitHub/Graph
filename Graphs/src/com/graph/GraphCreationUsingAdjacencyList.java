package com.graph;

import java.util.ArrayList;

public class GraphCreationUsingAdjacencyList {

	public static void newEdge(ArrayList<ArrayList<Integer>> adj, int start, int end) {

		adj.get(start).add(end);
		adj.get(end).add(start);
	}

	public static void main(String[] args) {

		int v = 6;
		ArrayList<ArrayList<Integer>> adjacencylist = new ArrayList<ArrayList<Integer>>(v);
		// LinkedList<Integer>[] l = new LinkedList[10];................... can use this
		// too
		// ArrayList<Integer>[] a = new ArrayList[10];......................can use this
		// too
		for (int i = 0; i < v; i++) {
			adjacencylist.add(new ArrayList<>());
		}

	}

}
