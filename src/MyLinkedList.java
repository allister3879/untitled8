public class MyLinkedList<E> implements List{
    private MyNode head;
    private MyNode tail;
    private int size;
    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    private class MyNode {
        E data;
        MyNode next;
        MyNode prev;
        MyNode(E data, MyNode next, MyNode prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // methods

    @Override
    public void add(Object item) {
        MyNode newNode = new MyNode((E) item, null, tail); // create newnode and assign next as null
        if (tail == null) {  // if tail empty
            head = newNode;  // create new node head
        } else {
            tail.next = newNode; // give link to next node
        }
        tail = newNode;
        size++;  // increase size
    }

    @Override
    public Object getElement(int index) {
        checkIndex(index);
        MyNode current;
        if (index < size / 2) {  // if index before middle node
            current = head;    // current starts from head node
            for (int i = 0; i < index; i++) {
                current = current.next;  // link next node until reaches needed
            }
        } else {  // if index after middle node
            current = tail; // current starts from last node
            for (int i = size - 1; i > index; i--) {
                current = current.prev; // link previous unttil reaches needed
            }
        }
        return current.data; // return the data stored in current node

    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        MyNode current;
        if (index < size / 2) {  // if index before middle node
            current = head;    // current starts from head node
            for (int i = 0; i < index; i++) {
                current = current.next;  // link next node until reaches needed
            }
        } else {  // if index after middle node
            current = tail; // current starts from last node
            for (int i = size - 1; i > index; i--) {
                current = current.prev; // link previous unttil reaches needed
            }
        }
        if (current.prev == null) { // if remove head node
            head = current.next;  // assign next as a new head
        } else {
            current.prev.next = current.next; // else replace current node with next
        }
        if (current.next == null) { // if remove tail node
            tail = current.prev; // assign prev node as a new tail
        } else {
            current.next.prev = current.prev; // replace current node with prev
        }
        size--; // decrease size
        return current.data;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }

    public void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
