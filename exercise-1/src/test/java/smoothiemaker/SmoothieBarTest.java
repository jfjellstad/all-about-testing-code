package smoothiemaker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Solution exercise 1
 */
public class SmoothieBarTest {
    @Test
    public void canBlendOrangeAndAppleSmoothie() {
        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockApples(2);
        smoothieBar.restockOranges(2);
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
        assertTrue(smoothie.getKind() == SmoothieKind.OrangeAndAppleSmoothie);
    }

    @Test
    public void blendingOrangeAndAppleSmoothieConsumesOrangesAndApples() {
        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockApples(2);
        smoothieBar.restockOranges(2);
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
        assertTrue(smoothieBar.getApplesInStock() == 0);
        assertTrue(smoothieBar.getOrangesInStock() == 0);
    }
}