package practicalExam;

// O(log n)

public class AVL {

	class Node {
		Node left, right;
		int data, bf, height;

		Node(int element) {
			this.data = element;
		}
	}

	Node root;

	public void insert(int element) {
		if (root == null) {
			root = new Node(element);
		} else {
			root = insert(root, element);
		}

	}

	private Node insert(Node node, int element) {
		if (element <= node.data) {
			if (node.left == null) {
				node.left = new Node(element);
			} else {
				node.left = insert(node.left, element);
			}
		} else if (node.right == null) {
			node.right = new Node(element);
		} else {
			node.right = insert(node.right, element);
		}

		update(node);
		return balance(node);
	}

	private void update(Node node) {
		int leftNodeHeight = node.left == null ? -1 : node.left.height;
		int rightNodeHeight = node.right == null ? -1 : node.right.height;
		node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
		node.bf = rightNodeHeight - leftNodeHeight;
	}

	private Node balance(Node node) {
		if (node.bf == -2) {
			if (node.left.bf <= 0) {
				return leftLeftCase(node);
			} else {
				return leftRightCase(node);
			}
		} else if (node.bf == 2) {
			if (node.right.bf >= 0) {
				return rightRightCase(node);
			} else {
				return rightLeftCase(node);
			}
		}
		return node;
	}

	private Node leftLeftCase(Node node) {
		return rightRotation(node);
	}

	private Node leftRightCase(Node node) {
		node.left = leftRotation(node.left);
		return rightRotation(node);
	}

	private Node rightRightCase(Node node) {
		return leftRotation(node);
	}

	private Node rightLeftCase(Node node) {
		node.right = rightRotation(node.right);
		return leftRotation(node);
	}

	private Node leftRotation(Node node) {
		Node newParent = node.right;
		node.right = newParent.left;
		newParent.left = node;
		update(node);
		update(newParent);
		return newParent;
	}

	private Node rightRotation(Node node) {
		Node newParent = node.left;
		node.left = newParent.right;
		newParent.right = node;
		update(node);
		update(newParent);
		return newParent;
	}

	private int predecesor(Node root) {
		root = root.left;
		while (root.right != null) {
			root = root.right;
		}
		return root.data;
	}

	private int successor(Node root) {
		root = root.right;
		while (root.left != null) {
			root = root.left;
		}
		return root.data;
	}

	public void remove(int element) {
		root = remove(root, element);

	}

	private Node remove(Node node, int element) {
		if (node == null) {
			return null;
		}
		if (element < node.data) {
			node.left = remove(node.left, element);
		} else if (element > node.data) {
			node.right = remove(node.right, element);
		} else if (node.left == null && node.right == null) {
			node = null;
		} else if (node.right != null) {
			node.data = successor(node);
			node.right = remove(node.right, node.data);
		} else {
			node.data = predecesor(node);
			node.left = remove(node.left, node.data);
		}
		if (node != null) {
			update(node);
			return balance(node);
		}
		return null;
	}

	public void printInOrder() {
		printInOrder(root);
	}

	private void printInOrder(Node root) {
		if (root.left != null) {
			printInOrder(root.left);
		}
		System.out.print(root.data + " ");
		if (root.right != null) {
			printInOrder(root.right);
		}
	}

	public static void main(String[] args) {
		AVL avltree = new AVL();
		avltree.insert(50);
		avltree.insert(25);
		avltree.insert(34);
		avltree.insert(60);
		avltree.insert(70);
		avltree.insert(55);
		System.out.println("AVL tree after insertion of elements: ");
		avltree.printInOrder();
		avltree.remove(50);
		System.out.println();
		System.out.println("AVL Tree after deletion of an element: ");
		avltree.printInOrder();

	}

}