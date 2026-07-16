class Solution {


    private int[] cum;
    private Random rand;
    public Solution(int[] w) {
        cum= new int[w.length];
        cum[0]=w[0];
        for(int i=1;i<w.length;i++){
            cum[i]=cum[i-1]+w[i];
        }
        rand=new Random();
    }
    
    public int pickIndex() {
        int target= rand.nextInt(cum[cum.length-1])+1;
        
        int left=0;
        int right= cum.length-1;
        while(left<right){
            int mid= left+(right-left)/2;
            if(cum[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */