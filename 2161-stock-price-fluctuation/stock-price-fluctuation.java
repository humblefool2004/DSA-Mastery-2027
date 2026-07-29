class StockPrice {

    private TreeMap<Integer,Integer> map; //time,price
    private TreeMap<Integer,Integer> priceFreq; // frequency of prices

    public StockPrice() {
        map= new TreeMap<>();
        priceFreq= new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            int oldPrice = map.get(timestamp);
            if(priceFreq.get(oldPrice)==1){
                priceFreq.remove(oldPrice);
            }else{
                priceFreq.put(oldPrice,priceFreq.get(oldPrice)-1);
            }
        }
        map.put(timestamp,price);
        priceFreq.put(price, priceFreq.getOrDefault(price,0)+1);
    }
    
    public int current() {
        return map.get(map.lastKey());
    }
    
    public int maximum() {
        return priceFreq.lastKey();
    }
    
    public int minimum() {
        return priceFreq.firstKey();
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