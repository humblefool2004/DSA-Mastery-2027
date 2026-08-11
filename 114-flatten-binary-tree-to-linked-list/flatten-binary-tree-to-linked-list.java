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
class Solution {
    TreeNode curr=null;
    public void flatten(TreeNode root) {
        if(root!=null){
            flatten(root.right);
            flatten(root.left);
            root.left=null;
            root.right=curr;
            curr=root;
        }
    }
}