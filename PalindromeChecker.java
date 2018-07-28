import java.util.*;

public class PalindromeChecker {
    private static class Node {
        public char data;
        public int count;
        public Node left;
        public Node right;

        public Node(char data) {
            this.data = data;
            this.count = 1;
        }
    }

    private static class BinaryTree {
        private Node root;
        private int numOfOdd;
        
        public BinaryTree(Node root) {
            this.root = root;
            this.numOfOdd = 0;
        }

        public void add(char data) {
            this.add(this.root, data);
        }

        private void add(Node node, char data) {
            if (node.data == data) {
                node.count++;
            } else if (node.right != null && node.data < data) {
                this.add(node.right, data);
            } else if (node.left != null && node.data > data) {
                this.add(node.left, data);
            } else if (node.right == null && node.data < data) {
                node.right = new Node(data);
            } else {
                node.left = new Node(data);
            }
        }

        public boolean isPalindrome(boolean isOdd) {
            this.countOdd(this.root);
            if (isOdd) {
                return this.numOfOdd == 1;
            } else {
                return this.numOfOdd == 0;
            }
        }

        private void countOdd(Node node) {
            if (node != null) {
                if (node.count % 2 != 0) {
                    this.numOfOdd++;
                }
                countOdd(node.left);
                countOdd(node.right);
            }
        }
    }

    public static boolean isPalindrome(String input) {
        if (input.length() == 0) {
            return false;
        }
        
        BinaryTree binaryTree = new BinaryTree(new Node(input.charAt(0)));
        for (int i = 1; i < input.length(); i++) {
            binaryTree.add(input.charAt(i));
        }
        
        boolean isOdd = input.length() % 2 != 0;
        return binaryTree.isPalindrome(isOdd);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(args[0]));
    }
}
