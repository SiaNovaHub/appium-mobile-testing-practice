package base;

import java.util.ArrayList;

public class CoreJava2 {
    public static void main( String[] args ) {
        int[] arr1 = {1,2,5,20,14,7,13,122,15};

        //Conditional statements
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] % 2 == 0){
                System.out.println(arr1[i]);
                break;
            }
            else{
                System.out.println(arr1[i] + " - not multiple of 2");
            }
        }

        //ArrayList - for dynamic arrays (size and values)
        ArrayList<String> testList = new ArrayList();
        testList.add("hello");
        testList.add("my");
        testList.add("name");
        testList.add("is");
        testList.remove(2);
        System.out.println(testList.get(0));


    }
}