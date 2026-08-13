class MyHashSet {
    private final int BUCKET_SIZE=15000;
    private class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    private Node[] hash;
    public MyHashSet() {
        hash= new Node[BUCKET_SIZE];
    }
    
    public void add(int key) {
        int index= key%BUCKET_SIZE;
        Node head= hash[index];
        while(head!=null){
            if(head.val==key) return;
            head=head.next;
        }
        Node node= new Node(key);
        node.next= hash[index];
        hash[index]= node;
    }
    
    public void remove(int key) {
        int index= key%BUCKET_SIZE;
        Node prev= null;
        Node head= hash[index];
        while(head!=null){
            if(head.val==key) break;
            prev=head;
            head=head.next;
        }
        if(head==null) return;
        if(prev==null) hash[index]= hash[index].next;
        else {
            prev.next= head.next;
            head.next= null;
        }
    }
    
    public boolean contains(int key) {
        int index=key%BUCKET_SIZE;
        Node head= hash[index];
        while(head!=null){
            if(head.val==key) return true;
            head= head.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */