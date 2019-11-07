package test.classLoaderTest;

import java.io.*;

public class TestClassLoader extends ClassLoader {

    private String name;

    public TestClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
        if (name.equals("test.classLoaderTest.Test")) {
            return findClass(name);
        }

        return super.loadClass(name);
    }
    @Override
    public Class<?> findClass(String name) {

        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(new File("D:\\javaworkspace\\LeetCode\\out\\production\\LeetCode\\test\\classLoaderTest\\Test.class"));
            int c = 0;
            while (-1 != (c = is.read())) {
                baos.write(c);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("success---" + name + data.length);
        return this.defineClass(name, data, 0, data.length);
    }

    public static void main(String[] args) {
        TestClassLoader loader = new TestClassLoader(
                TestClassLoader.class.getClassLoader(), "TestLoader");
        Class clazz;
        try {
            clazz = loader.loadClass("test.classLoaderTest.Test");
            Object object = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
