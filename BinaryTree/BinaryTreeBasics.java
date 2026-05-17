package BinaryTree;

import java.lang.classfile.components.ClassPrinter.ListNode;
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

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
    public List<Integer> inorderTraversal(TreeNode root) {

        // leetcode-94. Binary Tree Inorder Traversal . 
    List<Integer> res = new ArrayList();
    helper(res,root);
    return res;
    }
    private void helper(List<Integer> res , TreeNode root){
        if(root==null){
            return ;
        }
        // left -> node -> right 
        helper(res,root.left);
        res.add(root.val);
        helper(res,root.right);
    }



    public int goodNodes(TreeNode root) {
        // leetcode-1448. Count Good Nodes in Binary Tree

        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null)
            return 0;

        int count = 0;

        if (node.val >= maxSoFar) {
            count = 1; // good node
        }
        maxSoFar = Math.max(maxSoFar, node.val);
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);
        return count;

    }


    public int pathSum(TreeNode root,int targetSum){
        // leetcode-437 path  III

    //-------------------------------------brute force approach -----------------------------------

        if (root==null) {
            return 0;
            
        }
        int counter = newDfs(root, targetSum);
        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);

        return counter+left+right;
    //-------------------------------------brute force approach -----------------------------------

        
    }

    private int newDfs(TreeNode node, long target){ //int target , Just change it to long, bc it's integer overflow.
        if (node==null) {
            return 0;
            
        }
        int count =0;
        if (node.val ==target) {
            count ++;
        }

        // continue path downward 
        count += newDfs(node.left, target-node.val);
        count += newDfs(node.right, target-node.val);

        return count;

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
