package smoothiemaker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Solution exercise 3
 */
public class SmoothieBar3Test {

    private SmoothieBar smoothieBar;

    @BeforeEach
    void setUp() {
        smoothieBar = new SmoothieBar();
    }

    @Test
    public void canBlendOrangeAndAppleSmoothie() {
        smoothieBar.restockApples(2);
        smoothieBar.restockOranges(2);
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
        assertSame(smoothie.getKind(), SmoothieKind.OrangeAndAppleSmoothie);
    }

    @Test
    public void blendingOrangeAndAppleSmoothieConsumesOrangesAndApples() {
        smoothieBar.restockApples(2);
        smoothieBar.restockOranges(2);
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
        assertEquals(0, smoothieBar.getApplesInStock(), "Wrong quantities of apples");
        assertEquals(0, smoothieBar.getOrangesInStock(), "Wrong quantities of oranges");
    }

    /**
     * Denne vil teste begge selv om den første feiler
     */
    @Test
    public void blendingOrangeAndAppleSmoothieConsumesOrangesAndApplesAdvanced() {
        smoothieBar.restockApples(2);
        smoothieBar.restockOranges(2);
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
        assertAll("Wrong quantities",
                  () -> assertEquals(0, smoothieBar.getApplesInStock(), "Wrong quantities of apples"),
                  () -> assertEquals(0, smoothieBar.getOrangesInStock(), "Wrong quantities of oranges"));
    }
}