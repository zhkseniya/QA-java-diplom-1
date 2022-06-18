package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final IngredientType expected;

    public IngredientParameterizedTest(IngredientType type, String name, float price, IngredientType expected) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getType() {
        return new Object[][] {
                { IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000, IngredientType.FILLING },
                { IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88, IngredientType.SAUCE},
        };
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Возвращается не тот тип ингредиента", expected, ingredient.getType());
    }
}
