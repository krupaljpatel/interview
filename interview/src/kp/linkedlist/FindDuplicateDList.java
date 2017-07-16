package kp.linkedlist;

public class FindDuplicateDList {

	int a[] = new int[] { 3, 2, 68, 3, 1, 1, 3, 2, 0 };

	public static void main(String[] args) {
		Node list = new Node();
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		list.display();
		System.out.println("  jjj");
		list.sort();
		list.display();
	}

}

class Node {
	Integer data;
	Node next;
	Node prev;
	Node head;

	Node() {
	}

	Node(Integer data) {
		this.data = data;
	}

	void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	void add(Integer data) {
		if (head == null) {
			head = new Node(data);
			head.prev = null;
			head.next = null;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			Node newNode = new Node(data);
			temp.next = newNode;
			newNode.prev = temp;
		}
		return;
	}

	void sort() {
		Node first = head;
		head = mergeSort(first);
	}

	Node mergeSort(Node first) {
		if (first == null || first.next == null) {
			System.out.println(": null : "+ first);
			return first;
		}
		Node mid = getMiddle(first);
		System.out.print(" mid:" + mid.data);
		Node nextOfMiddle = mid.next;
		mid.next = null;
		Node left = mergeSort(first);
		System.out.print(" left : " + left.data);
		Node right = mergeSort(nextOfMiddle);
		System.out.print(" right : " + right.data);
		return merge(left, right);
	}

	private Node getMiddle(Node first) {
		if (first == null) {
			return null;
		}
		Node mid, fast;
		fast = first;
		mid = first;

		while (fast.next != null && fast.next.next != null && mid.next != null) {
			fast = fast.next.next;
			mid = mid.next;
		}
		return mid;
	}

	Node merge(Node left, Node right) {

		Node node = null;
		if (left == null){
			return right;
			
		}
		if(right == null){
			return left;
		}
		System.out.println(" merging:" + left.data + " " + right.data);
		if (left.data >= right.data) {
			node = right;
			node.next = merge(left, right.next);
		} else if (left.data < right.data) {
			node = left;
			node.next = merge(left.next, right);
		}
		return node;
	};

}