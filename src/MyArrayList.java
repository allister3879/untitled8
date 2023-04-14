public class MyArrayList <T> implements List{
    private T[] arr;
    private int size;
    @Override
    public void add(Object item) {
        if(size == arr.length)
            increaseBuffer();
        arr[size++] = (T) item;
    }
    public void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }
}