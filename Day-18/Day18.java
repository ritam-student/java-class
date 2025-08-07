import java.util.*;


class Day18 {
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(3);
        s.push(2);
        s.push(1);
        s.pop();
        printElements(s);
    }

    // abc -> cba

    public static void reverseStack(Stack s){
        // base case
        if (s.isEmpty()){
            return;
        }

        int val = s.pop();
        reverseStack(s);
        pushBottom(s, val);

    }
    public static void pushBottom(Stack s, int val){
        if (s.isEmpty()){
            s.push(val);return;
        }

        int val1 = s.pop();
        pushBottom(s, val1);
        s.push(val1);
    }

    // "() {} []"
    //  "({}" -> false
    // "({[]})" -> true
    // ({)} -> false
    // ({})

    public static boolean validParenthesis(String str){
        if (str.length() == 0){
            return true;
        }

        Stack<Character> s = new Stack<>();

        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }else {
                if (
                    ch == '(' && s.peek() == ')' ||
                    ch == '{' && s.peek() == '}' ||
                    ch == '[' && s.peek() == ']' 
                ){
                    s.pop();
                }else {
                    return false;
                }
            }
        }

        if (s.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static String reverseString(String str){
        StringBuilder sb = new StringBuilder("");
        Stack<Character> s = new Stack<>();
        
        for (int i=0; i<str.length(); i++){
            s.push(str.charAt(i));
        }
        
        while (! s.isEmpty()){
            sb.append(s.pop());
        }
        
        return sb.toString();
    }
    

    public static  void printElements(Stack s){
        while (! s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    static class Stack{
        class Node {
            int data;
            Node next;

            public Node (int data){
                this.data = data;
                this.next = null;
            }
        }

        public static Node head;
        public static Node tail;

        public void push(int data){
            Node newNode = new Node(data);

            if (head == null){
                head = tail = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public int pop(){
            if (head == null){
                System.out.println("stack underflow...");
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

        public int peek(){
            if (head == null){
                System.out.println("Stack is empty...");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }

        public int size(){
            Node temp = head;

            int size = 0;
            while (temp != null){
                temp = temp.next;
                size++;
            }

            return size;
        }

        public boolean isEmpty(){
            return head == null;
        }
    }

    // Queue 
    
}