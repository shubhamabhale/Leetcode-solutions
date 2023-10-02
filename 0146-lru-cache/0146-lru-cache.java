import java.util.HashMap;

class LRUCache {
    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ListNode head;
    int listSize;
    int capacity;
    HashMap<Integer, Integer> mapper;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        mapper = new HashMap<>();
    }

    // Helper method to remove the last element from the cache
    private void removeLast() {
        if (head == null)
            return;
        
        if (head.next == null) {
            // Only one element in the list
            mapper.remove(head.key);
            head = null;
        } else {
            ListNode ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            mapper.remove(ptr.key);
            ListNode prev = ptr.prev;
            prev.next = null;
            ptr.prev = null;
        }
        listSize--;
    }

    // Helper method to remove a specific key from the list
    private boolean removeFromList(int key) {
        if (head == null)
            return false;

        if (head.key == key) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return true;
        }

        ListNode ptr = head;
        while (ptr != null) {
            if (ptr.key == key) {
                ListNode prev = ptr.prev;
                prev.next = ptr.next;
                if (ptr.next != null) {
                    ptr.next.prev = prev;
                }
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }

    // Helper method to move a node to the front of the list
    private void bringNodeToFront(int key) {
        if (head == null || head.key == key) {
            return;
        }
        removeFromList(key);
        ListNode temp = new ListNode(key, mapper.get(key));
        temp.next = head;
        if (head != null) {
            head.prev = temp;
        }
        head = temp;
    }

public int get(int key) {
    if (mapper.containsKey(key)) {
        bringNodeToFront(key);
        return mapper.get(key);
    } else {
        return -1;
    }
}


   public void put(int key, int value) {
    if (head == null) {
        // Cache is empty, add the first node
        mapper.put(key, value);
        head = new ListNode(key, value);
        listSize++;
    } else if (mapper.containsKey(key)) {
        // Key already exists, update the value and move to the front
        removeFromList(key);
        ListNode temp = new ListNode(key, value);
        temp.next = head;
        if (head != null) {
            head.prev = temp;
        }
        head = temp;
        mapper.put(key, value);
    } else {
        // Cache has space, add a new node to the front
        if (listSize == capacity) {
            // Cache is full, remove the last node
            removeLast();
        }
        mapper.put(key, value);
        listSize++;
        ListNode temp = new ListNode(key, value);
        temp.next = head;
        if (head != null) {
            head.prev = temp;
        }
        head = temp;
    }
}


}
