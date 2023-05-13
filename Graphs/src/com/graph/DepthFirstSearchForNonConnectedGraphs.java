package com.graph;

public class DepthFirstSearchForNonConnectedGraphs {

	int edges;
	int vertices;
	int[][] adjacentMatrix;

	// creation of graph
	public DepthFirstSearchForNonConnectedGraphs(int vertices, int edges) {
		this.edges = edges;
		this.vertices = vertices;
		adjacentMatrix = new int[vertices][vertices];
	}

	// insertion of edges
	public void edgesOfGraph(int start, int end) {
		adjacentMatrix[start][end] = 1;
		adjacentMatrix[end][start] = 1;
	}

	// traversal----depth first search
	public void dfs(int start, boolean[] visited) {
		System.out.print(start + " ");
		visited[start] = true;
		for (int i = 0; i < vertices; i++) {
			if (adjacentMatrix[start][i] == 1 && visited[i] == false) {
				dfs(i, visited);
			}
		}
		for (int i = 0; i < vertices; i++) {
			if (visited[i] == false) {
				dfs(i, visited);                          // dfs for second connected graph
			}
		}

	}

	public static void main(String[] args) {

		int v = 8;
		int e = 6;
		DepthFirstSearchForNonConnectedGraphs depthFirstSearch = new DepthFirstSearchForNonConnectedGraphs(v, e);
		depthFirstSearch.edgesOfGraph(0, 2);
		depthFirstSearch.edgesOfGraph(1, 4);
		depthFirstSearch.edgesOfGraph(0, 1);
		depthFirstSearch.edgesOfGraph(1, 3);
		depthFirstSearch.edgesOfGraph(3, 5);
		depthFirstSearch.edgesOfGraph(6, 7);
		boolean[] visited = new boolean[v];

		depthFirstSearch.dfs(0, visited);

	}

}

//
//                      0-----2
//                      |
//                      1-----4
//                      |
//                      3
//                      |
//                      5                        6------7