package base;

public class CoreJava1 {
    public static void main( String[] args ) {
        int num = 5;
        String greeting = "Hello!";
        char letter = 'y';
        double dec = 2.91;
        float flNum = 2.34f;
        boolean isEnabled = true;
        
        System.out.println(num);
        System.out.println(greeting);
        System.out.println(greeting + " My number is " + num);

        //Arrays
        int[] arr = new int[5]; //declared an array with memory for 5 values
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 5;
        arr[3] = 20;
        arr[4] = 14;

        int[] arr2 = {1,2,5,20,14};
        System.out.println(arr[3]); //20

        //Loops
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        String[] names = {"George", "Paul", "John", "Ringo"};

        for(int i = 0; i < names.length; i++){
            System.out.println(names[i]);
        }

        //Enhanced for loop
        for(String s: names){ //from names array on every iteration pick one value and store it in s variable
            System.out.println(s);
        }

    }
}