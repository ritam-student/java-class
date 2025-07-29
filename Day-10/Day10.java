import java.util.*;

class Day10 {
    public static void main(String[] args) {

        /**
        int arr[] = {1,2,3,1,5};
        System.out.println(firstOccurence(arr, 0, 1));
        System.out.println(lastOccurrence(arr, arr.length-1, 1));
        // inbuild sort
        Arrays.sort(arr);   // O(nlogn) 
        
        // ArrayList -> no fixed size
        // create an ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // Integer , int

        // add element in an array
        list.add(1);
        list.add(3);    // O(1)

        // [1,3]
        //get an element arr[0]
        list.get(0); // 1   O(1)

        // remove an element
        list.remove(3);     // O(1)

        // [1]

        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" "); // 1
        }
        System.out.println();


        // check if an element exist or not
        // {1,2,3,4,5,6,7} 
        boolean ans = list.contains(8);     // O(1)

         */

        // print all the elements of an arrayList

        // create an arraylist
        ArrayList<Integer> list = new ArrayList<>();
        // add some values
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (int i=0; i<list.size(); i++) {    // TC : O(N)
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

    }

    // you are given an arrayList , you have to check if the key exist in arrayList ?
    // if not add it and return the index, if already exist return the index
    // ex : {2,3,7,8,9,10} , key = 4 -> {2,3,7,8,9,10,4} -> 6

    // first occurrence of a number [1,2,3,1,5] first occurence of the element 1

    // reverse the elements of an arrayList
    // {2,3,4,5,6} -> {6,5,4,3,2}

    public static void reverseArrayList(ArrayList<Integer> list) {
        int left = 0;
        int right = list.size()-1;

        while(left < right) {
            int temp = list.get(left);
            // arr[left] = arr[right];
            list.set(left , list.get(right));
            list.set(right , temp);

            left++;
            right--;
        }
    }

    // {1,8,6,2,5,4,8,3,7} each value represents the height of a building.
    // you have to findout the max water that gets trapped inside this buildings

    public static int firstOccurence(int arr[] , int i, int key) {
        // base case
        if (i == arr.length) {
            return -1;
        }
        // work at each step
        if(arr[i] == key){
            return i;
        }
        // call smaller instances
        return firstOccurence(arr, i+1, key);
    }


    // last occurrence of a number ex: [1,2,3,1,5] last occurrence of 1 is -> 3
    public static int lastOccurrence(int arr[] , int i, int key) {
        // base case
        if (i < 0) {
            return -1;
        }

        // work each step
        if(arr[i] == key) {
            return i;
        }
        // call for the smaller instances
        return lastOccurrence(arr, i-1, key);
    }
    
    // sorting algorithms
    /**
     * 
     * 1. bubble sort
     * 2. selection sort
     * 3. inbuilt sort
     * 
     */

     /// bubble sort
     /// sort all the elements in ascending order 
     /// [2,3,9,10,1,4] -> [1,2,3,4,9,10]
     /// sort all the light elements left and heavy elements right
    
    public static void bubbleSort(int arr[]){      //  O(n^2)
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length;j++) {
                if(arr[i] > arr[j]){
                    // swap operation
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // selection sort
    public static void selectionSort(int arr[]) {      //  O(n^2)
        for(int i=0; i<arr.length; i++) {
            int min = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }


    // perform selection sort to sort an array in descending order 
    // [2,3,1,9,5] -> [9,5,3,2,1]


    




    
}
