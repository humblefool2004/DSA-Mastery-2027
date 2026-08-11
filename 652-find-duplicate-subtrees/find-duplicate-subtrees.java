class Solution {

    private Map<Key, Integer> map;
    private Map<Integer, Integer> count;
    private List<TreeNode> ans;
    private int id;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        map = new HashMap<>();
        count = new HashMap<>();
        ans = new ArrayList<>();
        id = 1;

        dfs(root);

        return ans;
    }

    private int dfs(TreeNode root) {

        if(root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        Key key = new Key(root.val, left, right);

        int currId = map.getOrDefault(key, id);

        if(!map.containsKey(key))
            map.put(key, id++);

        int freq = count.getOrDefault(currId, 0) + 1;
        count.put(currId, freq);

        if(freq == 2)
            ans.add(root);

        return currId;
    }

    private static class Key {

        int val;
        int left;
        int right;

        Key(int val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object obj) {

            if(this == obj)
                return true;

            if(!(obj instanceof Key))
                return false;

            Key other = (Key)obj;

            return val == other.val &&
                   left == other.left &&
                   right == other.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}