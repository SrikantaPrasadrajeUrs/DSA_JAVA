import java.util.Arrays;
import java.util.Iterator;

class CustomArrayList<T> implements Iterable<T>{
    private T[] array;
    private int size = 0;
    private int capacity;
    private static final int DEFAULT_SIZE = 10;

    public int length() {
        return size;
    }

    CustomArrayList(){
        array = (T[]) new Object[DEFAULT_SIZE];
        capacity = DEFAULT_SIZE;
    }

    public T get(int index){
        if(checkIndex(index)) return array[index];
        throw new ArrayIndexOutOfBoundsException();
    }

    public void add(T value){
        if(checkCapacity()){
            array[size++] = value;
;        }else{
            ensureCapacity();
            enlargeArray();
            array[size++] = value;
        }
    }

    public void add(T value, boolean shouldCheck){
        System.out.println("size: "+size+" value: "+value);
        if(shouldCheck) array[size++] = value;
        else add(value);
    }

    boolean isEmpty(){
        return size==0;
    }

    boolean contains(Object value){
        for(int i=0;i<size;i++){
            if(array[i].equals(value)) return true;
        }
        return false;
    }

    int indexOf(Object value){
        int index = -1;
        for(int i=0;i<size;i++){
            if(array[i].equals(value)){
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(T val){
        for(int i=size-1;i>=0;i--){
            if(array[i].equals(val)) return i;
        }
        return -1;
    }

    public T set(int index, T value){
        if(checkIndex(index)){
            T oldVal = array[index];
            array[index] = value;
            return oldVal;
        }
        return null;
    }

    public T remove(int index){
        if(!checkIndex(index)) return null;
        T val = array[index];
        if(index==size-1) array[index] = null;
        else{
            shiftLeftFromIndex(index);
        }
        array[--size] = null;
        return val;
    }

    public void delete(int index){
        if(!checkIndex(index)) throw new ArrayIndexOutOfBoundsException();
        shiftLeftFromIndex(index);
        array[--size] = null;
    }

    public boolean remove(T val){
        int index = indexOf(val);
        if(index==-1) return false;
        remove(index);
        return true;
    }

    public void clear(){
        // to avoid memory leaks
        for(int i=0;i<size;i++){
            array[i] = null;
        }
        size = 0;
        capacity = DEFAULT_SIZE;
    }

    public void insertAt(int index, T value){
        if(!checkIndex(index)) throw new ArrayIndexOutOfBoundsException();
        for(int i=size;i>index;i--){
            array[i] = array[i-1];
        }
        array[index] = value;
        size++;
        boolean didCapacityIncrease = ensureCapacity();
        if(didCapacityIncrease)enlargeArray();
    }


    public void trimToSize(){
        if(capacity>size){
            array = Arrays.copyOf(array,size);
            capacity = size;
        }
    }

    public Iterator<T> iterator(){
        return new Iterator<T>() {
            int pointer = -1;
            @Override
            public boolean hasNext() {
                return pointer+1<size;
            }

            @Override
            public T next(){
                try{
                    return array[++pointer];
                } catch (Exception e) {
                    throw new java.util.NoSuchElementException();
                }
            }

            public void remove(){
                if(pointer==-1) throw new IllegalStateException("next() method not called");
                T val = CustomArrayList.this.remove(pointer);
                if(val!=null) pointer--;
            }
        };
    }

    public void addAll(CustomArrayList<T> customArrayList){
        int length = customArrayList.length();
        boolean didCapacityModified = false;
        while(!hasCapacity(size+length-2)){
            didCapacityModified = true;
            System.out.println(capacity);
            ensureCapacity(true);
        }
        if(didCapacityModified)enlargeArray();
        System.arraycopy(customArrayList.array,0,array,size, length);
        size+=length;
    }

    public CustomArrayList<T> subList(int fromIndex, int toIndex){
        if(!checkIndex(fromIndex)) throw new ArrayIndexOutOfBoundsException("Start index out of bounds");
        if(!checkIndex(toIndex)) throw new ArrayIndexOutOfBoundsException("End index out of bounds");
        CustomArrayList<T> subList = new CustomArrayList<>();
        for(int i=fromIndex;i<=toIndex;i++){
            subList.add(array[i]);
        }
        return subList;
    }

    // ---------------- Private -------------------//

    private boolean ensureCapacity(){
        if(size+1>=capacity){
            capacity+=DEFAULT_SIZE;
            return true;
        }
        return false;
    }

    private void ensureCapacity(boolean shouldIncrease){
        if(shouldIncrease)capacity+=DEFAULT_SIZE;
    }

    private boolean checkIndex(int index){
        return index < size && index >= 0;
    }

    private boolean checkCapacity(){
        return size<capacity&&size>=0;
    }

    private boolean hasCapacity(int index){
        return index<capacity;
    }

    private void enlargeArray(){
        array = Arrays.copyOf(array, capacity);
    }

    private void shiftLeftFromIndex(int index){
        for(int i=index;i<size-1;i++){
            array[i]=array[i+1];
        }
    }



    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();

        // ✅ Test add()
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After add: " + list);

        // ✅ Test get()
        System.out.println("Get index 1: " + list.get(1)); // should be 20

        // ✅ Test set()
        System.out.println("Set index 1 to 99, old value: " + list.set(1, 99));
        System.out.println("After set: " + list);

        // ✅ Test insertAt()
        list.insertAt(1, 50);
        System.out.println("After insertAt(1, 50): " + list);

        // ✅ Test remove(index)
        System.out.println("Removed at index 2: " + list.remove(2));
        System.out.println("After remove(index): " + list);
        // ✅ Test remove(value)
        System.out.println("Remove value 99: " + list.remove(Integer.valueOf(99)));
        System.out.println("After remove(value): " + list);
//
//        // ✅ Test contains()
        System.out.println("Contains 50? " + list.contains(50));
        System.out.println("Contains 99? " + list.contains(99));

//        // ✅ Test indexOf()
        System.out.println("IndexOf 30: " + list.indexOf(30));
        System.out.println("IndexOf 50: " + list.indexOf(50));
        // ✅ Test lastIndexOf()
        list.add(10); // duplicate
        list.add(30); // duplicate
        list.add(30);
        System.out.println("LastIndexOf 30: " + list.lastIndexOf(30));

        // ✅ Test isEmpty()
        System.out.println("Is empty? " + list.isEmpty());

        // ✅ Test delete()
        list.delete(0);
        System.out.println("After delete(0): " + list);

        // ✅ Test addAll()
        CustomArrayList<Integer> list2 = new CustomArrayList<>();
        list2.add(111);
        list2.add(222);
        list2.add(333);
        list2.add(444);
        list2.add(555);
        list2.add(666);
        list2.add(777);
        list2.add(888);
        list2.add(999);
        list.addAll(list2);
        System.out.println("After addAll(list2): " + list);

        // Trim to Size
        list.trimToSize();
        System.out.println("After trimToSize: " + list);

        // Sublist
        System.out.println("Sublist from 1 to 5: "+ list.subList(10,13));

        // Iterator
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println("Is empty after iterating? " + !iterator.hasNext()+ " array: "+list );

        // ✅ Test clear()
        list.clear();
        System.out.println("After clear: " + list);
        System.out.println("Is empty after clear? " + list.isEmpty());
    }


    @Override
    public String toString() {
        return "Array: "+Arrays.toString(array)+" Size: "+size;
    }
}
