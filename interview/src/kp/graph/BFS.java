package kp.graph;

import java.util.Iterator;
import java.util.LinkedList;

class Graph {
	int V;
	LinkedList<Integer> nodes[];

	Graph(int value) {
		V = value;
		nodes = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			nodes[i] = new LinkedList();
		}
	}

	public void addLink(int a, int b) {
		nodes[a].add(b);
	}

	void doBfs(int number) {
		Boolean visited[] = new Boolean[V];
		visited[number] = true;
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(number);
		while (queue.size()!=0) {
			int value = queue.poll();
			System.out.println(value);
			Iterator<Integer> ii = nodes[value].iterator();
			while (ii.hasNext()) {
				Integer i = ii.next();
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}

public class BFS {
	public static void main(String args[]) {
		Graph gg = new Graph(4);
		gg.addLink(0, 1);
		gg.addLink(0, 2);
		gg.addLink(1, 2);
		gg.addLink(2, 0);
		gg.addLink(2, 3);
		gg.addLink(3, 3);
		gg.doBfs(2);
	}

}
