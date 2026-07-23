class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        
        Collections.sort(processorTime);
        Collections.sort(tasks,(a,b)->b-a);

        int completed=0;
        int ans=Integer.MIN_VALUE;

        for(int num : processorTime){
            
            ans=Math.max(ans,tasks.get(completed)+num);                
            completed+=4;
        }
        return ans;

    }
}