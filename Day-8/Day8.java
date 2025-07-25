



class Day8 {
    public static void main(String[] args) {
        Pen p1 = new Pen(); // constructor      // 9900
        // int arr[] = new int[size];

        Pen p2 = new Pen("blue");     // 1120

        // Access-modifier

        /// 1. public , 2. private , 3. protected , 4. default
        /// 4 main pillars are 
        ///     1.Encapsulation  2.Abstraction  3.Inheritance  4.Polymorphism 
        /// 
        /// 1. Encapsulation
        /// 2. Inheritance
        /// types of inheritance - 1. single level 2. multi level 3. hybrid  4. multiple 
        /// A -> B -> C -> D
        /// 2. Polymorphism -> multiple form -> 2 types
        ///     1. run time polymorphism (method overriding) 
        ///     2. compile time polymorphism(method overloading)
         
        Human h1 = new Human();
        System.out.println(h1.eat);

        Men m1 = new Men();

        /**
         *                  Creature
         *                   /  |  \
         *                  A   B   C
         *                 / \  |  / \
         *                P   Q R S   T
         */

        /**
         * 
         * Calculation c1 = new Calculation();
        System.out.println(c1.sum(2,3));
        System.out.println(c1.sum(2,3,4));

        Child c2 = new Child();
        Parent p3 = new Parent();
        p3.console();
        c2.console();


         

        Dog d1 = new Dog("dog1" ,  "abc");
        Dog d2 = new Dog("dog2" , "abd");
        d1.setName("dog3");
        System.out.println(d1.name);
        */

        Bank b1 = new Bank();

        Account a1 = new Account(1000, "user 1");
        b1.newAccount(a1);

        int balance = a1.deposite(2000);
        System.out.println(balance);
        balance = a1.withdraw(500);
        System.out.println(balance);


    }

    static class Pen{
        String color ;  // attributes
        int thickness;  // attributes
        private String password;

        void changeColor(String color) {    // methods
            this.color = color;
        }

        public Pen() {  // non-parameterized constructor
            // anything
            System.out.println("non-parameterized constructor");
        }

        public Pen(String color){   // parameterized constructor
            this.color = color;
            System.out.println("parameterized constructor");
        }

    }

    static class Ape{
        boolean eat = true;
        public Ape() {
            System.out.println("Ape constructor...");
        }
    }

    static class Human extends Ape{
        boolean walk = true;
        public Human() {
            System.out.println("Human constructor...");
        }
    }

    static class Men extends Human{
        String name = "abc";
        public Men() {
            System.out.println("Men constructor...");
        }
    }

    static class Creature {
        String name = "abc";
    }

    static class A extends Creature{
        String name1 = "abd"; 
    }

    static class B extends Creature{
        String name2 = "anc";
    }

    static class D extends A{
        String name3 = "jsh";
    }

    static class Calculation{
        public int sum(int a , int b) {
            return a + b;
        }

        public int sum(int a, int b, int c) {
            return a+b+c;
        }
    }

    static class Parent{
        void console() {
            System.out.println("print from parent...");
        }
    } 

    static class Child extends Parent{
        void console() {
            System.out.println("print from child...");
        }
    }

    /**
     * q1 : Write a Java program to create a class 
     *  called "Dog" with a name and breed attribute. Create two instances 
     *  of the "Dog" class, set their attributes using the constructor and 
     *  modify the attributes using the setter methods and print the updated values.
     * 
     * 
     */

    static class Dog{
        String name;
        String breed;

        public Dog(String name , String breed) {
            this.name = name;
            this.breed = breed;
        }

        // setter
        public void setName(String name) {
            this.name = name;
        }
        public void setBreed(String breed) {
            this.breed = breed;
        }
    }



    /**
     * 
     * q2 : Write a Java program to create a class called "Bank" with a collection of 
     *  accounts and methods to add ,and to deposit and withdraw money.
     *  Also define a class called "Account" to maintain account details of a 
     *  particular customer.
     * 
     */

    static class Account{
        int money;
        String ownerName;

        public Account(int money , String name ) {
            this.money = money;
            this.ownerName = name;
        }

        public int deposite(int money){
            this.money += money;
            return this.money;
        }

        public int withdraw(int money) {
            this.money -= money;
            return this.money;
        }

    }

    static class Bank {
        Account arr[] = new Account[100];
        int i=0; 

        public void newAccount(Account acc) {
            arr[i] = acc;
            i++;
        }


    }

}
