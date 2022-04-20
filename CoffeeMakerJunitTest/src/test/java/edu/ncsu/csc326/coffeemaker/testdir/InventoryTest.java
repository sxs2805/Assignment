package edu.ncsu.csc326.coffeemaker.testdir;

import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InventoryTest {

	private Inventory i;
	private Assertions a;
	private int randNum = -1;
	private Recipe r;


	@BeforeEach
	void setUp() throws RecipeException {
		randNum = 1 + (int) Math.abs(Math.random()*99);
		i = new Inventory();

		r = new Recipe();
		r.setAmtChocolate("10");
		r.setAmtCoffee("10");
		r.setAmtMilk("10");
		r.setAmtSugar("10");

	}

	@AfterEach
	void tearDown() {

	}


	@Test
	void getChocolate() {
		Assertions.assertEquals(15, i.getChocolate());
	}


	@Test
	void setChocolate() {
		i.setChocolate(randNum);
		Assertions.assertEquals(randNum, i.getChocolate());
	}


	@Test
	void addChocolate() throws InventoryException {
			int initial = i.getChocolate();
			i.addChocolate(randNum + "");

	}

	@Test
	void getCoffee() {
		Assertions.assertEquals(15, i.getCoffee());
	}


	@Test
	void setCoffee() {
		i.setCoffee(randNum);
		Assertions.assertEquals(randNum, i.getCoffee());
	}

	@Test
	void addCoffee() throws InventoryException {

			int initial = i.getCoffee();
			i.addCoffee(randNum + "");

	}

	@Test
	void getMilk() {
		Assertions.assertEquals(15, i.getMilk());
	}

	@Test
	void setMilk() {
		i.setMilk(randNum);
		Assertions.assertEquals(randNum, i.getMilk());
	}

	@Test
	void addMilk() throws InventoryException {
			int initial = i.getMilk();
			i.addMilk(randNum + "");

	}



	@Test
	void getSugar() {
		Assertions.assertEquals(15, i.getSugar());
	}

	@Test
	void setSugar() {
		i.setSugar(randNum);
		Assertions.assertEquals(randNum, i.getSugar());
	}

	@Test
	void addSugar() throws InventoryException {
			int initial = i.getSugar();
			i.addSugar(randNum + "");
	}

	@Test
	void enoughIngredients() throws RecipeException {

		Assertions.assertTrue(i.enoughIngredients(r));

		r.setAmtChocolate("16");
		Assertions.assertFalse(i.enoughIngredients(r));

		r.setAmtChocolate("15");
		r.setAmtCoffee("16");
		Assertions.assertFalse(i.enoughIngredients(r));

		r.setAmtCoffee("15");
		r.setAmtMilk("16");
		Assertions.assertFalse(i.enoughIngredients(r));

		r.setAmtMilk("15");
		r.setAmtSugar("16");
		Assertions.assertFalse(i.enoughIngredients(r));
	}

	@Test
	void useIngredients() {
		Assertions.assertTrue(i.useIngredients(r));
		Assertions.assertEquals(5, i.getChocolate());
		Assertions.assertEquals(5, i.getCoffee());
		Assertions.assertEquals(5, i.getMilk());
		Assertions.assertEquals(5, i.getSugar());

		Assertions.assertFalse(i.useIngredients(r));
	}

	@Test
	void testToString() {
		Assertions.assertEquals("Coffee: 15\n" +
				"Milk: 15\n" +
				"Sugar: 15\n" +
				"Chocolate: 15\n", i.toString());
	}

}
