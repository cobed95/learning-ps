public class NodeWithDepth {
    public NodeWithDepth left;
    public NodeWithDepth right;
    private BinaryTreeNode node;
    private int depth;

    public NodeWithDepth(BinaryTreeNode node) {
        this.node = node;
        if (node.left != null) this.left = new NodeWithDepth(node.left);
        if (node.right != null) this.right = new NodeWithDepth(node.right);
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getValue() {
        return this.node.value;
    }
}
