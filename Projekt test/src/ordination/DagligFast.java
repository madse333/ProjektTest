package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {

    //Link attribut
    private final Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen){
        super(startDen,slutDen);

    }
    public Dosis[] getDoser(){return doser;}

    public Dosis createDosis(LocalTime tid, double antal){
        Dosis dosis = new Dosis(tid,antal);

        return dosis;
    }

    @Override
    public double samletDosis() {
        return 0;
    }

    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }

}
