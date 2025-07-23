

public class Day5 {
    public static void main(String[] args) {
        // {1,2,3} -> 1,2,3,12,13,23,123
        int arr[] = {1,2,3, 4,5};
        printAllSubarrays(arr);
        int idx = binarySearch(arr, 5);
        System.out.println(idx);
    }

    public static void printAllSubarrays(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                for (int k=i; k<= j; k++){
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    public static int binarySearch(int arr[], int element) {
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == element) {
                return mid;
            }else if(arr[mid] > element){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return -1;
    }
}
