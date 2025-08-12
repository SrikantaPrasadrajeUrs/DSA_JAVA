package data_struc_impl.array_list;

class CustomArrayList<T>{
    T[] array;
    int size = 0;
    private static final int DEFAULT_SIZE = 10;

    CustomArrayList(){
        array =(T[]) new Object[DEFAULT_SIZE];
    }

    public T get(int index){
        return array[index];
    }

    private void checkIndex(int index){
        if(index>=size||index<0) throw new ArrayIndexOutOfBoundsException("Index: "+index+" is out of range");
    }


}
