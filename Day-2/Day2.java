
public class Day2 {
    public static void main(String args[]) {
        // binary operators
        int a = 2 + 3;

        // unary operator
        int c = 10;
        a++;
        int b = 99;
        b++;

        /**
         * 
         * unary operators
         *  1. pre
         *  2. post
         */

         // pre
        
         int age = 10;
        System.out.println(age);

        int var1 = age++;
        int var2 = ++age;

        System.out.println(var1);
        System.out.println(var2);
        /**
         * 10 , 12
         * 10 , 11
         */

        /* ternary operators */

        if (age > 10) {
            System.out.println("greater");
        }else {
            System.out.println("not greater");
        }

        int num = 30;

        if (num % 2 == 0) {
            System.out.println("even");
        }else {
            System.out.println("odd");
        }

        String even = num % 2 == 0 ? "even" : "odd";

        // logical operators
        if (age > 10 || age < 18) {
            System.out.println("child");
        }

        boolean even1 = true;

        boolean odd = !even1;

        // assignment operators
        int num1 = 10;
        num += 2;       // num = num + 2
        num -= 2;
        num *= 2;
        num /= 2;
        num %= 2;

        /**
         * 
         * conditional statements
         * 1. if
         * 2. if else
         * 3. if -else if -else
         * 4. switch case
         * 
         */

        if (age == 20) {
            System.out.println("nothing");
        }else if (age == 30){
            System.out.println("nothing 2");
        }
        else {
            System.out.println("nothing 1");
        }

        /**
         * 
         * Scanner sc = new Scanner(System.in);
        int btn = sc.nextInt();

        switch (btn) {
            case 1 : {
                System.out.println("clicked on btn 1");
                break;
            }
            case 2 : {
                System.out.println("clicked on btn 2");
                break;
            }
            case 3 : {
                System.out.println("clicked on btn 3");
                break;
            }
            default : {
                System.out.println("please click on the right btn");
            }
        }

         */

        /**
         * 
         * Loops 
         *  1. for loop
         * 2. while loop
         * 3. do while loop
         */

        // for loop
        /**
         * initialization
         * increase / decrease
         * termination
         */

        /**
         * for (int i=1; i < 11; i++){
            System.out.print(i+ " ");
        }
         */
        
        // while loop
        /**
         * int i = 1;
        while (i < 11) {
            System.out.println(i + " ");
            i++;
        }

        
         */

         // do while loop
        /**
         * int i =1;

        do { 
            System.out.print(i + " ");
            i++;
        } while( i < 1);
        
         */

        /*
         * 
         for (int j=0; j<11; j++) {
            if (j == 5) {
                continue;
            }
            System.out.println(j);
         }
         */
        /**
         * 
         * Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for (int i=1; i<= input; i++) {
            System.out.print(i + " ");
        }
         */

        /**
         * 
         *      *****
         *      *****
         *      *****
         *      *****
         */

        //   ******
        for (int j=0; j<4; j++) {
            for (int i=0; i<5; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

        /**
         * 
         *  *****
         *  *   *
         *  *   *
         *  *****
         * 
         * i = 4       // rows
         * j = 5       // columns
         * 
         */

         for (int row = 0; row<4; row++) {
            for (int column= 0 ; column < 5; column++) {
                if (row == 0 || row == 3) {
                    System.out.print("*");
                }else {
                    if (column  == 0|| column == 4) {
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
         }
        

         /**
          * 
          row = 4
          column = 5
                *****
                *   *
                *   *
                *****

          */


    }
}
