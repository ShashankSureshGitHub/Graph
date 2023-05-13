package com.graph;


// time complexity is O(n^2)-----------for adjacency matrix it is O(v*v)
// space complexity is O(n).............O(vertices)....stack is used to keep track of the visited vertex
public class DepthFirstSearch {

	int edges;
	int vertices;
	int[][] adjacentMatrix;

	// creation of graph
	public DepthFirstSearch(int vertices, int edges) {
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

	}

	public static void main(String[] args) {

		int v = 6;
		int e = 5;
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch(v, e);
		depthFirstSearch.edgesOfGraph(0, 2);
		depthFirstSearch.edgesOfGraph(1, 4);
		depthFirstSearch.edgesOfGraph(0, 1);
		depthFirstSearch.edgesOfGraph(1, 3);
		depthFirstSearch.edgesOfGraph(3, 5);
		boolean[] visited = new boolean[v];

		depthFirstSearch.dfs(0, visited);

	}

}
//0-----2
//|
//1-----4
//|
//3
//|
//5           
