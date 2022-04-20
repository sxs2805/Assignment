package edu.ncsu.csc326.coffeemaker.testdir;

import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RecipeTest  {

    private Recipe recipe;
    private Recipe recipe2;
    private Assertions a;

    @BeforeEach
    void setUp() throws RecipeException {
        recipe = new Recipe();
        recipe.setAmtChocolate("5");
        recipe.setAmtCoffee("10");
        recipe.setAmtMilk("8");
        recipe.setAmtSugar("7");
        recipe.setName("name");
        recipe.setPrice("50");

        recipe2 = new Recipe();
        recipe2.setAmtChocolate("5");
        recipe2.setAmtCoffee("10");
        recipe2.setAmtMilk("8");
        recipe2.setAmtSugar("7");
        recipe2.setName("name");
        recipe2.setPrice("50");
    }

    @Test
    void testGetAmtChocolatePositiveInt(){
        Assertions.assertEquals(5,recipe.getAmtChocolate());
    }

    @Test
    void testSetAmtChocolate() throws RecipeException {
            recipe.setAmtChocolate("12");
    }

    @Test
    void testGetAmtCoffee(){
        Assertions.assertEquals(10,recipe.getAmtCoffee());
    }

    @Test
    void testSetAmtCoffee() throws RecipeException {
            recipe.setAmtCoffee("17");
    }

    @Test
    void testGetAmtMilk(){
        Assertions.assertEquals(8,recipe.getAmtMilk());
    }

    @Test
    void testSetAmtMilk() throws RecipeException {
        recipe.setAmtMilk("9");
    }

    @Test
    void testGetAmtSugar(){
        Assertions.assertEquals(7,recipe.getAmtSugar());
    }

    @Test
    void testSetAmtSugar()  throws RecipeException {
            recipe.setAmtSugar("11");

    }


    @Test
    void testGetName(){
        Assertions.assertEquals("name",recipe.getName());
    }

    @Test
    void testSetName(){
        recipe.setName("New");
        Assertions.assertEquals("New",recipe.getName());
    }

    @Test
    void testSetNameNull(){
        recipe.setName(null);
    }

    @Test
    void testGetPrice(){
        Assertions.assertEquals(50,recipe.getPrice());
    }

    @Test
    void testSetPrice()  throws RecipeException {
        recipe.setPrice("55");
    }

    @Test
    void testToString(){
        Assertions.assertEquals(recipe.getName(),recipe.toString());
    }

    @Test
    void testEqualsValid() throws RecipeException {

        Recipe recipe3 = new Recipe();
        recipe3.setAmtChocolate("5");
        recipe3.setAmtCoffee("10");
        recipe3.setAmtMilk("8");
        recipe3.setAmtSugar("7");
        recipe3.setName("name");
        recipe3.setPrice("50");
        Assertions.assertEquals(recipe, recipe3);

        recipe2 = recipe;
        Assertions.assertEquals(recipe, recipe2);
    }

    @Test
    void testEqualsNull(){
        recipe2 = null;
        Assertions.assertFalse(recipe.equals(recipe2));
    }

    @Test
    void testEqualsReturnFalse(){
        recipe2.setName("new name");
        Assertions.assertFalse(recipe.equals(recipe2));
    }


    @Test
    void testEqualsGetClass() {

        Inventory inv = new Inventory();
        Assertions.assertFalse(recipe.equals(inv));
    }

}
