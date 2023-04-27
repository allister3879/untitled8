## Method add - arraylist

__Definition__ - implementation of method to add element to array

__Explanation:__  func take item and first of all will check array size, if array full, func increaseBuffer will create new double sized array and copy array elements. anyways size of array increase to 1 and element will add to the end. 

__Solution__ ->

```java
    public void add(Object item) {    // item - element to add
        if (size == arr.length) // array is full
            increaseBuffer();    // method to increase buffer
        arr[size++] = (T) item;
    }
    
    public void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2]; // creates double sized new array
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i]; // copying array
        }
        arr = newArr;
    }
```

---
## Method getElement - arraylist

__Definition__ - implementation of method to get element of array

__Explanation:__  funx take index of element and check if such index exist in array, if not func raise exception. Else return array element at this index

__Solution__ ->

```java
   public T getElement(int index) {
        checkIndex(index); // method to check index
        return arr[index];  // returns element at specified index
    }
    
    public void checkIndex(int index) {
        if (index < 0 || index >= size) { // if array don't contain such index
            throw new IndexOutOfBoundsException();  // raise exception
        }
    }
```

---
## Method remove - arraylist

__Definition__ - implementation of method to remove element from array

__Explanation:__  funx take index of element and check if such index exist in array, if not func raise exception. Else create for loop to work with elements starting from special index and reassign element to previous index

__Solution__ ->

```java
   public T remove(int index) {
        checkIndex(index);  // method to check index
        for (int i = index + 1; i < size; i++) {  // create for loop to work with elements starting from special index
            arr[i - 1] = arr[i];   // reassign element to previous index
        }
        size--;  // decrease size
        return null;
    }
    
    public void checkIndex(int index) {
        if (index < 0 || index >= size) { // if array don't contain such index
            throw new IndexOutOfBoundsException();  // raise exception
        }
    }
```

---
## Method contains - arraylist

__Definition__ - implementation of method to check if array contain such element

__Explanation:__  create counter of object appearance, through the loop check every element of array. If such object exist in array counter will increase to 1. And if counter more than 0, fucc return true, else false.

__Solution__ ->

```java
   public boolean contains(Object o) {
        int counter = 0;  // creat counter of object appearance
        for (int i = 0; i < arr.length; i++)
            if (o.equals(arr[i]))  // if element exist in array
                counter++;  // counter increase
        return counter >= 1;  // return true if counter >= 1, otherwise false
    }
```
## Method clear - arraylist

__Definition__ - implementation of method to clear array

__Explanation:__  func create new empty array. size of array decrease to 0.

__Solution__ ->

```java
    public void clear() {
        this.arr = (T[]) new Object[5]; // create new arr
        this.size = 0; // arr is empty
    }
```
## Method indexOf - arraylist

__Definition__ - implementation of method to return index of object

__Explanation:__  func create variable index. Check from the 0th element of array. If such element exist and index still zero, variable take the value of i - it is the index of first appearance. Else if index more than zero index will keep the same. In the end return variable index.

__Solution__ ->

```java
    public int indexOf(Object o) {
        int index = 0;
        for (int i = 0; i < arr.length; i++)
            if (o.equals(arr[i])) {// if element exist in array
                if (index == 0) {
                    index = i;
                }
            }// index of first object's appearance
        return index;
    }

```
## Method lastIndexOf - arraylist

__Definition__ - implementation of method to find last index of object in array

__Explanation:__  func create new variable to keep index. Check from last element of array. If such element exist and index still zero, variable take the value of i - it is the index of last appearance. Else if index more than zero index will keep the same. In the end return variable index.

__Solution__ ->

```java
    public int lastIndexOf(Object o) {
        int lastIndex = 0;
        for (int i = arr.length-1; i > 0; i--)
            if (o.equals(arr[i]))// if element exist in array
                if(lastIndex == 0) {
                    lastIndex = i;
                }// index of last object's appearance
        return lastIndex;
    }
```
## Method sort - arraylist

__Definition__ - implementation of method to sort array

__Explanation:__  First of all func check if type of array and will sort only if integer. With try and catch func checkIfInteger will try to parse oth element of array, if succesfull return true, if not raise error. After check func create new array arr1 and copy parsed integer value of arr. Then with double loop compare current element with next. and if less swap them with using temp variable.

__Solution__ ->

```java
    public void sort() {
        checkIfInteger(arr[0]);
        int temp = 0;
        int[] arr1 = new int[size];
        for(int i = 0; i<arr1.length; i++){
            T x = getElement(i);
            arr1[i] = Integer.parseInt(String.valueOf(x));
        }

        for (int i = 0; i <arr1.length; i++) {
            for (int j = i+1; j <arr1.length; j++) {
                if(arr1[i] >arr1[j]) {      //swap elements if not in order
                    temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }

        for(int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i]+" ");
        }
    }
    
      public void checkIfInteger(Object o) {
        boolean integer = true;  // create true boolean
        try {
            int x = Integer.parseInt(String.valueOf(o));  // checking if object can be parsed
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Array can not sorted...");  // raise error if not num
            integer = false;
        }
    }
```
