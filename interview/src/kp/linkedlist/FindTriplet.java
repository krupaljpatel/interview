package kp.linkedlist;

public class FindTriplet {
	class LinkedList {
		Node head;

		class Node {
			int data;
			Node next;
			Node prev;

			Node(int d) {
				this.data = d;
				this.next = null;
				this.prev = null;
			}
		}

		void sort() {
			Node first = head;
			head = mergeSort(first);
		}

		Node mergeSort(Node first) {
			if (first == null || first.next == null) {
				System.out.println(": null : " + first);
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
			if (left == null) {
				return right;

			}
			if (right == null) {
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

		void push(int n) {
			if (head == null) {
				head = new Node(n);
				head.next = null;
			} else {
				Node newNode = new Node(n);
				Node temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = newNode;
				newNode.prev = temp;
			}

		}

		void findTriplet(int k) {
			Node curr = head;
			Node currNext;
			while (curr != null) {
				int sum = curr.data;
				currNext = curr.next;
				Node n = findLast();
				findPairs(currNext, n, k - sum);
			}
		}

		Node findLast() {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			return last;
		}

		void findPairs(Node curr, Node last, int sum) {
			while (curr != null && last != null && curr != last) {
				if ((curr.data + last.data) == sum) {
					System.out.println(curr.data + " " + last.data);
					curr = curr.next;
					last = last.prev;
				} else if ((curr.data + last.data) < sum) {
					curr = curr.next;
				} else if ((curr.data + last.data) > sum) {
					last = last.prev;
				}
			}
		}
	}

	public static void main(String args[]) {
		FindTriplet ft = new FindTriplet();
		LinkedList ll = ft.new LinkedList();
		ll.push(1);
		ll.push(4);
		ll.push(5);
		ll.push(33);
		ll.push(53);
		ll.push(34);
		ll.push(4);
		ll.push(2);
		ll.push(4);
		ll.sort();
		ll.findTriplet(10);
	}
}
