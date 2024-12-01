package OOPSecond;

import java.util.concurrent.TransferQueue;

public class Treadmill implements Obstacles {
    private double distance;

    Treadmill(double distance){
        this.distance = distance;
    }

    @Override
    public boolean trial(Actions participant){
        if(participant.run(distance)){
            System.out.println(participant.toString() + " пробежал");
            return true;
        }else {
            System.out.println(participant.toString() + " не смог пробежать и не допущен к следующему испытанию");
            return false;
        }
    }
}
