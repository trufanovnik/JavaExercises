package ThreadsSecond;

import ThreadsSecond.Race.Race;
import ThreadsSecond.Stages.Road;
import ThreadsSecond.Stages.Tunnel;
import ThreadsSecond.Vehicle.Car;

public class MainApp {
    public static final int CARS_COUNT = 4 ;
    public static void main (String[] args) {
        //см.реализацию класса Race
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        //в блоке ниже создадим наших участников с передачей им маршрута и скорости
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        //проходимся по массиву участников и запускаем треды для каждого
        for (int i = 0; i < cars.length; i++) {
            //передаем в тред объект Runnable т.е. каждую машину
            new Thread(cars[i]).start();
        }
    }
}
