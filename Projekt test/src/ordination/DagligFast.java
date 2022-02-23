package ordination;

import java.time.LocalTime;
import java.util.ArrayList;

public class DagligFast {
    // TODO
    private final Dosis[] doser = new Dosis[4];
    private int antalDoser = 0;

    public ArrayList<Dosis> getDoser(){
        return new ArrayList<>(doser);
    }

    public void opretDosis(LocalTime tid, double antal){
        doser[antalDoser] = new Dosis(tid,antal);
        antalDoser++;
    }
}
