package test.DeepThink;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException
            , InvocationTargetException {
        Person p = new Person(20, "yanxi");
        System.out.println(p);
        changeName(p);
        System.out.println(p);
    }

    private static void changeName(Person p) throws NoSuchFieldException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
//        Field[] fileds = p.getClass().getDeclaredFields();
//        for (Field f :fileds){
//            f.setAccessible(true);
//            System.out.println(f.getName());
//            System.out.println(f.get(p));
//        }
        Field f = p.getClass().getDeclaredField("age");
        f.setAccessible(true);
        f.setInt(p, 15);

        Method[] ms = p.getClass().getDeclaredMethods();
        for (Method method : ms) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            Class[] c = method.getParameterTypes();
            for (Class cl : c) {
                System.out.println(cl.getName());
            }
        }
        Method m = p.getClass().getDeclaredMethod("toString");
        System.out.println(m.invoke(p));
    }
}
