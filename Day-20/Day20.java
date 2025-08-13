
import java.util.*;


class Day20 {
    public static void main(String args[]){
        /**
        CircularQueue q = new CircularQueue(3);
        q.add(1);
        q.add(2);
        q.add(3);

        
        while (! q.isEmpty()){      // O(n)
            System.out.println(q.remove());
        }

        // deque
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addLast(2);
        System.out.println(dq);
        dq.getLast();
        dq.removeLast();
        dq.removeFirst();
        System.out.println(dq);
         */
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        interLeave(q);
        System.out.println(q);

        // 1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1        // pre order

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // [2,-1,-1]
    static int idx = -1;
    public static Node createTree(int arr[] ){
        idx++;
        if (arr.length == 0){
            return null;
        }
        // base case
        if (arr[idx] == -1){
            return null;
        }

        Node newNode = new Node(arr[idx]);
        newNode.left = createTree(arr);
        newNode.right = createTree(arr);
        return newNode;
    }

    public static void preOrder(Node root){
        if (root == null){
            System.out.print("-1 ");
            return ;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if (root == null){
            System.out.print("-1 ");
            return ;
        }

        
        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if (root == null){
            System.out.print("-1 ");
            return ;
        }

        
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data + " ");
    }

    // "aabccxb" -> a -1 b b b b x
    public static void firstNonRepeating(String str){
        int arr[] = new int[26];        //  frequencies
        Queue<Character> q = new LinkedList<>();

        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            arr[ch - 'a']++;
            q.add(ch);

            while (! q.isEmpty() && arr[q.peek() - 'a'] > 1){
                q.remove();
            }
            
            
            if (q.isEmpty()){
                System.out.println("-1 ");
            }else {
                System.out.println(q.peek());
            }

        }
    }

    // [2,1,1]; "acba" -> a a a c

    // 1 2 3 4 5 6 7 8 -> 1 5 2 6 3 7 4 8
    public static void interLeave(Queue<Integer> q){        // O(n)
        int size = q.size();

        Queue<Integer> temp = new LinkedList<>();

        for (int i=0; i<size / 2; i++){
            temp.add(q.remove());
        }

        while (! temp.isEmpty()){
            q.add(temp.remove());
            q.add(q.remove());
        }

    }

    static class Queue{
        public static Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty(){        // O(1)
            return dq.isEmpty();
        }

        public void add(int data){        // O(1)
            dq.addLast(data);
        }

        public int remove(){        // O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }
            return dq.removeFirst();
        }

        public int peek(){      // O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }
            return dq.getFirst();
        }

        public int size(){      // O(1)
            return dq.size();
        }
    }


    static class Stack{
        public static Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty(){       // O(1)
            return dq.isEmpty();
        }

        public void push(int data){      // O(1)
            dq.addLast(data);
        }

        public int pop(){       // O(1)
            if (isEmpty()){
                System.out.println("Stack is empty...");
                return Integer.MIN_VALUE;
            }
            return dq.removeLast();
        }

        public int peek(){      // O(1)
            if (isEmpty()){
                System.out.println("Stack is empty...");
                return Integer.MIN_VALUE;
            }
            return dq.getLast();
        }


        public int size(){      // O(1)
            return dq.size();
        }
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

        public boolean isEmpty(){
            return rear == -1;
        }


        public boolean isFull(){
            return (rear + 1) % size == front;
        }

        public void add(int data){      // O(1)
            if (isFull()){
                System.out.println("Queue is full...");
                return;
            }

            if (isEmpty()){
                front = rear = 0;
                arr[rear] = data;
                return;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;

        }


        public int remove(){        // O(1)
            if (isEmpty()){
                System.out.println("Queue is Empty...");
                return Integer.MIN_VALUE;
            }

            if (rear == front){
                int val = arr[front];
                front = rear = -1;
                return val;
            }

            int val = arr[front];
            front = (front + 1) % size;
            return val;
        }

        public int peek(){      // O(1)
            if (isEmpty()){
                System.out.println("Queue is Empty...");
                return Integer.MIN_VALUE;
            }
            return arr[front];
        }


        public int size(){      // O(1)
            if (isEmpty()){
                return 0;
            }

            if (isFull()){
                return size;
            }

            if (rear == front){
                return 1;
            }else if (front > rear){
                return size - front + rear + 1;
            }else {
                return rear - front + 1;
            }
        }
    }
}