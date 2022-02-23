package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination{

    private double antalEnheder;
    private int antalGangeGivet;
    private LocalDate sidstGivet;
    ArrayList<LocalDate> dageGivet = new ArrayList();

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double antalEnheder) {
        super(startDen, slutDen, laegemiddel);
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
        if(givesDen.isAfter(getStartDen()) && givesDen.isBefore(getSlutDen())){
            dageGivet.add(givesDen);
            antalGangeGivet++;
            return true;
        }

        return false;   
    }

    public double doegnDosis() {
        return (antalGangeGivet * antalEnheder) / (double) ChronoUnit.DAYS.between(getStartDen(), sidstGivet);
    }


    public double samletDosis() {
        double samletdosis = 0.0;


        return 0.0;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        // TODO
        return-1;
    }

    public String getType(){
        return "PN";
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }
}
