import java.util.HashMap;

class LRUCache {

    private class ListNode {
        private int val, key;
        private ListNode prev;
        private ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        ListNode node = map.get(key);

        if (node == null)
            return -1;

        // small optimization
        if (node != head.next)
            moveToAfterHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            moveToAfterHead(node);
        } else {
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            addAfterHead(newNode);
            if (map.size() > capacity) {
                ListNode lru = removeBeforeTail();
                map.remove(lru.key);
            }
        }
    }

    private void moveToAfterHead(ListNode node) {
        removeNode(node);
        addAfterHead(node);
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addAfterHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }

    private ListNode removeBeforeTail() {
        ListNode lru = tail.prev;
        // That's why I need the key inside the node:
        // to remove before the tail without knowing what was its key beforehand
        removeNode(lru);
        return lru;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */