public class BSTValidation {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(
            Node node,
            long min,
            long max
    ) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        boolean leftValid = validate(
                node.left,
                min,
                node.val
        );

        boolean rightValid = validate(
                node.right,
                node.val,
                max
        );

        return leftValid && rightValid;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(60);

        System.out.println(isValidBST(root));
    }
}