package ordination;

import java.time.LocalDate;
import java.util.ArrayList;

public class PN extends Ordination {

    private double antalEnheder;
    ArrayList<LocalDate> dageGivet = new ArrayList();
    private int antalGangeGivet;

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
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
        return 0.0;
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

    public double getAntalEnheder() {
        return antalEnheder;
    }

    public String getType(){
        return "PN";
    }


}
