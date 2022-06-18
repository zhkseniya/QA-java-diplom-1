package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Булки разные", bun, burger.bun);

    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals("Количество ингредиентов разное", 1, burger.ingredients.size());

    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Ингредиент не был удален", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000);
        Burger burger = new Burger();
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0,1);

        IngredientType actualIngredientType = burger.ingredients.get(1).type;
        IngredientType expectedType = sauce.type;

        assertEquals("Ингредиенты не перемешались", expectedType, actualIngredientType);
    }

    @Test
    public void getPriceReturnPrice() {
        Mockito.when(bun.getPrice()).thenReturn(5f);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float actualPrice = burger.getPrice();
        float expectedPrice = 12f;

        assertEquals("Цена разная", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptReturnReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Соус с шипами Антарианского плоскоходца");
        Mockito.when(burger.getPrice()).thenReturn(1255f);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== Краторная булка N-200i ====)\r\n= sauce Соус с шипами Антарианского плоскоходца =\r\n(==== Краторная булка N-200i ====)\r\n\r\nPrice: 1255,000000\r\n";
        assertEquals("Рецепты разные", expectedReceipt, actualReceipt);
    }
}