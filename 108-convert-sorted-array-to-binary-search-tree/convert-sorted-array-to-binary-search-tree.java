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
  //  private int curr=0;
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    private TreeNode build(int[] nums,int left, int right){
        if(left>right) return null;
        int mid= left + (right-left)/2;
        // TreeNode leftNode= build(nums,left,mid-1);
        // TreeNode node= new TreeNode(nums[curr++]);
        // TreeNode rightNode= build(nums,mid+1,right);
        // node.left=leftNode;
        // node.right=rightNode;
        // return node;
        return new TreeNode(nums[mid],build(nums,left,mid-1),build(nums,mid+1,right));
    }
}