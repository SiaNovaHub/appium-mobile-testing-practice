package base;

public class CoreJava4 {
    public static void main( String[] args ) {
        //methods should not be written inside main block
        //to access the method firstly need to create an object of the class
        CoreJava4 test = new CoreJava4();
        test.getData();
        String smt = test.returnData();
        System.out.println(smt);
        CoreJava5 test2 = new CoreJava5();
        test2.getMoreData();
        returnData2();

    }
    public void getData(){
        System.out.println("Hello!!!");
    }
    public String returnData(){
        return "Test String";
    }
    public static void returnData2(){ //static methods can be used within the same class without creating an object
        System.out.println("WOW");
    }
}