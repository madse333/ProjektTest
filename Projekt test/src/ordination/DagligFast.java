package ordination;
import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {

    // composition --> 0..4 Dosis
    private final Dosis[] doser = new Dosis[4];
    private int antalDoser = 0;

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel){
        super(startDen,slutDen, laegemiddel);
    }
    public Dosis[] getDoser(){return doser;}

    public void createDosis(LocalTime tid, double antal){
        try{
            Dosis dosis = new Dosis(tid,antal);
            doser[antalDoser] = dosis;
            antalDoser++;
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Exception: " + ex.getMessage() + " sikkert for mange doser tilføjet.");
        }
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
