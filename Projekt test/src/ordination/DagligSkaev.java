package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    // composition --> 0..* Dosis
    private final ArrayList<Dosis> doser = new ArrayList<>();

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
                       LocalTime[] klokkeSlet, double[] antalEnheder) {
        super(startDen,slutDen, patient, laegemiddel);
        for (int i = 0; i < klokkeSlet.length; i++){
            opretDosis(klokkeSlet[i],antalEnheder[i]);
        }
    }

    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid,antal);
        doser.add(dosis);
    }

    @Override
    public double samletDosis() {
        double samletDosis = 0;
        int days = (int) ChronoUnit.DAYS.between(getStartDen(), getSlutDen()) + 1;
        for(Dosis d : doser){
            samletDosis += d.getAntal();
        }
        return samletDosis * days;
    }

    @Override
    public double doegnDosis() {
        double doegnDosis = 0;
        for(Dosis d: doser){
            doegnDosis += d.getAntal();
        }
        return doegnDosis;
    }

    @Override
    public String getType() {
        return getLaegemiddel().getEnhed();
    }
}
