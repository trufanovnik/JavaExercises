package ThreadsFirst;

import java.util.Arrays;

public class MyThreadsApp {
    private final int SIZE = 10_000_000;
    private final int HALF = SIZE/2;
    float[] array = new float[SIZE];

    public static void main(String[] args) {
        MyThreadsApp myThreadsApp = new MyThreadsApp();
        myThreadsApp.result();
        myThreadsApp.resultWithThreads();
    }

    public void result(){
        Arrays.fill(array, 1.0f);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (i * Math.sin(0.2f + i / 3.0f) * Math.cos(0.2f + i / 2.0f) *
                    Math.cos(0.4f + i / 2.0f) + 2.2f);
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    public void resultWithThreads(){
        Arrays.fill(array, 1);
        float[] arrayLeft = new float[HALF];
        float[] arrayRight = new float[HALF];
        System.arraycopy(array, 0, arrayLeft,0, HALF);
        System.arraycopy(array, HALF, arrayRight,0, HALF);
        long begin = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < HALF-1; i++) {
                arrayLeft[i] = (float) (i * Math.sin(0.2f + i / 3.0f) * Math.cos(0.2f + i / 2.0f) *
                        Math.cos(0.4f + i / 2.0f) + 2.2f);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0, j = HALF; i < HALF-1; i++, j++) {
                arrayRight[i] = (float) (j * Math.sin(0.2f + j / 3.0f) * Math.cos(0.2f + j / 2.0f) *
                        Math.cos(0.4f + j / 2.0f) + 2.2f);
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arrayLeft, 0, array, 0, HALF);
        System.arraycopy(arrayRight, 0, array, HALF, HALF);
        System.out.println(System.currentTimeMillis() - begin);
    }
}
