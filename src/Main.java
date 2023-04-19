public class Main {
    public static void main(String[] args) {
        MyArrayList a = new MyArrayList();
        MyLinkedList b = new MyLinkedList();
        // test for my array list
        a.add(0);
        a.add(1);
        a.add(2);
        System.out.println("Array element with index 1: "+ a.getElement(1));
        System.out.println("Size of current array: "+a.getSize());
        System.out.println("Array contain '3': "+a.contains(3));
        System.out.println("Array contain '1': "+a.contains(1));
        System.out.println("Index of '0': "+a.indexOf(0));
        a.add(0);
        System.out.println("Last index of '0': "+a.lastIndexOf(0));
        a.remove(a.lastIndexOf(0));
        a.sort();
        a.clear();

        System.out.println("\n");
    }
}