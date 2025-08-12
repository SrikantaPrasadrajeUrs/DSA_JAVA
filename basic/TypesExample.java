import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class TypesExample{
    // public
    // static - TypesExample
    // void - return type

    public static void main(String[] args) {
    // Example usage of the types
    String name = "John Doe"; // String() name holds a ref of String object that string object contains name value
    int age = 30;
    double height = 5.9;
    boolean isEmployed = true;
    // 99% oops

    // System className, out System class println(log)
    // println is method , it it defined void println(String s)
    // System.out.println("Name: " + name);
    // System.out.println("Age: " + age);
    // System.out.println("Height: " + height);
    // System.out.println("Employed: " + isEmployed);
    // 
    // array
    int[] n = {1,2,3}; // array of integers
    int[] m = new int[3]; // empty array of size 3 {0,0,0}
    // System.out.println("Array m: " + m.length);
    String[] names = new String[3]; // empty array of size 3 {null,null,null}
    // 3 default:string-null; {null,null,null}
    // assign - storing       0       1      2
    names[0] = "Subbie"; // {"Subbie",null,null} .length 
    // [0] 
    names[1] = "Sri"; // {"Subbie","Sri",null}
    System.out.println(Arrays.toString(names));
    printArray(names);
    // Collection - framework
    // hahaha what food u will eat? oye for mee omg okay.
    // aceess - reading
    int a=0;
    Subbie subbie = new Subbie();
    ArrayList list1 = new ArrayList();
    list1.get(0);
    list1.remove(0);
    list1.add("Subbie");
    list1.add("Sri");
    list1.add(1);
    list1.add(2.5);
    list1.add(true);

}
// Java basic - oops - 
static void printArray(String[] arr){
    System.out.print("{");
    for (String s : arr) {
        System.out.print(s + ", ");
    }
    System.out.print("}");
}

}

class Subbie{
    // sleep
    // eat
    // methods and properties
    public void eat(String food){
        System.out.println("Eating " + food);
    }
    String name;
}

// opps collections - perdined classes
// [] - {} - 0->0->0->0 
// Array List
// Linked List
// stack
// Queue
// HashMap
// HashSet
// TreeMap
// TreeSet

// 