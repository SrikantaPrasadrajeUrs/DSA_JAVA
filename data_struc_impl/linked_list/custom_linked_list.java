

class CustomLinkedList<T>{
    private Node<T> head, tail;
    private int size;

    CustomLinkedList(){
        size = 0;
    }

    private void initFirstNode(Node<T> node){
            head = node;
            tail = head;
    }

    void addLast(T value){
        Node<T> node = new Node<>(value);
        if(size==0){
            initFirstNode(node);
        }else{
            Node<T> t = node;
            tail.next = t;
            t.prev = tail;
            tail = t;
        }
        size++;
    }

    void addFirst(T value){
        Node<T> node = new Node<>(value);
        if(size==0){
            initFirstNode(node);
        }else{
            Node<T> temp = head;
            head = node;
            node.next = temp;
            temp.prev = head;
        }
        size++;
    }

    private T removeHead(){
        T value = head.value;
        head = null;
        tail = null;
        size--;
        return value;
    }

    T removeLast(){
      if(size==0) return null;
      if(size==1) {
          return removeHead();
      }

      Node<T> t = tail.prev;
      T value = tail.value;
      t.next = null;
      tail = t;
      size--;
      return value;
    }

    T removeFirst(){
        if(size==0) return null;
        if(size==1) {
            return removeHead();
        }
        T value = head.value;
        head = head.next;
        head.prev = null;
        size--;
        return value;
    }

    T get(int index){
        Node<T> temp = head;
        for(int i=0;i<=index;i++){
            if(temp==null) return null;
            if(i==index) break;
            temp = temp.next;
        }
        return temp==null?null:temp.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        while(temp!=null){
            sb.append(temp.value);
            if (temp.next != null) sb.append(", ");
            temp = temp.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addFirst(0);
        list.addFirst(8);
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        System.out.println(list.get(1));
    }
}

class Node<T>{
    final T value;
    Node<T> prev;
    Node<T> next;
    Node(T value) {
        this.value = value;
    }
}