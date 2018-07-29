public class BinaryTreeChecker {
    public static boolean nodeIsValid(BinaryTreeNode node) {
        if (node == null) {
            return true;
        } else if (node.left == null && node.right == null) {
            return true;
        } else if (node.left == null) {
            return node.value <= node.right.value;
        } else if (node.right == null) {
            return node.left.value <= node.value;
        } else {
            return node.left.value <= node.value && node.value <= node.right.value;
        }
    }

    public static boolean treeIsValid(BinaryTreeNode root) {
        if (!nodeIsValid(root)) return false;
        treeIsValid(root.left);
        treeIsValid(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode valid = new BinaryTreeNode(5);
        valid.insertLeft(3);
        valid.left.insertLeft(2);
        valid.left.left.insertLeft(1);
        valid.left.insertRight(4);

        valid.insertRight(7);
        valid.right.insertLeft(6);
        valid.right.insertRight(8);
        valid.right.right.insertRight(9);

        System.out.println(treeIsValid(valid));
    }
}
