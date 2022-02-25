package controller;

import ordination.Laegemiddel;
import ordination.Ordination;
import ordination.PN;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
Controller controller;

@BeforeEach

void setup(){
    controller = Controller.getTestController();

}
    @Test
    void anbefaletDosisPrDoegn() {
        // Arrange
        Patient patient1 = new Patient("121256-0512", "Jane Jensen", 24);
        Patient patient2 = new Patient("2712028301", "Jane jensen", 26);
        Patient patient3 = new Patient("2712028301", "Jane jensen", 125);
        Patient patient4 = new Patient("2712028301", "Jane jensen", -10);

        Laegemiddel laegemiddel = new Laegemiddel("Acetylsalicylsyre", 0.5,
                1.0, 2.0, "Styk");

        // Act
        double TC1 = controller.anbefaletDosisPrDoegn(patient1,laegemiddel);
        double TC2 = controller.anbefaletDosisPrDoegn(patient2,laegemiddel);
        double TC3 = controller.anbefaletDosisPrDoegn(patient3,laegemiddel);
        double TC4 = controller.anbefaletDosisPrDoegn(patient4,laegemiddel);

        // Assert
        assertEquals(12, TC1);
        assertEquals(26, TC2);
        assertEquals(250, TC3);
        assertEquals(-5, TC4);

    }

    @Test
    void anvendtPNOrdination(){
        //Arrange
        Patient patient1 = new Patient("121256-0512", "Jane Jensen", 24);
        Laegemiddel l1 = new Laegemiddel("Testmiddel", 1,1,1,"Styk");
        PN o1 = new PN(LocalDate.of(2010, 01,01), LocalDate.of(2010,01,10), patient1, l1, 1);
        //Act/Assert
        assertTrue(controller.ordinationPNAnvendt(o1, LocalDate.of(2010,01,01)));
        assertTrue(controller.ordinationPNAnvendt(o1, LocalDate.of(2010,01,10)));
        Exception ex  = assertThrows(IllegalArgumentException.class, () -> {controller.ordinationPNAnvendt(o1, LocalDate.of(2009,12,31));});
        assertEquals("Forkert dato.", ex.getMessage());
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> {controller.ordinationPNAnvendt(o1, LocalDate.of(2010,01,10));});
        assertEquals("Forkert dato.", ex.getMessage());
    }


}