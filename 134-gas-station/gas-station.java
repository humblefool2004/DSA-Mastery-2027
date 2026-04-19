class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int tank=0;
        int start=0;
        int total=0;
        for(int i=0;i<n;i++){
            int diff=gas[i]-cost[i];
            tank+=diff;
            total+=diff;
            if(tank<0){
                start=i+1;
                tank=0;
            }
        }
        return total>=0 ? start : -1;
    }
}


// //brute force, ofc TLE
// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int n=gas.length;
//         for(int i=0;i<n;i++){
//             boolean possible=true;
//             int j=i;
//             int currTank=gas[i];
//             if(currTank==0) continue;
//             while(possible){
//                 if(currTank-cost[j]<0){
//                     possible=false;
//                 }
//                 else{
//                     int x= (j+1) == n ? 0:j+1;
//                     currTank=currTank-cost[j] +gas[x];
//                     j++;
//                     if(j==n) j=0;
//                     if(j==i) return i;
//                 }           
//             }
//         }
//         return -1;

//     }
// }