package threads;

class Counter {
    static int i=0;
    static Object lock=new Object();
    static class OddNumber implements Runnable{
        public void run(){
            while (i<20){
                synchronized (lock) {
                    if (i % 2 != 0) {
                        System.out.println(i++);
                        lock.notify();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }


    }
    static class EvenNumber extends Thread{
        public void run(){
            while (i<20){
                synchronized (lock) {
                    if (i % 2 == 0) {
                        System.out.println(i++);
                        lock.notify();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }

    }
}





public class NumberDisplay {
    public static void main(String[] args) {
        Thread t1= new Thread(new Counter.OddNumber());
        Thread t2=new Thread(new Counter.EvenNumber());
        t1.start();
        t2.start();

    }
}
