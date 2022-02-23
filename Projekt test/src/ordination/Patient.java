package ordination;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String cprnr;
    private String navn;
    private double vaegt;

    private List<Ordination> ordinationer = new ArrayList<>();

    public Patient(String cprnr, String navn, double vaegt) {
        this.cprnr = cprnr;
        this.navn = navn;
        this.vaegt = vaegt;
    }

    public String getCprnr() {
        return cprnr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getVaegt(){
        return vaegt;
    }

    public void setVaegt(double vaegt){
        this.vaegt = vaegt;
    }

    public List<Ordination> getOrdinationer(){return new ArrayList<>(ordinationer);}

    public void addOrdination(Ordination ordination){
        ordinationer.add(ordination);
    }

    public void removeOrdination(Ordination ordination){
        ordinationer.remove(ordination);
    }

    @Override
    public String toString(){
        return navn + "  " + cprnr;
    }

}
