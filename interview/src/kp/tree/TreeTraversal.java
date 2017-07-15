package kp.tree;

public class TreeTraversal {
	/// public static Node<String> head;
	Integer[] sum1 = new Integer[] { 0, 0, 0, 0, 0, 0, 0 };
	int max1=0;
	public static void main(String args[]) {

		TreeTraversal t = new TreeTraversal();
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.left.left.left = new Node(3);
		n.left.right = new Node(5);
		n.right.left = new Node(6);
		n.right.right = new Node(7);
		n.right.right.right = new Node(8);
		t.preorder(n);
		for (int d = 1; d <= 3; d++) {
			t.levelorder(n, d);
		}

		// t.sum1={0,0,0,0,0,0,0,0,0,0,0};
		/*
		 * System.out.println("sums are"); for(Integer i:t.sum1){
		 * System.out.println(i); }
		 */
		//System.out.println("height=" + t.depth(n));
		System.out.println("height=" + t.dia(n));
		System.out.println("max = "+t.max1);
		
	}

	/*
	 * void reverse(Node n){` Node prev = null,next=n.;
	 * 
	 * }s
	 */
	void levelorder(Node n, int level) {
		if (level == 1) {
			System.out.println(n.data);
			return;
		}

		levelorder(n.left, level - 1);
		levelorder(n.right, level - 1);
	}

	int depth(Node n) {
		if (n == null)
			return 0;
		int ldepth = depth(n.left);
		int rdepth = depth(n.right);
		if (ldepth > rdepth) {
			return ldepth+1;
			
		} else {
			return rdepth+1;
		}
	}
	int dia(Node n) {
		if (n == null)
			return 0;
		int ldepth = depth(n.left);
		int rdepth = depth(n.right);
		if(ldepth+rdepth>max1){
			max1 = ldepth+rdepth+1;
		}
		if (ldepth >= rdepth) {
			return ldepth+1;
			
		} else {
			return rdepth+1;
		}
	}
	void preorder(Node n) {
		if (n == null) {
			return;
		}
		// System.out.println(n.data);
		preorder(n.left);
		preorder(n.right);
	}
}

class Node {
	int data;

	Node(int d) {
		this.data = d;
	}

	Node left;
	Node right;

}
