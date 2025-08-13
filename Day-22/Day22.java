import java.util.*;

class Day22 {
    public static void main(String args[]){
        HashMap<String , Integer> map = new HashMap<>();
        // add
        map.put("Tea" , 20);
        map.put("coffee", 30);

        /*
        // read
        map.get("Tea");
        // remove
        map.remove("Tea");
        //  size
        map.size();
        // isExist
        map.containsKey("tea");
        // remove entire map
        map.clear();
        // duplicate entry
        map.put("coffee" , 45);

        LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>(); 

        

        Set<String> set = map.keySet();

        // for-each loop
        for (String key : set){
            System.out.println(key + " : " + map.get(key) );
        }

        int arr[] = {2,2,3,5,4,2,1,2, 3};
        countFreq(arr);
         */

        HashSet<Integer> set = new HashSet<>();
        // add 
        set.add(1);
        set.add(2);
        // remove
        set.remove(1);
        // isExist
        set.contains(1);
        // size
        set.size();
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        TreeSet<Integer> ts = new TreeSet<>();

        for (int key : set){
            System.out.println(key);
        }

        Iterator it = set.iterator();
        while ( it.hasNext()){
            System.out.println(it.hasNext());
        }
    }

    // [1,2,3,2,1,4,5] -> 1,2,3,4,5
    public static void uniqueEle(int arr[]){        // O(n)
        if (arr.length == 1){
            System.out.println(arr[0]);
            return;
        }
        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<arr.length; i++){
            int ele = arr[i];
            if (!set.contains(ele)){
                set.add(ele);
            }
        }

        for (int key : set){
            System.out.print(key+" ");
        }
        System.out.println();
    }

    // [2,2,3,5,4,2,1,2, 3] n = 9 , 3
    public static void countFreq(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<arr.length; i++){
            int ele = arr[i];
            if (map.containsKey(ele)){
                map.put(ele, map.get(ele) + 1);
            }else {
                map.put(ele, 1);
            }
        }

        int n = arr.length;
        Set<Integer> set = map.keySet();

        for (int key : set){
            if (map.get(key) >= n/3){
                System.out.print(key + " ");
            }
        }

    }

    /**
    public static void kthElements(Node root, int k, int cl){
        // base case
        if (root == null){
            return;
        }
        if (cl == k){
            System.out.print(root.data+" ");
            return;
        }

        kthElements(root.left, k, cl+1);
        kthElements(root.right, k, cl+1);
    }

    public static Node lca(Node root , int n1, int n2){
        if (root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node left = lca(root.left , n1 , n2);
        Node right = lca(root.right, n1, n2);

        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }

        return root;
    }

     */
}
