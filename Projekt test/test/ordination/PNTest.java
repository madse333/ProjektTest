package ordination;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {

    @org.junit.jupiter.api.Test
    void givDosis() {
        // Arrange
        Patient patient1 = new Patient("050972-1233", "Hans Jørgensen", 89.4);

        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre",0.5,1,
                2,"Stuk");

        PN pn = new PN(LocalDate.of(2010,2,1),LocalDate.of(2010,2,10),
                2);

        // Act
        boolean TC1 = pn.givDosis(LocalDate.of(2010,2,1));
        boolean TC2 = pn.givDosis(LocalDate.of(2010,2,10));

        // Assert
        assertTrue(TC1);
        assertTrue(TC2);
    }


    @org.junit.jupiter.api.Test
    void doegnDosis() {

    }

    @org.junit.jupiter.api.Test
    void samletDosis() {

    }

}