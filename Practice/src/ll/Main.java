package ll;

public class Main {

	public static class Node {
		int data;
		Node next;

		Node() {

		}

		Node(int data) {
			this.data = data;
		}
	}

	public static class LinkedList {
		Node head;
		Node tail;
		int size;

		int getFirst() {
			return this.head.data;
		}

		int getLast() {
			return this.tail.data;
		}

		void addLast(int val) {
			if (this.size == 0) {
				Node temp = new Node(val);
				head = tail = temp;
				size++;
			} else {
				Node temp = new Node(val);
				tail.next = temp;
				tail = temp;
				size++;
			}
		}

		void addFirst(int val) {
			if (size == 0) {
				Node temp = new Node(val);
				head = tail = temp;
				size = 1;
			} else {
				Node temp = new Node(val);
				temp.next = head;
				head = temp;
				size++;
			}

//			Node temp = new Node(val);
//			temp.data = val;
//			temp.next = head;
//			head = temp;
//			if (size == 0) {
//				tail = temp;
//			}
//			size++;
		}

		void addAt(int idx, int val) {

		}

		void removeFirst() {
			if (size == 0) {
				System.out.println("List Empty");
			} else if (size == 1) {
				head = tail = null;
				size = 0;
			} else {
				head = head.next;
				size--;
			}
		}

		void removeLast() {
			if (size == 0) {
				System.out.println("List Empty");
			} else if (size == 1) {
				head = tail = null;
				size--;
			} else {
				Node lm1 = head; // Last minus 1
				while (lm1.next != null) {
					lm1 = lm1.next;
				}
				lm1.next = null;
				tail = lm1;
				size--;
			}
		}

		private Node getNodeAt(int idx) {
			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp;
		}

		void reverseDataIterative() {
			int li = 0;
			int ri = size - 1;

			while (li < ri) {
				Node left = getNodeAt(li);
				Node right = getNodeAt(ri);

				int temp = left.data;
				left.data = right.data;
				right.data = temp;

				li++;
				ri--;
			}
		}

		void reversePointerIterative() {
			Node prev = null;
			Node curr = head;

			while (curr != null) {
				Node ahead = curr.next;

				curr.next = prev;
				prev = curr;

				curr = ahead;
			}

			Node temp = head;
			head = tail;
			tail = temp;
		}

		LinkedList merge2SortedLLs(LinkedList l1, LinkedList l2) {
			Node one = l1.head;
			Node two = l2.head;

			LinkedList res = new LinkedList();

			while (one != null && two != null) {
				if (one.data < two.data) {
					res.addLast(one.data);
					one = one.next;
				} else {
					res.addLast(two.data);
					two = two.next;
				}
//				res.size++;
			}

			while (one != null) {
				res.addLast(one.data);
				one = one.next;
//				res.size++;
			}

			while (two != null) {
				res.addLast(two.data);
				two = two.next;
//				res.size++;
			}

			return res;
		}

		private Node midNode(Node head, Node tail) {
			Node slow = head;
			Node fast = head;

			while (fast != tail && fast.next != tail) {
				fast = fast.next.next;
				slow = slow.next;
			}

			return slow;
		}

		public LinkedList mergeSort() {
			return mergeSort(this.head, this.tail);
		}

		private LinkedList mergeSort(Node head, Node tail) {
			if (head == tail) {
				Node nn = new Node(head.data);
				LinkedList newList = new LinkedList();
				newList.head = new Node(head.data);
				newList.tail = newList.head;
				return newList;
			}

			Node midNode = midNode(head, tail);

			LinkedList fsh = mergeSort(head, midNode); // First sorted half
			LinkedList ssh = mergeSort(midNode.next, tail); // Second sorted half

			LinkedList res = merge2SortedLLs(fsh, ssh);

			return res;
		}

		public void removeDuplicates() {

			LinkedList res = new LinkedList();

			while (this.size > 0) {

//				int val = this.removeFirst();

			}

		}

		public void oddEven() {
			LinkedList odd = new LinkedList();
			LinkedList even = new LinkedList();

			while (this.size > 0) {
				int val = this.getFirst();
				this.removeFirst();

				if (val % 2 == 0) {
					even.addLast(val);
				} else {
					odd.addLast(val);
				}
			}

			if (odd.size > 0 && even.size > 0) {
				odd.tail.next = even.head;
				this.head = odd.head;
				this.tail = even.tail;
				this.size = odd.size + even.size;
			} else if (odd.size > 0) {
				this.head = odd.head;
				this.tail = odd.tail;
				this.size = odd.size;
			} else if (even.size > 0) {
				this.head = even.head;
				this.tail = even.tail;
				this.size = even.size;
			}
		}

		Node pleft;

		public boolean isPalindrome() {
			pleft = head;
			return isPalindromeHelper(head, 0);
		}

		private boolean isPalindromeHelper(Node right, int floor) {
			if (right == pleft) {
				return true;
			}
			boolean rr = isPalindromeHelper(right.next, floor + 1);
			if (rr == false) {
				return false;
			} else if (pleft.data != right.data) {
				return false;
			} else {
				pleft = pleft.next;
				return true;
			}
		}

		Node fleft;

		public void fold() {
			fleft = head;
			foldHelper(head, 0);
		}

		private void foldHelper(Node right, int floor) {
			if (right == null) {
				return;
			}

			foldHelper(right.next, floor + 1);
			if(floor == size / 2) {
				right.next = null;
			} else if (floor > size / 2) {
				Node ahead = fleft.next;
				fleft.next = right;
				right.next = ahead;

				fleft = ahead;
			}
		}

		public void display() {
			Node temp = this.head;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list.addLast(2);
		list.addLast(7);
		list.addLast(1);
		list.addLast(6);
		list.addLast(5);
		list.addLast(3);
		list.addLast(8);
		list.addLast(4);

		list.display();

//		LinkedList sortedList = list.mergeSort();
//
//		sortedList.display();
//
//		list.oddEven();
//		list.display();

		list.fold();
		list.display();
	}

}
