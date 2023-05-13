package com.graph;

import java.util.ArrayList;
import java.util.Arrays;

//Time Complexity........O(n^2)....for adjacency matrix method
// Space complexity......O(n)...because of extra queue used
public class BreadthFirstSearch {
	int edges;
	int vertices;
	int[][] adjacentMatrix;

	// graph creation
	public BreadthFirstSearch(int vertices, int edges) {
		this.edges = edges;
		this.vertices = vertices;
		adjacentMatrix = new int[vertices][vertices];
	}

	// insertion of edges
	public void edgesOfGraph(int start, int end) {
		adjacentMatrix[start][end] = 1;
		adjacentMatrix[end][start] = 1;
	}

	// traversal
	public void bfs(int start) {

		ArrayList<Integer> queue = new ArrayList<>(vertices);
		queue.add(start);
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int vis = queue.remove(0);
			System.out.print(vis + " ");
			for (int i = 0; i < vertices; i++) {
				if (adjacentMatrix[vis][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}

	}

	public static void main(String[] args) {

		int v = 6, e = 5;
		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(v, e);
		breadthFirstSearch.edgesOfGraph(0, 2);
		breadthFirstSearch.edgesOfGraph(1, 4);
		breadthFirstSearch.edgesOfGraph(0, 1);
		breadthFirstSearch.edgesOfGraph(1, 3);
		breadthFirstSearch.edgesOfGraph(3, 5);
		breadthFirstSearch.bfs(0);

	}
}
