//quickselect approach
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points,0,points.length-1,k);
        return Arrays.copyOfRange(points,0,k);
    }

    private void quickSelect(int[][] points,int left, int right,int k){
        if(left>=right) return;
        int pivotIndex=partition(points,left,right);
        if(pivotIndex==k){
            return;
        }else if(pivotIndex>k){
            quickSelect(points,left,pivotIndex-1,k);
        }else{
            quickSelect(points,pivotIndex+1,right,k);
        }
    }

    private int partition(int[][] points, int left,int right){
        int randomIndex = left + new Random().nextInt(right - left + 1);
        swap(points, randomIndex, right);
        int pivot=getDist(points[right]);
        int i=left;
        for(int j=left;j<right;j++){
            if(getDist(points[j])<=pivot){
                swap(points,i,j);
                i++;
            }
        }
        swap(points,i,right);
        return i;
    }

    private int getDist(int[] point){
        return point[0]*point[0] + point[1]*point[1]; 
    }
    private void swap(int[][] points,int i,int j){
        int[] temp= points[i];
        points[i]= points[j];
        points[j]=temp;
    }
}

/*
//Priority Queue approach
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq= new PriorityQueue<>(
            (a,b)-> 
            Integer.compare(
                b[0]*b[0] + b[1]*b[1],
                a[0]*a[0] + a[1]*a[1]
                )
        );

        for(int i=0;i<points.length;i++){
            pq.offer(points[i]);
            if(pq.size() >k){
                pq.poll();
            }
        }
        int[][] answer =new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            answer[i++]=pq.poll();
        }
        return answer;
    }
}
*/