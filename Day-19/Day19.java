import java.util.*;



class Day19 {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        int ans = q.remove();
        System.out.println(ans);

        Queue<Integer> q1  = new LinkedList<>();
        q1.add(2);
        q1.remove();
        q1.peek();
        


    }

    static class CircularQueue{
        int arr[];
        int size;

        public static int front;
        public static int rear;

        public CircularQueue(int n){
            arr = new int[n];
            size = n;
            front = rear = -1;
        }

        public boolean isEmpty(){   // O(1)
            return rear == -1 && front == -1;
        }

        public void add(int data){      // O(1)
            if (isEmpty()){
                rear = front = 0;
                arr[rear] = data;
                return;
            }
            rear = (rear + 1) % size;

            if (rear == front){
                System.out.println("Queue is Full");
                return;
            }

            arr[rear] = data;
        }

        public int remove(){      // O(1)  
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }

            if (rear == front){
                int val = arr[front];
                rear = front = -1;
                return val;
            }

            int val = arr[front];
            front = (front + 1) % size;
            return val;
        }


        public int peek(){      // O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }

            return arr[rear];
            // return arr[front];
        }

        public int size(){
            if (isEmpty()){
                return 0;
            }

            if (rear == front){
                return 1;
            }else if (front > rear){
                return ;
            }else {

            }


        }
    }

    public static void printElements(Queue q){  // O(n) 
        if (q.isEmpty()){
            System.out.println("queue is empty...");
            return;
        }
        while (! q.isEmpty()){
            System.out.println(q.remove());
        }
    }

    static class Queue{

        public static Stack<Integer> s1 = new Stack<>();
        public static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty(){       // O(1)
            return s1.isEmpty();
        }

        public void add(int data){      // O(n)
            while(! s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while (! s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public int remove(){    // O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }

            return s1.pop();
        }

        public int peekLast(){      // O(n)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }

            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }

            int val = s2.peek();

            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }

            return val;
        }


        public int peekFirst(){     //O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }

            return s1.peek();
        }

        public int size(){      // O(n)
            int size = 0;

            while (!s1.isEmpty()){
                s2.push(s1.pop());
                size++;
            }

            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }

            return size;

        }



    }

    /** 

    static class Queue{
        class Node {
            int data;
            Node next;
            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        public static Node head;
        public static Node tail;


        public Queue(){
            head  = null;
            tail = null;
        }

        public boolean isEmpty(){   // O(1)
            return head == null;
        }

        public void add(int data){      // O(1)
            // 1. create a node
            Node newNode = new Node(data);

            // 2. condition
            if (isEmpty()){
                head = tail  = newNode;
                return;
            }
            tail.next = newNode;
            tail  = newNode;
        }

        public int remove(){        // O(1)
            if (isEmpty()){
                System.out.println("queue is empty...");
                return Integer.MIN_VALUE;
            }

            if (head.next == null){
                int val = head.data;
                head = tail = null;
                return val;
            }

            int val = head.data;
            head = head.next;
            return val;
        }

        public int peek(){      // O(1)
            if (isEmpty()){
                System.out.println("queue is empty...");
                return Integer.MIN_VALUE;
            }

            return tail.data;
        }

        public int size(){      // O(n) 
            int size = 0;
            Node temp = head;

            while (temp != null){
                size++;
                temp = temp.next;
            }

            return size;
        }
    }
    */

    /**
    static class Queue{
        public static int arr[];
        int size;

        public static int front;
        public static int rear;

        public Queue(int n){
            arr = new int[n];
            size = n;
            front = rear = -1;
        }

        public boolean isEmpty(){  //  O(1)
            return rear == -1;
        }

        public boolean isFull(){    // O(1)
            return rear + 1 == size;
        }

        [1,2,3]
        
        // add or enque
        public void add(int data){      // O(1)
            if (isEmpty()){
                rear++;
                arr[rear] = data;
                front = 0;
                return;
            }

            if (isFull()){
                System.out.println("queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }
        // remove or dequeue ,  deque -> double ended queue(deck)
        public int remove(){    // O(n) 
            if (isEmpty()){
                System.out.println("queue is empty...");
                return Integer.MIN_VALUE;
            }

            if (rear == front){
                rear = front = -1;
                return arr[0];
            }

            //  2 3 4
            int val = arr[front];
            for (int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return val;
        }

        public int peek(){      // O(1)
            if (isEmpty()){
                System.out.println("queue is empty...");
                return Integer.MIN_VALUE;
            }

            return arr[rear];
        }

        public int size(){      // O(1)
            if (isEmpty()){
                return 0;
            }

            return rear+1;
        }
    }
    */


}
