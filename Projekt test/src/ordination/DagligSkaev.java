package ordination;

import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev {
    // TODO
    // composition --> 0..* Dosis
    private final ArrayList<Dosis> doser = new ArrayList<>();

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }

    public void opretDosis(LocalTime tid, double antal) {
        // TODO
        Dosis dosis = new Dosis(tid,antal);
        doser.add(dosis);
    }
}
