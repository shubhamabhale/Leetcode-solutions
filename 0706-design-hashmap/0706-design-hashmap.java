import java.util.ArrayList;
import java.util.List;

class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    List<Node> hmap;
    final int CAPACITY;

    public int getHashCode(int key) {
        return key % CAPACITY;
    }

    public MyHashMap() {
        CAPACITY = 2069;
        hmap = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            hmap.add(null); // Initialize each bucket with null
        }
    }

    public void put(int key, int value) {
        int hcode = getHashCode(key);
        Node head = hmap.get(hcode);
        Node newNode = new Node(key, value);
        if (head == null) {
            hmap.set(hcode, newNode); // No collision, just insert the node
            return;
        }
        Node prev = null;
        while (head != null) {
            if (head.key == key) {
                head.val = value; // Update value if key already exists
                return;
            }
            prev = head;
            head = head.next;
        }
        prev.next = newNode; // Add new node at the end of the linked list in the bucket
    }

    public int get(int key) {
        int hcode = getHashCode(key);
        Node head = hmap.get(hcode);
        while (head != null) {
            if (head.key == key) {
                return head.val; // Return value if key found
            }
            head = head.next;
        }
        return -1; // Key not found
    }

    public void remove(int key) {
        int hcode = getHashCode(key);
        Node head = hmap.get(hcode);
        if (head == null)
            return; // No node in this bucket
        if (head.key == key) {
            hmap.set(hcode, head.next); // Update head if it's the node to be removed
            return;
        }
        Node prev = head;
        head = head.next;
        while (head != null) {
            if (head.key == key) {
                prev.next = head.next; // Remove the node
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}
