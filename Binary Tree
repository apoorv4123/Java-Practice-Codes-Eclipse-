package bt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static class Pair {
		Node node;
		int state;

		Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
//		if (node.left != null) {
//			str += node.left.data + " -> ";
//		} else {
//			str += ". -> ";
//		}
//		str += node.data;
//		if (node.right != null) {
//			str += " <- " + node.right.data;
//		} else {
//			str += " <- .";
//		}
//		System.out.println(str);

		str += node.left == null ? "." : node.left.data;
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static int size(Node node) {
		if (node == null)
			return 0;
		return size(node.left) + size(node.right) + 1;
	}

	public static int sum(Node node) {
		if (node == null)
			return 0;
		return sum(node.left) + sum(node.right) + node.data;
	}

	public static int max(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		return Math.max(node.data, Math.max(max(node.left), max(node.right)));
	}

	public static int height(Node node) {
		if (node == null)
			return -1;
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	public static void preOrder(Node node) {
		if (node == null) {
			return;
		}

		// N
		System.out.print(node.data + " ");
		// L
		preOrder(node.left);
		// R
		preOrder(node.right);
	}

	public static void inOrder(Node node) {
		if (node == null) {
			return;
		}

		// L
		inOrder(node.left);
		// N
		System.out.print(node.data + " ");
		// R
		inOrder(node.right);
	}

	public static void postOrder(Node node) {
		if (node == null) {
			return;
		}

		// L
		postOrder(node.left);
		// R
		postOrder(node.right);
		// N
		System.out.print(node.data + " ");
	}

	public static void levelOrder(Node node) {
		Queue<Node> mq = new ArrayDeque<>(); // main queue
		mq.add(node);

		while (mq.size() > 0) {
			int count = mq.size();
			for (int i = 0; i < count; i++) {
				// r : remove
				Node rn = mq.remove(); // removed node
				// p : print
				System.out.print(rn.data + " ");
				// a : add children
				if (rn.left != null)
					mq.add(rn.left);
				if (rn.right != null)
					mq.add(rn.right);
			}
			System.out.println();
		}
	}

	public static void preOrderIterative(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> st = new Stack<>();
		st.push(root);

		while (st.size() > 0) {
			Node rn = st.pop();

			System.out.print(rn.data + " ");

			if (rn.right != null)
				st.push(rn.right);
			if (rn.left != null)
				st.push(rn.left);
		}
		System.out.println();
	}

	public static class TravPair {
		Node node;
		int state;

		TravPair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static void postOrderIterative(Node root) {
		Stack<TravPair> st = new Stack<>();
		st.push(new TravPair(root, 1));

		while (st.size() > 0) {
			TravPair tp = st.peek();

			if (tp.state == 1) {
				if (tp.node.left != null) {
					st.push(new TravPair(tp.node.left, 1));
				}
				tp.state++;
			} else if (tp.state == 2) {
				if (tp.node.right != null) {
					st.push(new TravPair(tp.node.right, 1));
				}
				tp.state++;
			} else {
				System.out.print(tp.node.data + " ");
				st.pop();
			}
		}
		System.out.println();
	}

	public static void inOrderIterative(Node root) {
		Stack<TravPair> st = new Stack<>();
		st.push(new TravPair(root, 1));

		while (st.size() > 0) {
			TravPair tp = st.peek();

			if (tp.state == 1) {
				if (tp.node.left != null) {
					st.push(new TravPair(tp.node.left, 1));
				}
				tp.state++;
			} else if (tp.state == 2) {
				System.out.print(tp.node.data + " ");
				st.pop();

				if (tp.node.right != null) {
					st.push(new TravPair(tp.node.right, 1));
				} else { // not necessary
					continue;
				}
				tp.state++; // not necessary
			} else { // not necessary
				st.pop();
			}
		}
		System.out.println();
	}

	public static void traversals(Node root) {

	}

	public static boolean find(Node node, int item, ArrayList<Integer> path) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			path.add(node.data);
			return true;
		}

		boolean filc = find(node.left, item, path); // find in left child
		if (filc) {
			path.add(node.data);
			return true;
		}

		boolean firc = find(node.right, item, path);
		if (firc) {
			path.add(node.data);
			return true;
		}

		return false;
	}

	public static void printKLevelsDown(Node node, int k) { // Print at level k
		if (node == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.print(node.data + " ");
		}
		printKLevelsDown(node.left, k - 1);
		printKLevelsDown(node.right, k - 1);
	}

	public static void printKLevelsDownIterative(Node node, int k) {
		Queue<Node> mq = new ArrayDeque<Main.Node>();
		mq.add(node);

		int currLevel = 0;
		while (mq.size() > 0) {

			int count = mq.size();
			if (currLevel == k) {
				for (int i = 0; i < count; i++) {
					// r
					Node rn = mq.remove();
					// p : work
					System.out.print(rn.data + " ");
				}
				return;
			} else {
				for (int i = 0; i < count; i++) {
					// r
					Node rn = mq.remove();
					// p : work
					// a
					if (rn.left != null) {
						mq.add(rn.left);
					}
					if (rn.right != null) {
						mq.add(rn.right);
					}
				}
				currLevel++;
			}
		}
	}

	public static void printKNodesFar(Node node, int data, int k) {
		path = new ArrayList<>();
		findHelperPrintKNodesFar(node, data);

		for (int i = 0; i < path.size(); i++) {
			printKLevelsDownHelperPrintKNodesFar(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
		}
	}

	public static void printKLevelsDownHelperPrintKNodesFar(Node node, int k, Node blocker) {
		if (node == null || k < 0 || node == blocker) {
			return;
		}
		if (k == 0) {
			System.out.print(node.data + " ");
		}
		printKLevelsDownHelperPrintKNodesFar(node.left, k - 1, blocker);
		printKLevelsDownHelperPrintKNodesFar(node.right, k - 1, blocker);
	}

	static ArrayList<Node> path; // To get all nodes in the path from node to root

	public static boolean findHelperPrintKNodesFar(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			path.add(node);
			return true;
		}

		boolean filc = findHelperPrintKNodesFar(node.left, item); // find in left child
		if (filc) {
			path.add(node);
			return true;
		}

		boolean firc = findHelperPrintKNodesFar(node.right, item);
		if (firc) {
			path.add(node);
			return true;
		}

		return false;
	}

	public static void pathToLeafFromRootInRange(Node node, String path, int sum, int lo, int hi) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) { // leaf node : Jab aap leaf node pe ho tab aapne abhi takk leaf
														// node ko add nhi kia hai
			sum += node.data; // add leaf node data to sum
			if (sum >= lo && sum <= hi) {
				System.out.println(path + node.data + " ");
			}
			return;
		}
		pathToLeafFromRootInRange(node.left, path + node.data + " ", sum + node.data, lo, hi);
		pathToLeafFromRootInRange(node.right, path + node.data + " ", sum + node.data, lo, hi);
	}

	public static void main(String[] args) {

		Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
				null };

		Node root = new Node(arr[0], null, null);
		Pair rootPair = new Pair(root, 1); // root pair

		Stack<Pair> st = new Stack<>();
		st.push(rootPair);

		int idx = 0;
		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.state == 1) {
				idx++;
				if (arr[idx] != null) {
					Node ln = new Node(arr[idx], null, null); // left node
					top.node.left = ln;

					Pair lp = new Pair(ln, 1);
					st.push(lp);
				} else {
					top.node.left = null;
				}
				top.state++;
			} else if (top.state == 2) {
				idx++;
				if (arr[idx] != null) {
					top.node.right = new Node(arr[idx], null, null);
					Pair rp = new Pair(top.node.right, 1);
					st.push(rp);
				} else {
					top.node.right = null;
				}
				top.state++;
			} else {
				st.pop(); // top.state = 3
			}

		}

//		display(root);

//		System.out.println(size(root));
//		System.out.println(sum(root));
//		System.out.println(max(root));
//		System.out.println(height(root));

//		preOrder(root);
//		inOrder(root);
//		postOrder(root);
//		System.out.println();

//		levelOrder(root);

//		preOrderIterative(root);
//		postOrderIterative(root);
//		inOrderIterative(root);

//		ArrayList<Integer> list = new ArrayList<>();
//		find(root, 70, list);
//		System.out.println(list);

//		printKLevelsDown(root, 2);
//		System.out.println();
//		printKLevelsDownIterative(root, 2);
		
		pathToLeafFromRootInRange(root, "", 0, 0, 500);

	}

}
