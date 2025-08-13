import java.util.Arrays;

class CustomArrayList<T>{
    T[] array;
    int size = 0;
    int capacity;
    private static final int DEFAULT_SIZE = 10;

    public int length() {
        return size+1;
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
        if(checkIndex(size)){
            array[size] = value;
            size++;
;        }else{
            ensureCapacity();
            array = Arrays.copyOf(array, capacity);
            array[size++] = value;
        }
    }

    public void clear(){
        array = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
        capacity = DEFAULT_SIZE;
    }

    public void insertAt(int index, T value){
        if(!checkIndex(index)) throw new ArrayIndexOutOfBoundsException();
        array[index] = value;
    }

    public void delete(int index){
       if(!checkIndex(index)) throw new ArrayIndexOutOfBoundsException();
       for(int i=index;i< array.length-1;i++){
           array[i] = array[i+1];
       }
       size--;
    }

    private void ensureCapacity(){
        if(size+1>=capacity)capacity+=DEFAULT_SIZE;
    }

    private boolean checkIndex(int index){
        return index < capacity && index >= 0;
    }

    public void addAll(CustomArrayList<T> customArrayList){
         int length = customArrayList.length();

    }

    public static void main(String[] args){
        CustomArrayList<Integer> arrayList = new CustomArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
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
        arrayList.clear();
        System.out.println(arrayList);
    }

    @Override
    public String toString() {
        return "Array: "+Arrays.toString(array)+" Size: "+size;
    }
}
