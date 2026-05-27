class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(headID,new ArrayList<>());
        for(int i=0;i<manager.length;i++){
            if(manager[i]==-1) continue;
            map.putIfAbsent(manager[i],new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        return dfs(map,informTime,headID);
    }

    private int dfs(Map<Integer,List<Integer>> map, int[] informTime,int curr){
        List<Integer> list = map.getOrDefault(curr,new ArrayList<>());
        int ans=0;
        for(int i : list){
            int time=dfs(map,informTime,i) + informTime[curr];
            ans=Math.max(time,ans);
        }
        return ans;
    }
}