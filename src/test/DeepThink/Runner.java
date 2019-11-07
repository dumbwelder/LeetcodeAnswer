package test.DeepThink;

/**
 * @author yanxi
 */
public class Runner extends Person{
    public Runner() {
    }

    public Runner(int age, String name) {
        super(age, name);
    }

    @Override
    public void run(){
        super.run();
        System.out.println("runer can run faster");
    }
}
