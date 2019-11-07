package Test2;

import test.DeepThink.Person;
import test.DeepThink.Runner;

public class Test2 {
    public static void main(String[] args) {
        Person p = new Runner();
        ((Runner) p).run();
    }
}

