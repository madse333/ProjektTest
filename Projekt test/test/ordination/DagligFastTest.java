package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {

    DagligFast dagligFast;
    Patient patient = new Patient("050972-1233", "Hans Jørgensen", 89.4);
    Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre",0.5,1,
            2,"Styk");


    @BeforeEach
    void setUp() {

    }

    @Test
    void getDoser() {
    }

    @Test
    void samletDosis() {
        dagligFast = new DagligFast(LocalDate.of(2001,1,1),LocalDate.of(2001,1,3),patient,laegemiddel, 2,1 ,1 ,1);
        assertEquals(15,dagligFast.samletDosis());

        dagligFast = new DagligFast(LocalDate.of(2001,1,1),LocalDate.of(2001,1,3),patient,laegemiddel, 5,5 ,2.5 ,4);
        assertEquals(49.5,dagligFast.samletDosis());
    }

    @Test
    void doegnDosis() {
        dagligFast = new DagligFast(LocalDate.of(2001,1,1),LocalDate.of(2001,1,3),patient,laegemiddel, 2,1 ,1 ,1);
        assertEquals(5, dagligFast.doegnDosis());

        dagligFast = new DagligFast(LocalDate.of(2001,1,1),LocalDate.of(2001,1,3),patient,laegemiddel, 5,5 ,2.5 ,4);
        assertEquals(16.5,dagligFast.doegnDosis());
    }

    @Test
    void getType() {
    }
}