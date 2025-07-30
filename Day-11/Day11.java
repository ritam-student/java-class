

class Day11 {
    public static void main(String[] args) {
        int arr[] = {3,4,5,2,7,7,3,1};
        // insertionSort(arr);
        // printArr(arr);
    }

    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 1. Bubble sort
    public static void bubbleSort(int arr[]) {      // O(N^2)
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j <arr.length-i-1; j++ ){
                if (arr[j] > arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSortDescending(int arr[]) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j] < arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    // 2. selection sort
    public static void selectionSort(int arr[]) {
        for (int i=0; i<arr.length-1; i++) {
            int min = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void selectionSortDescending(int arr[]) {
        for (int i=0; i<arr.length-1; i++) {
            int max = i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[max] < arr[j]){
                    max = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

        }
    }


    // 3. insertion sort
    // [5,2,1,7,6] 

    public static void insertionSort(int arr[]) {   //O(N^2)
        for (int i=1; i<arr.length; i++) {
            int j = i-1;
            while(j >= 0) {
                if (arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                    j--;
                }else {
                    break;
                }
            }
        }
    }


    public static void insertionSortDescending(int arr[]) {
        for (int i=1; i<arr.length; i++) {
            int j = i-1;
            while (j >= 0) {
                if (arr[j] < arr[j+1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    j--;
                }else {
                    break;
                }
            }
        }
    }



    // 4. Counting sort
    // [3,4,5,2,7,7,3,1]
    /**
     * 
     * 1. find the largest +ve integer in array , max = (7)
     * 2. create an array of size max+1 , int count[] = new int [max+1];
     * 3. count the frequencies of the elements in the main array
     *  count = [0, 0, 0, 0, 0, 0, 0, 0 ]
     * 4. replace the main array with the elements until it's count > 0
     *  [1,2,3,3,4,5,7,7]
     * 
     */

    public static void countingSort(int arr[]) {
        // find the max value in array
        int max = Integer.MIN_VALUE; 
        for (int i=0; i<arr.length; i++) {      // O(N)  
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // create an array of max+1 size
        int count[] = new int[max+1];

        // count the frequencies
        for (int i=0; i<arr.length; i++) {      // O(N)
            count[arr[i]]++;
        }

        // replace the main array with the elements until it's count > 0
        int j = 0;  // points to the main array index
        for (int i=0; i<count.length; i++) {
            while (count[i] > 0){
                arr[j] = i;
                count[i]--;
                j++;
            }
        }
    }


    
        // divide and conquere -> recursion
        // 1. merge sort
        // 2. quick sort

        // merge sort
        /**
         * 1. divide the array
         * 2. call for small problems
         * 3. conquere -> sort
         */

        public static void mergeSort(int arr[] , int si , int ei) {     // O(nlogn)
            // find the mid
            int mid = si + (ei - si) / 2;

            // call for left part
            mergeSort(arr, si, mid);
            // call for right part
            mergeSort(arr, mid+1, ei);
            
            // merge both of them
            merge(arr , si , mid , ei);
        }

    public static void merge(int arr[] , int si , int mid , int ei) {
        // create a temp array
        int temp[] = new int[ei-si+1];

        // create a variable that points towards left part
        int i = si;
        // create a variable that points towards right part
        int j = mid+1;

        // create a variable that points towards temp array
        int k = 0;

        while (i <= mid && j <= ei){
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }

            k++;
        }

        // remaining elements in my left part
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        // remaining elements in my right part
        while (j <= ei) {
            temp[k] = arr[j];
            k++;
            j++;
        }


        // copy to the main array
        for (int p=0; p<temp.length; p++) {
            arr[p] = temp[p];
        }



    }



}
