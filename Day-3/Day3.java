class Day3 {
    public static void main(String[] args) {
        boolean isPrime =  isPrime(8);
        System.out.println(isPrime);
        System.out.println(reverseNumber(1234));

        // Array

        int phy = 90;   // 1120
        int chem = 80;  // 1300
        // dataTypes name[] = new dataTypes[Size];
        int array[] = new int[100];
        // indices
        array[0] = 90;
        System.out.println(array[0]);
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(arr[9]);

        // print all elements of an array

        // length()
        int size = arr.length;
        printElements(arr);
        int n = 5;
        console(arr);
        System.out.println(arr[0]); // 100
        boolean ans1 = isFound(arr);
        System.out.println(ans1);
        
        /**
         * dry run 
         * 
         * 1,2,3,4,5,6,7,8,9,10
         * 
         *  i = 10
         * output : 1 2 3 4 5 6 7 8 9 10 
         */


        /**
         * int arr[] = new int [10];
         * arr[0]= 1;arr[1] = 2;
         */


    }

    public static boolean isFound(int arr[]) {
        for (int i =0; i < arr.length; i++) {
            if (arr[i] == 70) {
                return true;
            }
        }
        return false;
    }

    public static void console(int arr[]) {
        arr[0] = 100;
        System.out.println(arr[0]); // 100
    }

    public static void printElements(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static boolean isPrime (int n) {
        if (n == 1 || n < 1) {
            return false;
        }
        for (int i =2; i <= n/2; i++) {
            if (n % i ==0) {
                return false;
            }
        }
        return true;
    }

    // 12 % 10
    /*
    int ans = 2 * 10 + 1
     * 
     * 12 -> 12 % 10 = 2
     * number = number / 10 = 1
     * number % 10  = 1
     * number = number / 10 = 0
     */

    public static int reverseNumber (int number) {
        int ans = 0;
        while (number > 0) {
            int remainder = number % 10;
            ans = ans * 10 + remainder;
            number = number / 10;
        }
        return ans;
    }
}
