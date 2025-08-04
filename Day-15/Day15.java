
class Day15 {
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        ll.printElements();
        // ll.reverseLL();
        // ll.printElements();
        // System.out.println(ll.isPalindrome());
        // System.out.println(ll.isCycle());

        DoublyLL dll = new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.printElements();
        dll.removeLast();
        dll.printElements();


    }

    static class DoublyLL{
        class Node {
            int data;
            Node next;
            Node prev;
            public Node (int data){
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }

        public static Node head;
            public static Node tail;

            // addFirst
            public void addFirst(int data){
                // 1. create a new node
                Node newNode = new Node(data);

                // 2. check 
                if (head == null){
                    head = tail = newNode;
                    return;
                }

                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }

            public int removeLast(){
                // base case
                if (head == null){
                    System.out.println("LL is empty...");
                    return Integer.MIN_VALUE;
                }

                if (head.next == null){
                    int val = head.data;
                    head = tail = null;
                    return val;
                }
                int val = tail.data;
                tail.prev.next = null;
                Node prev = tail.prev;
                tail.prev = null;
                tail = prev;
                return val;

            }

        public void printElements(){
            Node temp = head;
            System.out.print("null <->");
            while(temp != null){
                System.out.print(temp.data+" <-> ");
                temp = temp.next;
            }
            System.out.print("null");
            System.out.println();
        }
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

        // remove cycle
        public void removeCycle(){
            // 1. detect the cycle
            Node fast = head ;
            Node slow = head;

            boolean isCycle = false;
            while (fast != null && fast.next != null){
                if (fast == slow){
                    isCycle = true;
                    break;
                }
                fast = fast.next.next;
                slow = slow.next;
            }

            if (! isCycle){
                return ;
            }

            // 2. remove the cycle
            slow = head;
            Node prev = fast;

            while (fast != slow){
                prev = fast;
                fast = fast.next;
                slow = slow.next;
            }

            prev.next = null;
        }

        // detect a cycle in LL
        public boolean isCycle(){
            // base case
            if (head == null || head.next == null){
                return false;
            }

            if (head.next == head){
                return true;
            }
            // create 2 var
            Node fast = head;
            Node slow = head;

            // run a loop
            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow){
                    return true;
                }
            }

            return false;
        }

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


        // Reverse LL 
        // 1->2->3->4->null
        // 4->3->2->1->null

        public void reverseLL(){
            // create 3 var
            Node prev = null;
            Node curr = head;
            Node next;

            while (curr != null){
                next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }

            head = prev;
        }

        // check if a LL is palindrome or not ?
        // 1->2->2->1->null   -> true
        // 1->2->2->null   -> false

        public boolean isPalindrome(){
            // 1. find the mid
            Node mid = findMid();

            // 2. reverse the right part
            Node right = reverse(mid.next);
            Node left = head;
            mid.next = null;


            // 3. compare both the elements
            while (left != null && right != null){
                if (left.data != right.data){
                    return false;
                }
                left = left.next;
                right = right.next;
            }

            return true;

        }

        private Node findMid(){
            // slow-fast approach
            Node slow = head;
            Node fast = head.next;

            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        private Node reverse(Node head){
            Node prev = null;
            Node curr = head;
            Node next;

            while (curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }


    }
}
