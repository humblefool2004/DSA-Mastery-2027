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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        Map<TreeNode, TreeNode> map = new HashMap<>();

        Set<TreeNode> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (parent.left != null) {
                map.put(parent.left, parent);
                queue.offer(parent.left);
            }
            if (parent.right != null) {
                map.put(parent.right, parent);
                queue.offer(parent.right);
            }
        }

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

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().val);
        }
        return list;

    }
}