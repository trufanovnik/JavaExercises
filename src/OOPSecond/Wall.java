package OOPSecond;

public class Wall implements Obstacles {
    private double height;

    Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean trial(Actions participant){
        if(participant.jump(height)){
            System.out.println(participant.toString() + " перепрыгнул");
            return true;
        }else {
            System.out.println(participant.toString() + " не смог перепрыгнуть и не допущен к следующему испытанию");
            return false;
        }
    }
}
