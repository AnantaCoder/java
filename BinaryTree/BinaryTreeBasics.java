package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeBasics {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // tree constructor
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        TreeNode() {
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode root;

    public void insertData(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data < root.val) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // leaf node of a binary tree)(tree with no childern )
    private List<Integer> leafNode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        allLeafsOfTree(root, result);
        return result;

    }

    private void allLeafsOfTree(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        // leaf node
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }
        allLeafsOfTree(root.left, result);
        allLeafsOfTree(root.right, result);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // leetcode-872 leaf similar tree
        /* leetcode75-binaryTree-2 */
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        result1 = leafNode(root1);
        result2 = leafNode(root2);
        if (result1.size() != result2.size())
            return false;
        return result1.equals(result2);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // leetcode-100 same tree

        if (p==null && q==null) {
            return true;
        }
        
        if (p==null || q==null) {
            return false;
        }
        
        if (p.val!=q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }

    // maxDepth: recursively get depth of left and right subtrees, return 1 + max of
    // both
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        int depth;
        depth = 1 + Math.max(maxLeft, maxRight);
        return depth;
    }

    public static void main(String[] args) {
        BinaryTreeBasics tree = new BinaryTreeBasics();
        tree.insertData(5);
        tree.insertData(3);
        tree.insertData(7);
        tree.insertData(1);
        tree.insertData(4);

        System.out.println("Max Depth: " + tree.maxDepth(tree.root)); // 3
    }
}
