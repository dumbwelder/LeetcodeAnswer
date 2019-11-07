package meituan.Test2;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        new ReviewEncourage(n);
    }
}

class ReviewEncourage {
    int n;
    CyclicBarrier barrier1 = new CyclicBarrier(2);
    CyclicBarrier barrier2= new CyclicBarrier(2);
    Thread bonus = new Thread() {
        @Override
        public void run() {
            while (true) {
                System.out.println("A");
                try {
                    barrier1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    Thread coupon = new Thread() {
        @Override
        public void run() {
            while (true) {
                System.out.println("B");
                try {
                    barrier1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    Thread contribution = new Thread() {
        @Override
        public void run() {
            System.out.println("C");
        }
    };

    public ReviewEncourage(int n) {
        this.n = n;
        execut();
    }

    private void execut() {
        bonus.start();
        coupon.start();
    }


}
