package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    private Bun bun;

    @Before
    public void createBun() {
        bun = new Bun("Краторная булка N-200i", 1255);
    }

    @Test
    public void getNameReturnNameBun() {
        String actualBunName = bun.getName();
        String expectedBunName = "Краторная булка N-200i";
        assertEquals("Названия булки не совпадают", expectedBunName, actualBunName);
    }

    @Test
    public void getPriceReturnPriceBun() {
        float actualBunPrice = bun.getPrice();
        float expectedBunPrice = 1255;
        assertEquals("Цена булок разная", expectedBunPrice, actualBunPrice, 0);
    }
}