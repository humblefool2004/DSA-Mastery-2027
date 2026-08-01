/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        buildParent(root, null);

        Set<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);
        visited.add(target);

        while (k-- > 0) {
            int size = queue.size();
            while (size-- > 0) {

                TreeNode temp = queue.poll();
                if (temp.left != null && !visited.contains(temp.left)) {
                    visited.add(temp.left);
                    queue.offer(temp.left);
                }
                if (temp.right != null && !visited.contains(temp.right)) {
                    visited.add(temp.right);
                    queue.offer(temp.right);
                }
                TreeNode parent = map.get(temp);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
            }
        }

        List<Integer> list = new ArrayList<>(queue.size());
        while (!queue.isEmpty()) {
            list.add(queue.poll().val);
        }
        return list;
    }

    private void buildParent(TreeNode node, TreeNode parent) {
        if (node == null)
            return;

        if (parent != null)
            map.put(node, parent);

        buildParent(node.left, node);
        buildParent(node.right, node);
    }
}