package ThreadsSecond.Vehicle;

import ThreadsSecond.Race.Race;

import java.util.concurrent.CyclicBarrier;

import static ThreadsSecond.MainApp.CARS_COUNT;

public class Car implements Runnable{
    private static int CAR_NUMBER;
    private static final CyclicBarrier startBarrier = new CyclicBarrier(CARS_COUNT);
    private static volatile boolean winnerDeclared = false;
    static {
        CAR_NUMBER = 0 ;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName () {
        return name;
    }
    public int getSpeed () {
        return speed;
    }
    public Car (Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CAR_NUMBER++;
        this.name = "Участник #" + CAR_NUMBER;
    }

    @Override
    public void run() {
        try {
            System.out.println( this.name + " готовится" );
            Thread.sleep( 500 + ( int )(Math.random() * 800 ));
            startBarrier.await();
            System.out.println( this.name + " готов" );
        } catch (Exception e) {
            e.printStackTrace();
        }
        for ( int i = 0 ; i < race.getStages().size(); i++) {
            race.getStages().get(i).go( this );
        }
        if (!winnerDeclared) {
            synchronized (Car.class) {
                if (!winnerDeclared) {
                    winnerDeclared = true;
                    System.out.println(this.name + " - Победитель!");
                }
            }
        }
    }
}
