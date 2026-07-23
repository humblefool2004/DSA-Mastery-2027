class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        
        Collections.sort(processorTime);
        Collections.sort(tasks,Collections.reverseOrder());

        int completed=0;
        int ans=Integer.MIN_VALUE;

        for(int num : processorTime){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<4;i++){
                int a=tasks.get(completed++);
                max= Math.max(a,max);
            }
            ans=Math.max(ans,max+num);                
        }
        return ans;

    }
}