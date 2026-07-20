public class BSTDelete {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.val) {
            node.left = insert(node.left, value);
        } else if (value > node.val) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public static Node delete(Node node, int sku) {
        if (node == null) {
            return null;
        }

        if (sku < node.val) {
            node.left = delete(node.left, sku);
        } else if (sku > node.val) {
            node.right = delete(node.right, sku);
        } else {

            // Case 1: Leaf node
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (node.left == null) {
                return node.right;
            }

            // Case 2: Only left child
            if (node.right == null) {
                return node.left;
            }

            // Case 3: Two children
            Node successor = findMinimum(node.right);

            node.val = successor.val;

            node.right = delete(node.right, successor.val);
        }

        return node;
    }

    private static Node findMinimum(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.print("Before deletion: ");
        inorder(root);

        root = delete(root, 50);

        System.out.print("\nAfter deletion: ");
        inorder(root);
    }
}