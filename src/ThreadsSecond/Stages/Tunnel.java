package ThreadsSecond.Stages;
import ThreadsSecond.Vehicle.Car;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

import static ThreadsSecond.MainApp.CARS_COUNT;

public class Tunnel extends Stage{
    //в тоннеле может быть только половина участников, согласно условию
    private static final Semaphore smp = new Semaphore(CARS_COUNT/2);

    public Tunnel(){
        this.length = 80;
        this.description = "Тоннель " + length + " метров.";
    }

    //метод go вызывается внутри метода run (т.е. при запуске треда)
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу: " + description);
            smp.acquire();
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            smp.release();
        }
    }
}
