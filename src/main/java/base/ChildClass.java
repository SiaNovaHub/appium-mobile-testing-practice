package base;

public class ChildClass extends ParentClass { //inherit Parent properties and methods
    public static void main( String[] args ) {
        ChildClass test = new ChildClass();
        test.Color();
        test.Breaks();
    }
    public void Audio(){
        System.out.println("NEW Audio code");
    }
    public void Color(){
        System.out.println(colour);
    }
}