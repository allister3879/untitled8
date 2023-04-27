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
---
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
---
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
---
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
---
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
---
## Method add - linkedlist

__Definition__ - implementation of method add

__Explanation:__  func create new node. if tail empty assign newnode as head, else assign as next node. increase size to one.

__Solution__ ->

```java
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
```
---
## Method  gerElement - linkedlist

__Definition__ - implementation of method to get element of linked list

__Explanation:__  First of all func check if such index exist. Then if index before middle node current node will start from head of list.With loop reach needed element and return. Else if index after middle node, current node starts from tail.With decrement loop reach needed element and return.

__Solution__ ->

```java
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
                current = current.prev; // link previous until reaches needed
            }
        }
        return current.data; // return the data stored in current node

    }
    
    public void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
```
---
## Method  remove - linkedlist

__Definition__ - implementation of method to remove element from list

__Explanation:__  Func check if such index exist. If index before middle node assign current as head. With loop current will equal to next node until reach needed node. Same if current node starts with tail. After founding current node, if prev node does not exist, that means removing head node and func assign next node as new head. Else replace current node with next node. If next node does not exist, that means removing tail node and assign prev node as new tail. Else replace current node with prev. at the end decrease size to 1.

__Solution__ ->

```java
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

```
---
## Method  contains - linkedlist

__Definition__ - implementation of method check if list contain such object

__Explanation:__  func will check every element of list from the head. If object equals with current node data return true, else false.

__Solution__ ->

```java
    public boolean contains(Object o) {
        MyNode current = head;  // start with head
        while (current != null) {  // until the end
            if (o.equals(current.data)) { // if object equals the data returns true
                return true;
            }
            current = current.next;  // else current equals to next node and check again
        }
        return false;
    }
```
---
## Method  clear - linkedlist

__Definition__ - implementation of method to clear list 

__Explanation:__  func start from head node and assign every node values to null. At the end size will equal to 0.

__Solution__ ->

```java
    public void clear() {
        MyNode current = head; // start from head
        while (current != null) {  // until the end node
            MyNode next = current.next; // variable to keep next node
            current.data = null;
            current.next = null;
            current.prev = null; // assign every value to the null
            current = next; // next value turn into current
        }
        head = null;
        tail = null;
        size = 0; // size equal to zero

    }

```
---
## Method indexOf - linkedlist

__Definition__ - implementation of method find index of object

__Explanation:__  func create variable to store index of object. Stars from head node and check if object will equal to current node data and return index. Else index will increase to 1. Func return -1 if such object does not exist in list.

__Solution__ ->

```java
    public int indexOf(Object o) {
        int index = 0; // create variable to store index of object
        MyNode current = head;
        while (current != null) {  // while loop to check every node
            if (o.equals(current.data)) {
                return index;  // if find such data return index
            }
            index++; // else index will increase to 1 while checking every node
            current = current.next;  // next node turn into current
        }
        return -1; // return -1 if such data doesn't exist

    }
```
---
## Method  lastIndexOf- linkedlist

__Definition__ - implementation of method to find last index of object in list

__Explanation:__  func give to index value of size-1. Current node stsrt from tail. With while loop check if current node  data equal to object and return index. Else index will decrease to 1 and prev node turn into current. If such objectt dies nit exist i list func reuturn -1.

__Solution__ ->

```java
    public int lastIndexOf(Object o) {
        int index = size - 1; // index of tail
        MyNode current = tail;
        while (current != null) {  // while loop to check from tail to head
            if (o.equals(current.data)) {
                return index;  // if equals return index
            }
            index--;  // else index decrease
            current = current.prev; // prev node turn into current
        }
        return -1; // return -1 if such data doesn't exist

    }

```
---
## Method  sort - linkedlist

__Definition__ - implementation of method to sort linked list

__Explanation:__  If size of list less than 2 func return. Current node assign as head of list. Create variables to keep int values of data to compare. If next node data more than current swap values(sorting in descending order). With while loop print them in ascending order

__Solution__ ->

```java
    public void sort() {
        if (size <= 1) {
            return;
        } // return if less than 2 elements
        MyNode current = head;
        for (int i = 0; i <size; i++) {
            for (int j = i+1; j <size; j++) {
                int n1 = Integer.parseInt(String.valueOf(current.data));  // variables to store int value
                int n2 = Integer.parseInt(String.valueOf(current.next.data));
                if(n1 < n2) {      // compare int values
                    E temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp; // swap using  temp value
                }
            }
        }

        MyNode current1 = tail;
        while (current1 != null){
            System.out.print(current1.data+" ");
            current1 = current1.prev;  // print in ascending order
        }

    }
```
---
