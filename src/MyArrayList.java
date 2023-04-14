public class MyArrayList<T> implements List{
    private T[] arr;
    private int size;
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