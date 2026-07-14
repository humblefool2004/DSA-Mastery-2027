class RandomizedSet {
    private HashMap<Integer,Integer> map;
    private ArrayList<Integer> list;
    private Random rand;

    public RandomizedSet() {
        list= new ArrayList<>();
        map= new HashMap<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int removeIndex = map.get(val);
        int lastValue = list.getLast();

        list.set(removeIndex, lastValue);
        map.put(lastValue, removeIndex);

        list.removeLast();
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));   
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */