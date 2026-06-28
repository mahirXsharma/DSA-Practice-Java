class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        private Node(int key, int value, Node next, Node prev){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    HashMap<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;
    private int N;
    private int n = 0;

    public LRUCache(int capacity) {
        this.N = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node curr = map.get(key);
        // maintain the chain, so that remove curr will have no affect
        if(curr == head) return curr.value;
        else if(curr == tail){
            tail = tail.next;
            tail.prev = null;
            curr.next = null;
            curr.prev = head;
            head.next = curr;
            head = curr;
            return head.value;
        }

       else{ 
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        // now curr is free, prepare it to become head
        curr.next = null;
        curr.prev = head;
        // transfer head
        head.next = curr;
        head = curr;
        return head.value;
       }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            // replace the current node;
            Node curr = map.get(key);
            curr.value = value;
            // since this node was accesses, make it head
            if(curr != head){
                if(curr == tail){
                    tail = tail.next;
                    tail.prev = null;
                    curr.next = null;
                    curr.prev = head;
                    head.next = curr;
                    head = curr;
                }
                else{
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    // now curr is free, prepare it to become head
                    curr.next = null;
                    curr.prev = head;
                    // transfer head
                    head.next = curr;
                    head = curr;
                }
            } 
        }
        // lets assume there is no double entry case
        else{
            Node newNode = new Node(key, value, null, null);

            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                newNode.prev = head;
                head.next = newNode;
                head = newNode;

                // i am inserting the new Node on tail, while it should be inserted on head 
                // newNode.next = tail;
                // tail.prev = newNode;
                // tail = newNode;
            }
            map.put(key, newNode);
            n++;
        }
   
        if(n == N+1){
            // remove the one currently on tail
            map.remove(tail.key);
            if(tail.next == null){
                head = tail = null;
            }
            else{
                tail = tail.next ;
                tail.prev = null;
            }
            n--;
        }   
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */