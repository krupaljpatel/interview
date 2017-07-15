package kp.graph;

import java.util.Iterator;
import java.util.LinkedList;

class DFSGraph {
	int V;
	LinkedList<Integer> nodes[];

	DFSGraph(int value) {
		V = value;
		nodes = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			nodes[i] = new LinkedList();
		}
	}

	public void addLink(int a, int b) {
		nodes[a].add(b);
	}

	void doDfs(int number) {
		Boolean visited[] = new Boolean[V];
		visited[number] = true;
		LinkedList<Integer> queue = new LinkedList<>();
	}

	void DFSUtil(Boolean visited[], int number) {
		System.out.println(number);
		Iterator<Integer> ii = nodes[number].iterator();
		while (ii.hasNext()) {
			Integer i = ii.next();
			if (!visited[i]) {
				visited[i] = true;
				DFSUtil(visited, i);
			}
		}

	}

}

public class DFS {
	public static void main(String args[]) {
		DFSGraph gg = new DFSGraph(4);
		gg.addLink(0, 1);
		gg.addLink(0, 2);
		gg.addLink(1, 2);
		gg.addLink(2, 0);
		gg.addLink(2, 3);
		gg.addLink(3, 3);
		gg.doBfs(2);
	}

}
