package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {


    @Test
    void samletDosis() {
        //Arrange
        Patient patient1 = new Patient("050972-1233", "Hans Jørgensen", 89.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre",0.5,1,
                2,"Styk");
        LocalTime[] times = {LocalTime.of(10, 0), LocalTime.of(10,0), LocalTime.of(10,0), LocalTime.of(10,0)};
        double[] enhed1 = {0.5,0.5,0.5,0.5};
        double[]enhed2 = {0.0, 0.0, 0.0, 0.0};
        double[]enhed3 = {10.0, 10.0, 10.0, 10.0};
        double[]enhed4 = {-3.0,-3.0,-3.0,-3.0};



        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2001,01,01), LocalDate.of(2001, 01, 03), patient1, laegemiddel , times, enhed1);
        DagligSkaev dagligSkaev1 = new DagligSkaev(LocalDate.of(2001, 01, 03), LocalDate.of(2001, 07,01), patient1, laegemiddel, times, enhed2);
        DagligSkaev dagligSkaev2 = new DagligSkaev(LocalDate.of(2001, 01, 10), LocalDate.of(2001, 01,8), patient1, laegemiddel, times, enhed3);
        DagligSkaev dagligSkaev3= new DagligSkaev(LocalDate.of(2001, 01, 10), LocalDate.of(2001, 01,13), patient1, laegemiddel, times, enhed4);

        double ac1 = dagligSkaev.samletDosis();
        double ac2 = dagligSkaev1.samletDosis();
        double ac3 = dagligSkaev2.samletDosis();
        double ac4 = dagligSkaev3.samletDosis();


        assertEquals(6, ac1);
        assertEquals(0, ac2);
        assertEquals(-40, ac3);
        assertEquals(-48, ac4);




    }

    @Test
    void doegnDosis() {
        Patient patient1 = new Patient("050972-1233", "Hans Jørgensen", 89.4);
        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre",0.5,1,
                2,"Styk");
        double[] enhed1 = {1.0,1.0,1.0,1.0};
        LocalTime[] times = {LocalTime.of(10, 0), LocalTime.of(10,0), LocalTime.of(10,0), LocalTime.of(10,0)};
        DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2010, 01, 01), LocalDate.of(2010, 01, 05), patient1, laegemiddel, times, enhed1);


        double ac1 = dagligSkaev.doegnDosis();

        assertEquals(4, ac1);


    }
}