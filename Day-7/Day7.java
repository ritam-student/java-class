

class Day7 {
    public static void main(String[] args) {
        int arr[][] = {
            {2, 3, 4, 5},   // row 0
            {6, 7, 8, 9},   /// row 1
            {10, 11, 12, 13}    // row 2
        };
        findKey(arr, 6);

        spiralMatrix(arr);

        /**
         * 
         *  10 20 30 40
            15 25 35 45
            27 29 37 48
            32 33 39 50
         * 
         * 
         */

        int arr1 [][] = {
            {10, 20, 30, 40},
            {15 ,25 ,35 ,45},
            {27 ,29 ,37 ,48},
            {32 ,33 ,39 ,50}
        };

        searchInSortedMatrix(arr1, 72);
    }

    /**
     * 
     * search a key inside a 2D array
     * 
     * 2 3 4 5
     * 6 7 8 9
     * 10 11 12 13
     * 
     * search for key = 6
     * 
     * ans = (1,0)
     */

    public static void findKey(int arr[][] , int key ) {
        boolean isFound = false;
        for (int row = 0; row<arr.length; row++) {
            for (int column = 0; column <arr[0].length; column++ ){
                if(arr[row][column] == key) {
                    System.out.println("Element is at : row =" + row + " column =" + column);
                    isFound = true;
                }
            }
        }

        if(!isFound){
            System.out.println("Number not found...");
        }
    }


    /**
     * spiral matrix
     * 
     * 
     * 2  3  4  5
     * 6  7  8  9
     * 10 11 12 13
     * 
     * 
     * print all the elements of this matrix in spiral format
     * 
     * ans -> 2 3 4 5 9 13 12 11 10 6 7 8  
     * 
     */

    public static void spiralMatrix(int arr[][]){
        // step 1 : initialize 4 variables
        int sr = 0; int sc = 0;
        int er = arr.length-1;  int ec = arr[0].length-1;

        // step 2 : run loop
        while (sr <= er && sc <= ec) {
            // print top row
            for(int col = sc; col <=ec; col++ ){
                System.out.print(arr[sr][col] + " ");
            }

            // print last column
            for (int row=sr+1; row <= er; row++){
                System.out.print(arr[row][ec] + " ");
            }

            // print last row
            for (int col = ec-1; col >= 0; col--){
                System.out.print(arr[er][col] + " ");
            }

            // print 1st column
            for (int row = er -1; row > sr; row--){
                System.out.print(arr[row][sc] + " ");
            }

            sr++ ; sc++;
            er--;  ec--;

        }
    }


    /***
     * 
     * Search in sorted matrix
     * 
     * 10 20 30 40
     * 15 25 35 45
     * 27 29 37 48
     * 32 33 39 50
     * 
     * key = 39
     * 
     * row = 3
     * col = 2
     * 
     */

    public static void searchInSortedMatrix(int arr[][] , int key ){
        // step 1 : initialize 2 variables
        int row = 0; int col = arr[0].length-1;
        boolean isFound = false;

        // step 2 : iteration
        while(row  < arr.length && col >= 0) {
            if (arr[row][col] == key ) {
                System.out.println("Element is at row : " + row + " column : " + col);
                isFound = true;
                return;
            }else if (arr[row][col] > key){
                // move left
                col--;
            }else {
                row++;
            }
        }

        if (! isFound){
            System.out.println("Number is not there ...");
        }
    }

    /**
     * Find the displacement
     * 
     * WWWSSNNNNEEEENS
     * 0,0
     * 
     * E
     * N
     * S
     * W
     * NSE
     * WENS
     * 
     * 
     * 
     */
}
