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
     * @param givesDen dato dosis bliver givet
     * @return om dosis er blevet givet
     */

    public boolean givDosis(LocalDate givesDen){
        if(givesDen.isBefore(getSlutDen()) && givesDen.isAfter(getStartDen())
                || (givesDen.equals(getSlutDen()) || givesDen.equals(getStartDen()))){
            dageGivet.add(givesDen);
            //antalGangeGivet++;
            return true;
        }

        return false;
    }

    public double doegnDosis() {
        if (!dageGivet.isEmpty()) {
            return (dageGivet.size() * antalEnheder) / (double) ChronoUnit.DAYS.between(getStartDen(), dageGivet.get(dageGivet.size()-1));
        }
        else{
            return 0;
        }
    }


    public double samletDosis() {
        return dageGivet.size()*antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return antalGangeGivet
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
