package test.DeepThink;

/**
 * @author yanxi
 */
public class Person {
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

     void run(){
        System.out.println("people can run");
    }

    @Override
    public String toString() {
        return this.name + " : " + this.age;
    }

}
