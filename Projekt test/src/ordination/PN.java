package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination{

    private double antalEnheder;
    private int antalGangeGivet;
    ArrayList<LocalDate> dageGivet = new ArrayList();

    public PN(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel, double antalEnheder) {
        super(startDen, slutDen, patient, laegemiddel);
        this.antalEnheder = antalEnheder;
        this.antalGangeGivet = 0;
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */

    public boolean givDosis(LocalDate givesDen){
        if((givesDen.isEqual(getStartDen()) && givesDen.isBefore(getSlutDen())) || givesDen.isAfter(getStartDen())
                && givesDen.isEqual(getSlutDen())){
            dageGivet.add(givesDen);
            antalGangeGivet++;
            return true;
        } else

        return false;
    }

    public double doegnDosis() {
        if (!dageGivet.isEmpty()) {
            return (antalGangeGivet * antalEnheder) / (double) ChronoUnit.DAYS.between(getStartDen(), dageGivet.get(dageGivet.size()-1));
        }
        else{
            return 0;
        }
    }


    public double samletDosis() {
        return antalGangeGivet*antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return dageGivet.size();
    }

    public void setAntalGangeGivet(int antalGangeGivet) {
        this.antalGangeGivet = antalGangeGivet;
    }

    public String getType(){
        return getLaegemiddel().getEnhed();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }
}
