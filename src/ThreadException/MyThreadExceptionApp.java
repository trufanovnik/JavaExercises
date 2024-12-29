package ThreadException;

public class MyThreadExceptionApp {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 10 / 0;
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 10 / 0;
            }
        });

        /*
        таким образом не "словим"
        try {
            thread.start();
        }catch (ArithmeticException e){
            System.out.println("caught");
        }
         */

        /* вот так "словим", но конкретно в одном, указанном треде.
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                e.printStackTrace();
                System.out.println("caught");
            }
        });
        thread.start();
         */
        // Вот так словим для любого треда
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                e.printStackTrace();
                System.out.println("caught");
            }
        });
        thread.start();
        thread1.start();
    }
}
