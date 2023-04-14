public class MyArrayList<T> implements List {
    private T[] arr;
    private int size;

    MyArrayList() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public void add(Object item) {    // item - element to add
        if (size == arr.length) // array is full
            increaseBuffer();    // method to increase buffer
        arr[size++] = (T) item;
    }

    @Override
    public T getElement(int index) {
        checkIndex(index); // method to check index
        return arr[index];  // returns element at specified index
    }

    @Override
    public void remove(int index) {
        checkIndex(index);  // method to check index
        for (int i = index + 1; i < size; i++) {  // create for loop to work with elements starting from special index
            arr[i - 1] = arr[i];   // reassign element to previous index
        }
        size--;  // decrease size
    }

    @Override
    public int getSize() {
        return size; // returns size value
    }

    @Override
    public boolean contains(Object o) {
        int counter = 0;  // creat counter of object appearance
        for (int i = 0; i < arr.length; i++)
            if (o.equals(arr[i]))  // if element exist in array
                counter++;  // counter increase
        return counter >= 1;  // return true if counter >= 1, otherwise false
    }

    @Override
    public void clear() {
        this.arr = (T[]) new Object[5]; // create new arr
        this.size = 0; // arr is empty
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (int i = 0; i < arr.length; i++)
            if (o.equals(arr[i]))  // if element exist in array
                if (index > 0)
                    continue;
                else
                    index = i;  // index of first object's appearance
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++)
            if (o.equals(arr[i]))  // if element exist in array
                lastIndex = i;  // index of last object's appearance
        return lastIndex;
    }

    @Override
    public void sort() {
        checkIfInteger(arr[0]);
        double temp = 0;
        double[] array = new double[size];
        for (int i = 0; i < arr.length; i++)
            array[i] = (double) arr[i]; // copying array to double arr

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j-1]) { // check from last element
                    temp = array[j];  // temporary variable to store
                    array[j] = array[j-1];
                    array[j-1] = temp;  // swapping variables
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");  // print sorted array
        }
    }

    public void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2]; // creates double sized new array
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i]; // copying array
        }
        arr = newArr;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) { // if array don't contain such index
            throw new IndexOutOfBoundsException();  // raise exception
        }
    }

    public void checkIfInteger(Object o) {
        boolean integer = true;  // create true boolean
        try {
            double x = Double.parseDouble(String.valueOf(o));  // checking if object can be parsed
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Array can not sorted...");  // raise error if not num
            integer = false;
        }
    }
}