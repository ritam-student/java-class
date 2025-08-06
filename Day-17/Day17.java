import java.util.*;

class Day17 {
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(s.pop());
        System.out.println(s.size());
        // printElements(s);
        // System.out.println(s.isEmpty());
        // pushBottom(s, 4);
        // printElements(s);

    }

    public static void printElements(Stack s){
        while (!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
        System.out.println();

    }

    // 1 2 3 4
    public static void pushBottom(Stack s, int data){
        if (s.isEmpty()){
            s.push(data);
            return;
        }
        Stack temp = new Stack();

        System.out.println("inside");

        while (! s.isEmpty()){
            System.out.println("loop 1");
            temp.push(s.pop());
        }

        s.push(data);

        while (! temp.isEmpty()){
            System.out.println("loop 1");
            s.push(temp.pop());
        }

    }

    static class StackLL{
        LinkedList<Integer> ll = new LinkedList<>();

        public void push(int data){
            ll.addFirst(data);
        }

        public boolean isEmpty(){
            return ll.size() == 0;
        }

        public int pop(){
            if (isEmpty()){
                System.out.println("Stack underflow...");
                return Integer.MIN_VALUE;
            }

            int val = ll.removeFirst();
            return val;

        }
    }



    static class Stack{
        public static ArrayList<Integer> list = new ArrayList<>();

        public void push(int data){
            list.add(data);
        }

        public int pop(){
            if (list.size() == 0){
                System.out.println("Stack is empty...");
                return Integer.MIN_VALUE;
            }
            int val = list.get(list.size()-1);
            System.out.println(list.get(list.size()-1));
            list.remove(list.size()-1);
            System.out.println(list.get(list.size()-1));
            return val;
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }

        public int size(){
            return list.size();
        }

        public int peek(){
            if (list.size() == 0){
                System.out.println("Stack is empty...");
                return Integer.MIN_VALUE;
            }
            return list.get(list.size()-1);
        }
    }
}
