package ordination;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ForkJoinPool;

public class DagligFast extends Ordination {

    // composition --> 0..4 Dosis
    private final Dosis[] doser = new Dosis[4];
//    private int antalDoser = 0;

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double morgenAntal,
                      double middagsAntal, double aftenAntal, double natAntal){
        super(startDen,slutDen, laegemiddel);
        doser[0] = new Dosis(LocalTime.of(8,0),morgenAntal);
        doser[1] = new Dosis(LocalTime.of(12,0),middagsAntal);
        doser[2] = new Dosis(LocalTime.of(18,0),aftenAntal);
        doser[3] = new Dosis(LocalTime.of(0,0),natAntal);
    }

    public Dosis[] getDoser(){return doser;}

//    public void createDosis(LocalTime tid, double antal){
//        try{
//            Dosis dosis = new Dosis(tid,antal);
//            doser[antalDoser] = dosis;
//            antalDoser++;
//        }catch(ArrayIndexOutOfBoundsException ex){
//            System.out.println("Exception: " + ex.getMessage() + " sikkert for mange doser tilføjet.");
//        }
//    }

    @Override
    public double samletDosis() {
        double samletdosis = 0;
        long days = ChronoUnit.DAYS.between(this.getStartDen(),this.getSlutDen());
        for (Dosis d : doser){
            samletdosis += d.getAntal();
        }
        return samletdosis * days;
    }

    @Override
    public double doegnDosis() {
        double samletdosis = 0;
        for (Dosis d : doser){
            samletdosis += d.getAntal();
        }
        return samletdosis;
    }

    @Override
    public String getType() {
        return "Daglig Fast";
    }
}
