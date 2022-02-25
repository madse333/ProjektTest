package controller;

import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
Controller controller;

@BeforeEach

void setup(){
    controller = Controller.getTestController();


}
    @Test
    void anbefaletDosisPrDoegn() {
        double actualResult = controller.anbefaletDosisPrDoegn(new Patient("121256-0512", "Jane Jensen", 24), new Laegemiddel("Acetylsalicylsyre", 0.5, 1.0, 2.0, "Styk"));
        assertEquals(12, actualResult, 0.0001);

        double result = controller.anbefaletDosisPrDoegn(new Patient("2712028301", "Jane jensen", 26), new Laegemiddel("Acetylsalicylsyre", 0.5, 1.0, 2.0, "Styk"));
        assertEquals(26, result, 0.0001);

        double r = controller.anbefaletDosisPrDoegn(new Patient("2712028301", "Jane jensen", 125), new Laegemiddel("Acetylsalicylsyre", 0.5, 1.0, 2.0, "Styk"));

        assertEquals(250, r, 0.0001);

        double testCase = controller.anbefaletDosisPrDoegn(new Patient("2712028301", "Jane jensen", 0), new Laegemiddel("Acetylsalicylsyre", 0.5, 1.0, 2.0, "Styk"));

        assertEquals(0, testCase, 0.0001);



    }
}