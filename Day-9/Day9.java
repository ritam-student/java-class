class Day9 {
    public static void main(String[] args) {
        Child c1 = new Child();

        // sum(2,3);
        // sum(5,6);
        System.out.println(factorial(3));
        System.out.println(sumOfNaturalNumbers(5));
        System.out.println(fibonachii(5));
    }

    // print all numbers from 1 to n
    public static void printAllNumbers(int n){
        // base case
        if(n == 0){
            return;
        }
        // call for the smaller instances
        printAllNumbers(n-1);
        // work in each step
        System.out.print(n+" ");
    }

    // print numbers in descending order ex: for n=5 , 5,4,3,2,1

    public static void printDescending(int n) {
        if (n==0){
            return;
        }
        System.out.print(n+" ");
        printDescending(n-1);

    }

    // find factorial number ex. 5 -> 5*4*3*2*1
    public static int factorial(int n) {
        // base case
        if(n==1) {
            return 1;
        }

        return n * factorial(n-1);
    }

    // sum of n natural numbers ex. n=5 return 1+2+3+4+5
    public static int sumOfNaturalNumbers(int n) {
        // base case
        if(n==1){
            return 1;
        }

        return n + sumOfNaturalNumbers(n-1);
    }

    // find nth fibonachi number
    //  0 1 1 2 3 5 8 ...     n = (n-1) + (n-2);

    public static int fibonachii(int n) {
        // base case
        if (n == 0 || n == 1){
            return n;
        }

        return fibonachii(n-1) + fibonachii(n-2);
    }

    // check if array is sorted or not in ascending order
    // {1,2,3,4,5} -> true , {3,6,2,5} -> false

    public static boolean isSorted(int arr[] , int index){
        // base case
        if (index == arr.length-1){
            return true;
        }

        return ((arr[index] < arr[index+1]) && isSorted(arr, index+1));
    }


    static void sum(int a, int b) {     //1105
        System.out.println(a+b);
    }

    static class B{
        int arr[] = {1,2,3};

    }

    static class A{
        int var1;

        int arr1[] = new int[3];
        
        public A(int var1) {
            this.var1 = var1;
        }

        public A() {

        }
        // copy constructor
        public A(B obj){
            for (int i=0; i<obj.arr.length; i++){
                arr1[i] = obj.arr[i];
            }
        }

    }

    

    interface Factory{
        int age = 10;
        public void log(int a);
    }

    static class Newclass implements Factory{
        private String name;
        private int age;

        public void log(int a) {
            System.out.println("hi");
        }

        

        
    }

    static class Parent{
            public Parent() {
                System.out.println("Parent constructor...");
            }
        }

        static class Child extends Parent{
            public Child() {
                super();
                System.out.println("child constructor...");
            }
        }

    
    
}
