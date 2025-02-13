class MyLinkedList {
    private LinkNode head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        LinkNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }
    
    public void addAtHead(int val) {
        head = new LinkNode(val, head);
        size++;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        LinkNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new LinkNode(val);
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        LinkNode prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        prev.next = new LinkNode(val, prev.next);
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
        } else {
            LinkNode prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
        size--;
    }
}

class LinkNode {
    int val;
    LinkNode next;
    
    LinkNode(int val) {
        this.val = val;
        this.next = null;
    }
    
    LinkNode(int val, LinkNode next) {
        this.val = val;
        this.next = next;
    }
}
