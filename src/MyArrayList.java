public class MyArrayList<T> implements List{
    private T[] arr;
    private int size;
    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    @Override
    public void add(Object item) {    // item - element to add
        if(size == arr.length) // array is full
            increaseBuffer();    // method to increase buffer
        arr[size++] = (T) item;
    }

    @Override
    public T  getElement(int index) {
        checkIndex(index); // method to check index
        return arr[index];  // returns element at specified index
    }

    @Override
    public void remove(int index) {
        checkIndex(index);  // method to check index
        for(int i= index + 1; i<size; i++){  // create for loop to work with elements starting from special index
            arr[i-1] = arr[i];   // reassign element to previous index
        }
        size--;  // decrease size
    }

    @Override
    public int getSize() {
        return size; // returns size value
    }

    public void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2]; // creates double sized new array
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i]; // copying array
        }
        arr = newArr;
    }
    public void checkIndex(int index){
        if(index < 0 || index>=size){ // if array don't contain such index
            throw new IndexOutOfBoundsException();  // raise exception
        }
    }
}