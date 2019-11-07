package test.classLoaderTest;

public class Test {
    public Test(){
        System.out.println(this.getClass().getClassLoader().toString());
    }
}
