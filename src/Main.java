public class Main {
    public static void main(String[] args) {
        MyArrayList a = new MyArrayList();
        MyLinkedList b = new MyLinkedList();
        // test for my array list
        a.add(2);
        a.add(1);
        a.add(3);
        a.add(0); // add
        System.out.println(a.getElement(2)); // print 3
        a.remove(2);
        System.out.println(a.getSize()); // print 3
        System.out.println(a.contains(3)); // print false
        a.add(1);
        System.out.println(a.indexOf(1));  //print 1
        System.out.println(a.lastIndexOf(1)); //print 3
        a.sort();

        System.out.println("\n");
        b.add(5);
        System.out.println(b.getElement(0));
        System.out.println(b.contains(5));
    }
}