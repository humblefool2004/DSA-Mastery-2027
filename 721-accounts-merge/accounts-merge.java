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
            for (int j=1 ; j<accounts.get(i).size();j++) {
                String st= accounts.get(i).get(j);
                if (map.getOrDefault(st, -1) != -1) {
                    ds.union(i, map.get(st)); //join it, person is same.
                } else {
                    map.put(st, i); //account MAY be different.
                }
            }
        }

        Map<Integer, TreeSet<String>> ans = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j=1 ; j<accounts.get(i).size();j++) {
                String st= accounts.get(i).get(j);
                //finding parent of the email.
                int idx = ds.findParent(i);
                TreeSet<String> curr = ans.getOrDefault(idx, new TreeSet<>());
                curr.add(st);
                ans.put(idx, curr);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry : ans.entrySet()) {
            List<String> curr = new ArrayList<>();
            curr.add(accounts.get(entry.getKey()).get(0));
            curr.addAll(entry.getValue());
            result.add(curr);
        }
        return result;
    }
}