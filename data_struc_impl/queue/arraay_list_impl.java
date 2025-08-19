import java.util.Arrays;

class CustomArrayList<T>{
    T[] array;
    int size = 0;
    int capacity;
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

    void enlargeArray(){
        array = Arrays.copyOf(array, capacity);
//        System.out.println("size increased, "+Arrays.toString(array));
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

    public void clear(){
        // to avoid memory leaks
        for(int i=0;i<size;i++){
            array[i] = null;
        }
        array = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
        capacity = DEFAULT_SIZE;
    }

    public void insertAt(int index, T value){
        if(!checkIndex(index)) throw new ArrayIndexOutOfBoundsException();
        for(int i=index;i<size-1;i++){
            array[i+1] = array[i];
        }
        array[index] = value;
    }

    public void delete(int index){
       if(!checkIndex(index)) throw new ArrayIndexOutOfBoundsException();
       for(int i=index;i< size-1;i++){
           array[i] = array[i+1];
       }
       array[--size] = null;
    }

    private void ensureCapacity(){
        if(size+1>=capacity)capacity+=DEFAULT_SIZE;
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

    public void addAll(CustomArrayList<T> customArrayList){
         int length = customArrayList.length()-1;
         boolean didCapacityModified = false;
        while(!checkIndex(size+length)){
            didCapacityModified = true;
            System.out.println(capacity);
            ensureCapacity(true);
        }
        if(didCapacityModified)enlargeArray();
        for(int i=0;i<length;i++){
            add(customArrayList.array[i],true);
        }
    }

    public static void main(String[] args){
        CustomArrayList<Integer> arrayList = new CustomArrayList<>();
        CustomArrayList<Integer> arrayList2 = new CustomArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
//        arrayList.clear();
        arrayList.add(40);
        arrayList.add(50);
        arrayList.add(60);
        arrayList.insertAt(0,70);
        arrayList.add(80);
        arrayList.add(90);
        arrayList.add(100);
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.delete(10);
        System.out.println(arrayList);
        System.out.println(arrayList.get(0));
        arrayList2.add(10);
        arrayList2.add(44);
        arrayList2.add(80);
        arrayList2.add(90);
        arrayList2.add(100);
        arrayList2.add(11);
        arrayList.add(12);
        arrayList2.addAll(arrayList2);
        System.out.println(arrayList);
    }

    @Override
    public String toString() {
        return "Array: "+Arrays.toString(array)+" Size: "+size;
    }
}
