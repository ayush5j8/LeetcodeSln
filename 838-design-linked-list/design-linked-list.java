class MyLinkedList {
    private LinkNode head, tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        LinkNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.val;
    }
    
    public void addAtHead(int val) {
        LinkNode newNode = new LinkNode(val, null, head);
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        LinkNode newNode = new LinkNode(val, tail, null);
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        LinkNode prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        LinkNode newNode = new LinkNode(val, prev, prev.next);
        prev.next.prev = newNode;
        prev.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            LinkNode prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
            prev.next.prev = prev;
        }
        size--;
    }
}

class LinkNode {
    int val;
    LinkNode prev, next;
    
    LinkNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
    
    LinkNode(int val, LinkNode prev, LinkNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
