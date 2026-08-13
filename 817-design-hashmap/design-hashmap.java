class MyHashMap {
    private final int BUCKET_SIZE=15000;
    private class Node{
        int key;
        int val;
        Node next;
        Node(int key,int val){
            this.key= key;
            this.val= val;
            this.next=null;
        }
    }

    private Node[] map;
    public MyHashMap() {
        map= new Node[BUCKET_SIZE];
    }
    
    public void put(int key, int value) {
        int index= key%BUCKET_SIZE;
        Node head= map[index];
        while(head!=null){
            if(head.key==key){
                head.val=value;
                return;
            }
            head=head.next;
        }
        Node node = new Node(key,value);
        node.next=map[index];
        map[index]= node;
    }
    
    public int get(int key) {
        int index= key%BUCKET_SIZE;
        Node head= map[index];
        while(head!=null){
            if(head.key==key) return head.val;
            head=head.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index= key%BUCKET_SIZE;
        Node head= map[index];
        Node prev=null;
        while(head!= null){
            if(head.key==key) break;
            prev=head;
            head=head.next;
        }
        if(head==null) return;
        if(prev==null) map[index]= map[index].next;
        else prev.next=head.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */