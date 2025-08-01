class Day13 {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        System.out.println(searchInRotatedSortedArray(arr, 0, 0, arr.length-1));
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

    public static int searchInRotatedSortedArray(int arr[] , int key, int si, int ei){
        // base case
        if (si > ei){
            return -1;
        }

        // find the mid
        int mid = si + (ei - si) / 2;

        if (arr[mid] == key){
            return mid;
        }

        // mid lies on s1
        if (arr[si] <= arr[mid]){
            // check in the left
            if (arr[si] <= key && key < arr[mid]){
                // call for the left part of s1
                return searchInRotatedSortedArray(arr, key, si, mid-1);
            }// call for the right part
            else {
                return searchInRotatedSortedArray(arr, key, mid+1, ei);
            }
        }// key in the s2
        else {
            // check for the right part of s2
            if (arr[mid] < key && key <= arr[ei]){
                // call for the right part
                return searchInRotatedSortedArray(arr, key, mid+1, ei);
            }// call for the left part
            else {
                return searchInRotatedSortedArray(arr, key, si, mid-1);
            }
        }
    }
}
