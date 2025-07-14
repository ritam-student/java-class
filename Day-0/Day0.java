class Day0 {
    public static void main(String args[]) {
        // print something
        System.out.println(10 + 2);
        System.out.print("Hello world");
        System.out.println("hello world");
        //
        // single line comments

        /**
         * milti line comments
         * 
         * hdjd
         */


        // data types

        /**
         * 2 types -- 1. premitive  2. Non-premitive
         * 
         *  
         *  
         */


         // premitive data types
        // integer
        int abc = 13;
        // float 
        float fl = (float) 10.2;
        // character
        char name = 'a' ;
        // String
        String name1 = "raman";
        // boolean
        boolean isMonday = true;



        /**
         * general format to create a variable
         * 
         * dataType nameOfTheVariable = value
         */


        /** norms of naming the variables
         * 1. must start with a character
         * 2. camel case rule
         * 3. numerical values
         * 4. you can use $
         * 
         */


         // function

        // process -1
        int sum =6+7;

        System.out.println(sum);

        // process -2
        int num1 = 6;
        int num2 = 7;

        int sum1 = num1 + num2;
        // System.out.println(sum1);

        // process -3
        // using a function
        // way 1 of passing an arguments
        int sum3 = addition(2,3);
        System.out.println(sum3);

        // way 2 of passing an arguments
        int num3 = 2;
        int num4 = 3;
        int sum10 = addition(num3 , num4);





    }


    // create a function
    public static int addition(int num1 , int num2) {
        return num1 + num2;
    }

}

