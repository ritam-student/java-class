
import java.lang.reflect.Array;



class Day6 {
    public static void main(String[] args) {
        /**
        // 2D array

        // declair a 2D array
        int arr2[][] = new int [4][3];

        // update / read the value 
        System.out.println(arr2[2][1]);     // 0  

        // iterate over a 2D array
        for(int i=0; i<arr2.length; i++) {  // iterates over row
            for (int j=0; j<arr2[0].length; j++){
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
         

        // String
        // create a string
        String var1 = "abc";
        String var2 = "abc";
        String str = new String("abc");

        // check var1 == str ?
        System.out.println(var2 == var1);   // true
        System.out.println(str == var1);    // false

        // iterate over a staring
        // abc -> a b c
        int n = str.length();

        for (int i=0; i<n; i++) {
            // arr[i]
            System.out.print(str.charAt(i)+ " ");
        }
        System.out.println();

        */

        /// q1 : find total number of 'a' are there in your string
        /// abcabcva -> 3
        System.out.println(findA("abcabcva"));

        // q2 : ["Mango" , "banana" , "jackfruit" ];  
        /// 1. create an array of string -> String name [] = {"Mango" , "Banana" , "Apple"};
        /// 2. create a function whose return type is String
        /// 3. create a variable of type string the store the ans -> name[0];
        /// 4. iterate over eacr index of your array and compare and find the largest string
        /// 5. return ans
        
        // how to convert a string into upper case -> abc -> ABC
        System.out.println("ABC".toLowerCase());
        System.out.println("ABC".toUpperCase());

        /// updation of a string
        /// str = "abc" -> str = "my name"
        
        String str = new String("abc");
        str = "my name";
        System.out.println(str);

        /// StringBuilder
        /// create a stringBuilder
        StringBuilder sb = new StringBuilder("abc");

        for (int i=0; i<10; i++) {
            str = str + 'a';
        }
        System.out.println(sb);
        
        /// q3. you are given a string , add a character 'p' n times after the original 
        /// String . where n is total number of repeated character .
        /// "abcvbds" , here n=1, as the character (b) occur 2 times, hence repetation is + 2 -1
        /// result + "abcvbdsp"


    }
    public static int findA(String str) {

        if (str.length() == 0){     ///  ""
            return 0;
        }

        int count = 0;

        for (int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'a'){
                count++;
            }
        }
        return count;
    }
}
