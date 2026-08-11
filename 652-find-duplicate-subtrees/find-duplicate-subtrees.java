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

    private Map<String, Integer> map = new HashMap<>();
    private Map<Integer, Integer> count = new HashMap<>();
    private List<TreeNode> ans = new ArrayList<>();
    private int id = 1;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {

        if(root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        String key = root.val + "," + left + "," + right;

        int currId = map.getOrDefault(key, id);

        if(!map.containsKey(key))
            map.put(key, id++);

        int freq = count.getOrDefault(currId, 0) + 1;
        count.put(currId, freq);

        if(freq == 2)
            ans.add(root);

        return currId;
    }
}