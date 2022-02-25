package ordination;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {

    @org.junit.jupiter.api.Test
    void givDosis() {
        // Arrange
        Patient patient = new Patient("050972-1233", "Hans Jørgensen", 89.4);

        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre",0.5,1,
                2,"Styk");

        PN pn = new PN(LocalDate.of(2010,2,1),LocalDate.of(2010,2,10),
                patient, laegemiddel, 2);

        // Act
        boolean TC1 = pn.givDosis(LocalDate.of(2010,2,1));
        boolean TC2 = pn.givDosis(LocalDate.of(2010,2,10));
        boolean TC3 = pn.givDosis(LocalDate.of(2010,2,11));
        boolean TC4 = pn.givDosis(LocalDate.of(2010,1,31));

        // Assert
        assertTrue(TC1);
        assertTrue(TC2);
        assertFalse(TC3);
        assertFalse(TC4);
    }


    @org.junit.jupiter.api.Test
    void doegnDosis() {
        // Arrange
        Patient patient = new Patient("050972-1233", "Hans Jørgensen", 89.4);

        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre",0.5,1,
                1,"Styk");

        PN pn = new PN(LocalDate.of(2010,1,1),LocalDate.of(2010,1,5),
                patient, laegemiddel, 2);

        // Act
        double TC5 = pn.doegnDosis();

        // Assert
        assertEquals(0,TC5);

    }

    @org.junit.jupiter.api.Test
    void samletDosis() {

    }

}