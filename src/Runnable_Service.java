public class Runnable_Service implements Runnable {
    public void run() {
        System.out.println("Выполняется: " + Thread.currentThread().getName());
        System.out.println("Завершил: " + Thread.currentThread().getName());
    }

    public static void RunnableJoin() {
        Thread t1 = new Thread(new Runnable_Service(), "t1");
        Thread t2 = new Thread(new Runnable_Service(), "t2");
        Thread t3 = new Thread(new Runnable_Service(), "t3");

        t1.start();
        try {
            t3.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        t2.start();
        try {
            t3.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();
        try {
            t1.join(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
