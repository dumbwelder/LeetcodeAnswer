package test;

public class Main {
    final int i = 0;

    public static void main(String[] args) throws InterruptedException {
        MyThread runnable = new MyThread();
        for (int i = 0; i < 500; i++) {
            new Thread(runnable).start();
        }
        Thread.sleep(1000);
        System.out.println(runnable.a);
    }

    public static class MyThread implements Runnable {
        public int a = 0;

        @Override
        public void run() {
            a++;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
