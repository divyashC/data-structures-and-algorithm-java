package practicalExam;

//O(log n)

public class BST {

	public static class Node {
		int key;
		Node left;
		Node right;

		public Node(int key) {
			this.key = key;
			this.left = this.right = null;
		}
	}

	public Node root;

	public BST() {
		root = null;
	}

	public void insert(int key) {

		Node node = new Node(key);

		if (root == null) {
			root = node;
			return;
		} else {
			Node present = root;
			Node parent = null;

			while (true) {
				parent = present;

				if (key < present.key) {
					present = present.left;
					if (present == null) {
						parent.left = node;
						return;
					}
				} else {
					present = present.right;
					if (present == null) {
						parent.right = node;
						return;
					}
				}
			}
		}
	}

	public Node minNode(Node root) {
		if (root.left != null) {
			return minNode(root.left);
		} else {
			return root;
		}
	}

	public Node delete_node(Node node, int value) {

		if (node == null) {
			return null;
		} else {
			if (value < node.key) {
				node.left = delete_node(node.left, value);
			} else if (value > node.key) {
				node.right = delete_node(node.right, value);
			} else if (node.left == null && node.right == null) {
				node = null;
			} else if (node.left == null) {
				node = node.right;
			}

			else if (node.right == null) {
				node = node.left;
			} else {
				Node temp = minNode(node.right);

				node.key = temp.key;

				node.right = delete_node(node.right, temp.key);
			}
			return node;
		}
	}

	public void inorderTraversal(Node node) {

		if (root == null) {
			System.out.println("The Tree is empty");
			return;
		} else {
			if (node.left != null) {
				inorderTraversal(node.left);
			}
			System.out.print(node.key + " -> ");
			if (node.right != null) {
				inorderTraversal(node.right);
			}

		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BST bst = new BST();

		// adding nodes to BST
		bst.insert(30);
		bst.insert(25);
		bst.insert(35);
		bst.insert(31);
		bst.insert(16);
		bst.insert(40);

		System.out.println("Binary search tree after insertion: ");
		bst.inorderTraversal(bst.root);

		Node delete_node = null;

		delete_node = bst.delete_node(bst.root, 40);
		System.out.println("\nbinary search tree after deleting 40 :");
		bst.inorderTraversal(bst.root);

		delete_node = bst.delete_node(bst.root, 25);
		System.out.println("\nbinary search tree after deleting 25 :");
		bst.inorderTraversal(bst.root);

		delete_node = bst.delete_node(bst.root, 30);
		System.out.println("\nbinary search tree after deleting 30 :");
		bst.inorderTraversal(bst.root);
	}

}
