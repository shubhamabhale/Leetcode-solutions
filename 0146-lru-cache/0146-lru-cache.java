class LRUCache {
    class ListNode {
        int key;
        int val;
        ListNode next, prev;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    ListNode head;
    ListNode tail;
    HashMap<Integer, Integer> cache;
    int CAPACITY;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        head = null;
        tail = null;
        CAPACITY = capacity;
    }
    

    public void moveToHead(int key, int value) {
        if (head == null) {
            head = new ListNode(key, value);
            head.next = head.prev = null;
            tail = head;
        } else {
            ListNode temp = new ListNode(key, value);
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public int removeFromEnd() {
        if (head == null || tail == null) {
            return -1;
        }
        int removedKey = tail.key;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return removedKey;
    }

    public int removeElement(int key) {
        if (head == null) {
            return -1;
        }
        ListNode curr = head;
        if (curr.key == key) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // If head was the only node, update tail
            }
            return -1;
        }
        while (curr.key != key) {
            curr = curr.next;
        }
        ListNode tempPrev = curr.prev;
        tempPrev.next = curr.next;
        if (curr.next != null) {
            curr.next.prev = tempPrev;
        } else {
            tail = tempPrev; // If the node to remove was the tail, update tail
        }
        curr.next = curr.prev = null;
        return curr.val;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            removeElement(key); // Remove the node from its current position
            moveToHead(key, value); // Move it to the head of the list
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (cache.size() == CAPACITY) {
                int removedKey = removeFromEnd();
                cache.remove(removedKey);
            }
            moveToHead(key, value);
            cache.put(key, value);
        } else {
            // Update the value of the existing node
            cache.put(key, value);
            // Move the existing node to the head
            removeElement(key);
            moveToHead(key, value);
        }
    }
}