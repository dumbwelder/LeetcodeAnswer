package Literature.Test7;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object sign1 = new Object();
        Object sign2 = new Object();
        Thread thread1 = new MyThread1(sign1, sign2);
        Thread thread2 = new MyThread2(sign1, sign2);
        System.out.println(thread1.getState());
        thread1.start();
        System.out.println(thread1.getState());
        Thread.sleep(500);
        System.out.println(thread1.getState());

        Thread.sleep(3000);
        System.out.println(thread1.getState());
    }

    static class MyThread1 extends Thread {
        Object sign1;
        Object sign2;

        MyThread1(Object sign1, Object sign2) {
            this.sign1 = sign1;
            this.sign2 = sign2;
        }

        @Override
        public void run() {
            System.out.println("1start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (sign1) {
                try {
                    sign1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1end");
            }
        }
    }

    static  class MyThread2 extends Thread {
        Object sign1;
        Object sign2;

         MyThread2(Object sign1, Object sign2) {
            this.sign1 = sign1;
            this.sign2 = sign2;
        }

        @Override
        public synchronized void run() {
              {
                System.out.println("2start");
                System.out.println("2end");
                sign1.notify();
            }
        }
    }
}