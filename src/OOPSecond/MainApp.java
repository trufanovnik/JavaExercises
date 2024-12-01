// задача создать три класса, не наследующихся от одного
// классы должны уметь прыгать и бегать
// перед каждым участником ставилась задача перепрыгнуть стену и пробежать дистанцию дорожки
// если первое препятствие не было преодолено, ко второму участник не допускался
// подход к препятствиям необходимо было реализовать через обход массива

package OOPSecond;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        Human human = new Human("Алекс", 1.5, 1500);
        Cat cat = new Cat("Барсик", 2.0, 150);
        Robot robot = new Robot("Гектор", 0.5, 1000);

        ArrayList<Actions> participants = new ArrayList<>();
        participants.add(human);
        participants.add(cat);
        participants.add(robot);

        Wall wall = new Wall(1.51);
        Treadmill treadmill = new Treadmill(50);

        ArrayList<Obstacles> obstacles = new ArrayList<>();
        obstacles.add(wall);
        obstacles.add(treadmill);

        for (Actions par : participants){
            for (Obstacles ob : obstacles){
                if (ob.trial(par)){
                    ;
                }else {break;}
            }
        }
    }
}
