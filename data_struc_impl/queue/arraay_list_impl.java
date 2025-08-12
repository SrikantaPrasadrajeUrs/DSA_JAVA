import java.util.Arrays;

class CustomArrayList<T>{
    T[] array;
    int size = 0;
    int capacity;
    private static final int DEFAULT_SIZE = 10;

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

    public static void main(String[] args){
        CustomArrayList<Integer> arrayList = new CustomArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);
        arrayList.add(60);
        arrayList.add(70);
        arrayList.add(80);
        arrayList.add(90);
        arrayList.add(100);
        arrayList.add(11);
        arrayList.delete(10);
        System.out.print(arrayList);
    }

    @Override
    public String toString() {
        return "Array: "+Arrays.toString(array)+" Size: "+size;
    }
}
