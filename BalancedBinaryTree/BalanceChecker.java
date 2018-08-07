import java.util.*;

public class BalanceChecker {
    public static int getSize(BinaryTreeNode root) {
        return getSize(root, 0);
    }

    private static int getSize(BinaryTreeNode node, int count) {
        if (node != null) {
            count++;
            count = getSize(node.left, count);
            count = getSize(node.right, count);
        }
        return count;
    }

    public static boolean isLeaf(NodeWithDepth node) {
        return node.left == null && node.right == null;
    }

    public static boolean isBalanced(BinaryTreeNode root) {
        NodeWithDepth rootWithDepth = new NodeWithDepth(root);

        int[] depths = new int[2];
        rootWithDepth.setDepth(0);

        int size = getSize(root);
        Queue queue = new Queue(size);
        queue.push(rootWithDepth);
        while (!queue.isEmpty()) {
            NodeWithDepth node = queue.pop(); 
            System.out.println("At " + node.getValue() + ". Depth: " + node.getDepth());
            if (node.left != null) {
                node.left.setDepth(node.getDepth() + 1);
                queue.push(node.left);
            }
            if (node.right != null) {
                node.right.setDepth(node.getDepth() + 1);
                queue.push(node.right);
            }
            if (isLeaf(node)) {
                if (node.getDepth() == depths[0] || node.getDepth() == depths[1]) {
                    continue;
                } else if (depths[0] == 0) {
                    depths[0] = node.getDepth();
                } else if (depths[1] == 0) {
                    depths[1] = node.getDepth();
                } else {
                    return false;
                }
            }
            System.out.println("depths array: " + Arrays.toString(depths));
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.insertLeft(2);
        root.insertRight(3);
        root.left.insertLeft(4);
        root.left.insertRight(5);
        root.right.insertLeft(6);
        root.right.insertRight(7);
        root.left.left.insertLeft(8);
        root.left.left.insertRight(9);
        root.left.left.right.insertRight(10);

        System.out.println(isBalanced(root));
    }
}
