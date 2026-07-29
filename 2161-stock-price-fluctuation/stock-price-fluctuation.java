class StockPrice {
    private Map<Integer, Integer> timeToPrice;
    private PriorityQueue<int[]> minHeap;
    private PriorityQueue<int[]> maxHeap;
    private int latestTimestamp;

    public StockPrice() {
        timeToPrice = new HashMap<>();
        minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
    }

    public void update(int timestamp, int price) {
        int[] arr = { price, timestamp };
        minHeap.offer(arr);
        maxHeap.offer(arr);
        timeToPrice.put(timestamp, price);
        latestTimestamp = Math.max(latestTimestamp, timestamp);
    }

    public int current() {
        return timeToPrice.get(latestTimestamp);
    }

    public int maximum() {

        while (true) {
            int[] top = maxHeap.peek();
            if (timeToPrice.get(top[1]) == top[0])
                return top[0];
            maxHeap.poll();
        }
    }

    public int minimum() {
        while (true) {
            int[] top = minHeap.peek();
            if (timeToPrice.get(top[1]) == top[0])
                return top[0];
            minHeap.poll();
        }
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */

//solved using two treemaps
// class StockPrice {

//     private TreeMap<Integer,Integer> map; //time,price
//     private TreeMap<Integer,Integer> priceFreq; // frequency of prices
//     private int latestTimestamp = 0;
//     public StockPrice() {
//         map= new TreeMap<>();
//         priceFreq= new TreeMap<>();
//     }

//     public void update(int timestamp, int price) {
//         if(map.containsKey(timestamp)){
//             int oldPrice = map.get(timestamp);
//             if(priceFreq.get(oldPrice)==1){
//                 priceFreq.remove(oldPrice);
//             }else{
//                 priceFreq.put(oldPrice,priceFreq.get(oldPrice)-1);
//             }
//         }
//         map.put(timestamp,price);
//         priceFreq.put(price, priceFreq.getOrDefault(price,0)+1);
//         latestTimestamp = Math.max(latestTimestamp, timestamp);
//     }

//     public int current() {
//         return map.get(latestTimestamp);
//     }

//     public int maximum() {
//         return priceFreq.lastKey();
//     }

//     public int minimum() {
//         return priceFreq.firstKey();
//     }
// }
