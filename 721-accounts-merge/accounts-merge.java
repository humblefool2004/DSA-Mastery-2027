//attempt only if you have sanity more than 80%

class Solution {
    private class DisjointSet {
        private int size[];
        private int parent[];

        public DisjointSet(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int findParent(int u) {
            if (u == parent[u])
                return u;
            return parent[u] = findParent(parent[u]);
        }

        public void union(int u, int v) {
            int uP = findParent(u);
            int vP = findParent(v);
            if (uP == vP)
                return;
            if (size[uP] < size[vP]) {
                parent[uP] = vP;
                size[vP] += size[uP];
            } else {
                parent[vP] = uP;
                size[uP] += size[vP];
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account= accounts.get(i);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String st = account.get(j);
                Integer owner = map.get(st);

                if (owner == null) {
                    map.put(st, i);
                } else {
                    ds.union(i, owner);
                }
            }
        }

        Map<Integer, List<String>> ans = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int root = ds.findParent(entry.getValue());
            ans.computeIfAbsent(root, k -> new ArrayList<>()).add(entry.getKey());
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : ans.entrySet()) {
            List<String> curr = new ArrayList<>();
            curr.add(accounts.get(entry.getKey()).get(0));
            Collections.sort(entry.getValue());
            curr.addAll(entry.getValue());
            result.add(curr);
        }
        return result;
    }
}