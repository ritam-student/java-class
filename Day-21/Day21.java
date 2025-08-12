import java.util.*;

class Day21 {
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        levelOrder(root);
        System.out.println(addSum(root));
        System.out.println(diameterOpt(root).dia);
        topView(root);
    }


    static class Info1 {
        Node node;
        int key;
        public Info1(Node node , int key){
            this.node = node;
            this.key = key;
        }
    }

    public static void topView(Node root){
        Queue<Info1> q = new LinkedList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        q.add(new Info1(root , 0));
        q.add(null);

        while (! q.isEmpty()){
            Info1 curr = q.remove();
            if (curr == null){
                if (! q.isEmpty()){
                    q.add(null);
                }
            }else {
                if (! map.containsKey(curr.key)){
                    map.put(curr.key , curr.node.data);
                }
                max = Math.max(max , curr.key);
                min = Math.min(min , curr.key);

                if (curr.node.left != null){
                    q.add(new Info1(curr.node.left , curr.key - 1));
                }

                if (curr.node.right != null){
                    q.add(new Info1(curr.node.right , curr.key + 1));
                }
            }
        }

        for (int i=min; i<= max; i++){
            System.out.print(map.get(i) + " ");
        }
    }

    static class Info{
        int height ;
        int dia;
        public Info(int dia , int height){
            this.dia = dia;
            this.height = height;
        }
    }

    public static Info diameterOpt(Node root){
        if (root == null){
            return new Info(0, 0);
        }

        Info left = diameterOpt(root.left);
        Info right = diameterOpt(root.right);

        int currHeight = Math.max(left.height , right.height) + 1;
        int currDia = left.height + right.height + 1;

        int dia = Math.max(Math.max(left.dia , right.dia) , currDia);
        return new Info(dia , currHeight);
    }


    public static int diameter(Node root){      // O(N^2)
        // base case 
        if (root == null){
            return 0;
        }

        int leftDia = diameter(root.left);
        int leftHeight = height(root.left);
        int rightDia = diameter(root.right);
        int rightHeight = height(root.right);
        int currDia = Math.max(leftHeight , rightHeight) + 1;

        return Math.max(Math.max(leftDia , rightDia ), currDia);
    }

    public static int addSum(Node root){
        if (root == null){
            return 0;
        }

        int left = addSum(root.left);
        int right = addSum(root.right);

        return left + right + root.data;
    }


    public static int count(Node root){
        // base case
        if (root == null){
            return 0;
        }

        int left = count(root.left);
        int right = count(root.right);

        return right + left + 1;
    }


    public static int height(Node root){
        if (root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left , right) + 1;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (! q.isEmpty()){
            Node node = q.remove();

            if (node == null){
                System.out.println();
                if (! q.isEmpty()){
                    q.add(null);
                }

            }else {
                System.out.print(node.data + " ");

                if (node.left != null){
                    q.add(node.left);
                }

                if (node.right != null){
                    q.add(node.right);
                }
            }
        }
    }
}
