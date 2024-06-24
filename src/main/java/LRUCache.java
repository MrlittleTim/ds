import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tim
 * @date 2024/6/19
 */

class LRUCache {
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> cache = new HashMap<>();

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }


    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() == capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
            }
            node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeTail() {
        Node node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node;
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}