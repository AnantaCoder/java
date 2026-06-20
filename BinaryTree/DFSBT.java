package BinaryTree;

public class DFSBT {

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


    public  distanceFromOnetoAnotherLCA(TreeNode root , int p , int q){
        if(root==null) return 0;

        

    }
}