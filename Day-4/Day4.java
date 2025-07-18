class Day4{
    public static void main(String[] args) {
        /**q1 : find the largest element of an array */


        /**
         * 
         * 1. create an array
         * 2. int largest = -infinity
         * 3. iterate over the array
         * 4. return largest
         */

        int arr[] = {3,4,99,0,-10};
        System.out.println(largestElement(arr));
        reverseArray(arr);
        printElements(arr);
        /**
         * {1,2,3,4,5} -> {5,4,3,2,1}
         */

        // subarray
        /**
         * 
         * {1,2,3,4,5} -> 1, 12 , 13, 14,15, 123, 124, 125, 134, 135, 1234, 1235, 1345, 12345
         */
    }

    public static void printElements(int arr[]) {
        for (int i=0; i< arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int largestElement(int arr[]) {
        int largest = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void reverseArray(int arr[]) {
        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            // swap
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            right--;
            left++;
        }
    }
}