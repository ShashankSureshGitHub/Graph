package com.graph;

import java.util.ArrayList;

public class PathUsingDFS {

	int edges;
	int vertices;
	int[][] adjacentMatrix;
	ArrayList<Integer> result = new ArrayList<>();

	// creation of graph
	public PathUsingDFS(int vertices, int edges) {
		this.edges = edges;
		this.vertices = vertices;
		adjacentMatrix = new int[vertices][vertices];
	}

	// insertion of edges
	public void edgesOfGraph(int start, int end) {
		adjacentMatrix[start][end] = 1;
		adjacentMatrix[end][start] = 1;
	}

	// traversal----depth first search and finding the shortest path
	public void dfs(int start, int end, boolean[] visited) {
		result.add(start);
		if (start == end) {
			printResult();
			return;
		}
		visited[start] = true;
		for (int i = 0; i < vertices; i++) {
			if (adjacentMatrix[start][i] == 1 && visited[i] == false) {
				dfs(i, end, visited);
			}
		}
		result.remove(result.size() - 1);

	}

	// printing the path

	public void printResult() {

		for (int i : result) {
			System.out.print(i);
			System.out.print("->");
		}
	}

	public static void main(String[] args) {

		int v = 6;
		int e = 5;
		PathUsingDFS path = new PathUsingDFS(v, e);
		path.edgesOfGraph(0, 2);
		path.edgesOfGraph(1, 4);
		path.edgesOfGraph(0, 1);
		path.edgesOfGraph(1, 3);
		path.edgesOfGraph(3, 5);
		boolean[] visited = new boolean[v];

		path.dfs(0, 5, visited);

	}

}
