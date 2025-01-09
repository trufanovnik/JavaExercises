package ThreadsSecond.Race;
import ThreadsSecond.Stages.Stage;
import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages () { return stages; }
    //упаковываем все стадии гонки для поочередного доступа к ним во время заезда
    public Race (Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
