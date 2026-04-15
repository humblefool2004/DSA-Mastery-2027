/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //BST inorder traversal gives sorted order.
class Solution {
    Integer prev=null;
    int minDiff= Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null){
            minDiff= Math.min(minDiff,root.val-prev);
        }
        prev=root.val;
        inorder(root.right);
    }
}