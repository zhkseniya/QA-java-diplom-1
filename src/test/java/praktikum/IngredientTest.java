package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void createBun() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15);
    }

    @Test
    public void getPriceReturnPriceIngredient() {
        float actualIngredientPrice = ingredient.getPrice();
        float expectedIngredientPrice = 15;
        assertEquals("Цена ингредиента не совпадает с ожидаемым", expectedIngredientPrice, actualIngredientPrice, 0);
    }

    @Test
    public void getNameReturnNameIngredient() {
        String actualIngredientName = ingredient.getName();
        String expectedIngredientName = "Соус традиционный галактический";
        assertEquals("Название ингредиента не совпадает с ожидаемым", expectedIngredientName, actualIngredientName);
    }

    @Test
    public void getTypeReturnTypeIngredient() {
        IngredientType actualIngredientType = ingredient.getType();
        IngredientType expectedIngredientType = IngredientType.SAUCE;
        assertEquals("Название ингредиента не совпадает с ожидаемым", expectedIngredientType, actualIngredientType);
    }
}