public class BSTSearch {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static boolean search(Node root, int target) {
        Node current = root;

        while (current != null) {
            if (target == current.val) {
                return true;
            }

            if (target < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println(search(root, 60));
        System.out.println(search(root, 90));
    }
}