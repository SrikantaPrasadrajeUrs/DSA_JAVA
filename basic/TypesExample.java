import java.lang.reflect.Array;
import java.util.Arrays;

class TypesExample{
    // public - 
    // static - TypesExample
    // void - return type
    public static void main(String[] args) {
    // Example usage of the types
    String name = "John Doe";
    int age = 30;
    double height = 5.9;
    boolean isEmployed = true;

    // System className, out System class println(log)
    //println is method , it it defined void println(String s)
    // System.out.println("Name: " + name);
    // System.out.println("Age: " + age);
    // System.out.println("Height: " + height);
    // System.out.println("Employed: " + isEmployed);
    
    // array 
    int[] n = {1,2,3}; // array of integers
    int[] m = new int[3]; // empty array of size 3 {0,0,0}
    // System.out.println("Array m: " + m.length);
    String[] names = new String[3]; // empty array of size 3 {null,null,null}
    // 3 default:string-null; {null,null,null}
    // assign - storing       0        1      2
    names[0] = "Subbie"; // {"Subbie",null,null}
    names[1] = "Sri"; // {"Subbie","Sri",null}
    System.out.println(Arrays.toString(names));
    printArray(names);
    // Collection - framework
    // hahaha what food u will eat? oye for mee omg okay.
    //
    // aceess - reading
}

static void printArray(String[] arr){
    System.out.print("{");
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i] + ", ");
    }
    System.out.print("}");
}

}

// Array List
// Linked List
// stack
// Queue