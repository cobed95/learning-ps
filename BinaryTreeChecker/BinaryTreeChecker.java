public class BinaryTreeChecker {
    public static int checkLength(BinaryTreeNode root) {
        return checkLength(root, 0);
    }

    private static int checkLength(BinaryTreeNode node, int count) {
        if (node != null) {
            count++;
            count = checkLength(node.left, count);
            count = checkLength(node.right, count);
        }
        return count;
    }

    public static boolean nodeIsValid(BinaryTreeNode node) {
        if (node.left == null && node.right == null) {
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
        int size = checkLength(root);
        Stack stack = new Stack(size);
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            if (!nodeIsValid(node)) return false;

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return true;
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
        valid.right.right.insertRight(0);
        /*
         *       9(0)
         *      /
         *     8
         *    /
         *   7-6
         *  /
         * 5
         *  \
         *   3-4
         *    \
         *     2
         *      \
         *       1
         */

        System.out.println(treeIsValid(valid));
    }
}
