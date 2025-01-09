package ThreadsSecond.Stages;
import ThreadsSecond.Vehicle.Car;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static ThreadsSecond.MainApp.CARS_COUNT;

public class Tunnel extends Stage{
    private static final CyclicBarrier tunnelBarrier = new CyclicBarrier(CARS_COUNT / 2);
    public Tunnel(){
        this.length = 80;
        this.description = "Тоннель " + length + " метров.";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу: " + description);
            tunnelBarrier.await();
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            tunnelBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
