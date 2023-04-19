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
        return null;
    }

    @Override
    public void remove(int index) {

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
}
