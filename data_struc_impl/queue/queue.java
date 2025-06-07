import java.util.Arrays;

/**
 * A dynamic array-based implementation of a Queue with integer elements.
 */
class QueueY{
    static class Queue{
        private int[] arr;
        private int size;
        private int rear = -1;
        private int front = -1;

        Queue(int size){
            if(size<=0) throw new IllegalArgumentException("Size argument exception");
            this.size = size;
            arr = new int[size];
        }

        public boolean isEmpty(){
            return front==-1||front>rear;
        };

        /**
         * Adds an element to the rear of the queue.
         * @param num the integer to add
         */
        public void add(int num){
            if(front<0)front++;
            if(rear==size-1) resize();
            arr[++rear] = num;
        }

        public int peek(){
            if(isEmpty()) throw new RuntimeException("Queue is Empty");
            return arr[front];
        }

        /**
         * Removes and returns the front element of the queue.
         * @return the front element
         * @throws RuntimeException if the queue is empty
         */
        public int poll(){
            if(isEmpty()) throw new RuntimeException("Queue is Empty");
            int first = arr[front++];
            if(front>rear){
                front = -1;
                rear = -1;
                return first;
            }
            for(int i=front;i<=rear;i++){
                arr[i-1] = arr[i];
            }
            --front;
            --rear;
            return first;
        }

        public void printQueue(){

            StringBuilder sb = new StringBuilder("Queue {");
            if(!isEmpty()){
                for(int i=front;i<=rear;i++){
                    sb.append(arr[i]).append(i < rear ? ", " : "");
                }
            }
            sb.append("}");
            System.out.print(sb);
            System.out.println();
        }

        public void resize(){
            int newCap = size*2;
            arr = Arrays.copyOf(arr,newCap);
            size = arr.length;
        }
    }
    public static void main(String[] args){
        Queue queue = new Queue(3);
        System.out.println("Is empty: " + queue.isEmpty()); // true
        queue.add(8);
        queue.add(7);
        queue.add(66);
        queue.printQueue(); // Queue {8, 7, 66}
        System.out.println("Peek: " + queue.peek()); // 8
        System.out.println("Poll: " + queue.poll()); // 8
        queue.printQueue(); // Queue {7, 66}
        queue.add(54);
        queue.add(58); // Triggers resize
        queue.printQueue(); // Queue {7, 66, 54, 58}
        System.out.println("Poll: " + queue.poll()); // 7
        queue.printQueue(); // Queue {66, 54, 58}
        // Test empty queue
        while (!queue.isEmpty()) queue.poll();
        queue.printQueue(); // Queue {}
        try {
            queue.poll();
        } catch (RuntimeException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}