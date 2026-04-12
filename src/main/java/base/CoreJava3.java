package base;

public class CoreJava3 {
    public static void main( String[] args ) {
        //string is an object represents seq of chars

        //string literal declaration
        String s = "Hello my name is Test";
        String s1 = "Hello my name is Test"; //s1 will point to value of s since the value is exactly the same (not create new object)

        //new memory allocate operator declaration
        String s2 = new String("Welcome");
        String s3 = new String("Welcome"); //s3 will be a separate object since declared with new keyword

        String[] splittedString = s.split(" ");
        for(String str: splittedString){
            System.out.println(str);
        }

        //print string in reverse order
        System.out.println("String in reverse order:");
        for(int i = s.length()-1; i >= 0; i--){
            System.out.println(s.charAt(i));
        }

    }
}