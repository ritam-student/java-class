class Day14 {
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.printElements();
        // arr.length
        // str.length()
        System.out.println(ll.size());
        
    }

    static class LinkedList{
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
        public static int size;

        public void addFirst(int data){
            // 1. create a new node
            Node newNode = new Node(data);

            // check if LL is empty ?
            if (head == null){
                // LL is empty
                head = tail = newNode;
                size++;
                return;
            }

            // 2. newNode points towards prev head
            newNode.next = head;
            // 3. update the head
            head  = newNode;

            size++;

        }


        public void addLast(int data){
            // 1. create a new node
            Node newNode = new Node(data);

            // check if LL is empty ?
            if (head == null){
                // LL is empty
                head = tail = newNode;
                size++;
                return;
            }

            // 2. last node points towards new node
            tail.next = newNode;

            // 3. update the tail
            tail = newNode;

            size++;
        }


        public void printElements(){
            Node temp = head;

            while (temp != null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.print("null");
            System.out.println();
        }

        public void addMiddle(int idx, int data){
            if (idx == 0){
                // call addFirst
                addFirst(data);
                return;
            }

            // 1. create a new Node
            Node newNode = new Node(data);

            // 2. find the prev node
            int i = 0;
            Node prev = head;
            while (i < idx){
                prev = prev.next;
                i++;
            }

            // 3. newNode next = prev.next
            newNode.next = prev.next;

            // 4. update the prev.next
            prev.next = newNode;

            size++;

        }

        public int size(){
            int size = 0;

            // traverse through all the nodes
            Node temp = head;

            while (temp != null){
                size++;
                temp = temp.next;
            }

            return size;
        }


        public int removeFirst(){
            // if LL is empty
            if (head == null){
                System.out.println("LL is empty...");
                return Integer.MIN_VALUE;
            }

            // if there is 1 node only
            if (head.next == null){
                int data = head.data;
                head = tail = null;
                size = 0;
                return data;
            }

            int temp = head.data;
            // 1. head updated
            head = head.next;

            size--;

            return temp;
        }

        public int removeLast(){
            Node temp = head;

            // if LL is empty
            if (head == null){
                System.out.println("LL is empty....");
                return Integer.MIN_VALUE;
            }

            if (head.next == null){
                int data = head.data;
                head = tail = null;
                size = 0;
                return data;
            }

            while (temp.next.next != null){
                temp = temp.next;
            }

            int data = temp.next.data;

            // update temp next
            temp.next = null;
            tail = temp;

            size--;

            return data;
        }


        public int iterativeSearch(int key){
            Node temp = head;
            int idx = 0;

            if (head == null){
                System.out.println("LL is empty...");
                return -1;
            }

            while (temp != null){
                if (temp.data == key){
                    return idx;
                }
                idx++;
                temp = temp.next;
            }

            return -1;
        }
        // 1-> 2 -> 3 -> 5 -> null , key = 5    ans = 3
        // 1-> 2 -> 3 -> 5 -> null , key = 10   ans -1
        public int recursiveSearch(int key){
            return recursiveSearchHelper(key , head);
        }

        public int recursiveSearchHelper(int key, Node currNode){
            // base case
            if (currNode == null){
                return -1;
            }

            if (currNode.data == key){
                return 0;
            }

            int val = recursiveSearchHelper(key, currNode.next);

            if (val != -1){
                return val+1;
            }
            return val;
        }
    }
}
