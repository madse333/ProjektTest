package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PN extends Ordination{

    private double antalEnheder;
    private int antalGangeGivet;
    private LocalDate sidstGivet;

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
    public boolean givDosis(LocalDate givesDen) {
        // TODO
        return false;   
    }

    public double doegnDosis() {
        return (antalGangeGivet * antalEnheder) / (double) ChronoUnit.DAYS.between(getStartDen(), sidstGivet);
    }


    public double samletDosis() {
        // TODO
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
