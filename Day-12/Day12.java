import java.util.*;

class Day12 {
    public static void main(String args[]){
        int arr[] = {6,3,5,1,9,7,4};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
        quickSortDescending(arr, 0, arr.length-1);
        printArr(arr);
        int arr1[] = {1,8,6,2,5,4,8,3,7};
        trappingWater(arr1);
    }

    // Divide and conquere
    // 1. Merge sort
    /**
     * 
     * 1. find the mid
     * 2. call for my left part
     * 3. call for my right part
     * 4. merge the array
     * 
     */

    public static void mergeSort(int arr[], int si , int ei) {
        // base case
        if (si >= ei) {
            return;
        }

        // 1. find the mid
        int mid = si + (ei - si) / 2;
        
        // call for smaller instances
        // call for left part
        mergeSort(arr, si, mid);
        // call for right part
        mergeSort(arr, mid+1, ei);

        // work 
        merge(arr, si, mid, ei);
    }


    public static void merge(int arr[] , int si, int mid , int ei) {
        // create a temp array
        int temp[] = new int[ei-si+1];

        // [1,2]  [4,5] -> [1,2,4,5 ]
        // add elements to the temp array in sorted manner
        // left array
        int i = si;
        // right array
        int j = mid+1;
        // temp array
        int k = 0;

        while (i <= mid && j <= ei){
            if (arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // add the remaining left part elements
        while ( i <= mid) {
            temp[k++] = arr[i++];
        }


        // add the remaining right part elements
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy to the main array
        // main array index
        int p = si;
        for (i=0; i<temp.length; i++){
            arr[p] = temp[i];
            p++;
        }

        
    }

    public static void mergeSortDescending(int arr[] , int  si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }

        // find the mid
        int mid = si + (ei-si) / 2;
        // call for the left part
        mergeSortDescending(arr, si, mid);
        // call for the right part
        mergeSortDescending(arr, mid+1, ei);
        // merge 
        mergeDescending(arr, si, mid, ei);
    }


    public static void mergeDescending(int arr[] , int si, int mid, int ei) {
        // create a temp array
        int temp[] = new int[ei-si+1];

        // left part
        int i = si;
        // right part
        int j = mid+1;
        // temp array
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] > arr[j]){
                temp[k] = arr[i];
                i++;
            }else {

                temp[k] = arr[j];
                j++;
            }

            k++;
        }

        // add the remaining left elements 
        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        // add the remaining right elements
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy over main array
        // main array index
        int p = si;
        for (i = 0; i<temp.length; i++) {
            arr[p] = temp[i];
        }
    }

    // 2. quick sort
    /**
     * 1. choose 1 element as a pivot
     * 2. arrange the array and return the pIndex
     * 3. call for the left part
     * 4. call for the right part
     * 
     */
    
    public static void quickSort(int arr[] , int si, int ei){  // O(nlogn) -> worst O(n^2)
        // base case
        if (si >= ei){
            return;
        }

        // last element as pivot -> arr[ei]

        // arrange the array and return the pIndex
        int pIndex = partition(arr, si, ei);

        // call for the left part
        quickSort(arr, si, pIndex-1);
        // call for the right part
        quickSort(arr, pIndex+1, ei);

    }


    public static int partition(int arr[] , int si , int ei){
        // choose the pivot element
        int pivot = arr[ei];

        // index my main array
        int pIndex = si - 1;

        for (int i = si; i<ei; i++) {
            if (arr[i] <= pivot){
                pIndex++;
                // swap -> pIndex and i
                int temp = arr[pIndex];
                arr[pIndex] = arr[i];
                arr[i] = temp;
            }
        }

        pIndex++;
        // swap -> pIndex and ei
        int temp = arr[ei];
        arr[ei] = arr[pIndex];
        arr[pIndex] = temp;

        return pIndex;
    }

    public static void quickSortDescending(int arr[] , int si, int ei) {
        // base case
        if (si >= ei){
            return;
        }

        int pIndex = partitionDescending(arr , si, ei);
        quickSortDescending(arr, si, pIndex-1);
        quickSortDescending(arr, pIndex+1, ei);
    }


    public static int partitionDescending(int arr[] , int si, int ei) {
        int pivot = arr[ei];

        int pIndex = si - 1;

        for (int i= si; i<ei; i++){
            if (arr[i] >= pivot){
                pIndex++;
                // swap -> pIndex and i
                int temp = arr[pIndex];
                arr[pIndex] = arr[i];
                arr[i] = temp;

            }
        }

        pIndex++;
        // swap -> ei and pIndex
        int temp = arr[ei];
        arr[ei] = arr[pIndex];
        arr[pIndex] = temp;

        return pIndex;
    }



    public static void printArr(int arr[]){
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    // {1,8,6,2,5,4,8,3,7} each value represents the height of a building.
    // you have to findout the max water that gets trapped inside this buildings
    public static void trappingWater(int arr[]){
        // tracks all the left max building
        int left[] = new int[arr.length];
        left[0] = 0;

        for (int i=1; i<arr.length; i++){
            left[i] = Math.max(left[i-1] , arr[i]);
        }

        // tracks all the right max building
        int right[] = new int[arr.length];
        right[right.length-1] = 0;

        for (int i=arr.length-1; i>= 0; i--) {
            right[i] = Math.max(right[i+1] , arr[i]);
        }

        int trappedWater = 0;
        for (int i=0; i<arr.length; i++){
            int boundary = Math.min(left[i] , right[i]);
            trappedWater += boundary - arr[i];
        }

        System.out.println(trappedWater);



    }


    /**
     * 
     * search in rotated and sorted array
     * [4,5,6,7,0,1,2] , key = 0; ans = 4
     * divide and conquere + binary search
     * 
     * Hints : 
     *  1. find the mid
     *  2. se < key < mid , mid < key < ee ,  2 more.. 
     * 
     */
}
