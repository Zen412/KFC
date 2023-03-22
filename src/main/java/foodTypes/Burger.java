package foodTypes;

import java.util.ArrayList;

import Food.Food;
import Food.Ingredients;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Burger extends Food {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum BurgerType{
		_single,
		_double,
		_triple,
		singleCheese,
		doubleCheese,
		tripleCheese,

	}
	private String Price;
	private String BurgerName;
	private transient ImageView BurgerImage;
	private ArrayList<Ingredients> ingred;
	public Burger(BurgerType Btype) {
		ingred = new ArrayList<Ingredients>();
		switch(Btype) {
		case _single:{
			this.Price = "R29.90";
			BurgerName = "Single chicken Burger";
			AddIngredients(Ingredients.Burgers_Rolls,Ingredients.Chicken_Breasts,Ingredients.Lettice,Ingredients.Onions,Ingredients.Tomatoes);
			BurgerImage = new ImageView( new Image("file:src/main/java/Images/single.jpg"));
		}
		break;
		case _double:{
			this.Price = "R45.90";
			BurgerName = "Double Chicken Burger";
			AddIngredients(Ingredients.Burgers_Rolls,Ingredients.Chicken_Breasts,Ingredients.Chicken_Breasts,
					Ingredients.Lettice,Ingredients.Tomatoes,Ingredients.Onions);
			BurgerImage = new ImageView(new Image("file:src/main/java/Images/doble.jpg"));
		}
		break;
		case _triple:{
			this.Price = "R59.90";
			BurgerName = " Triple Chicken Burger";
			AddIngredients(Ingredients.Burgers_Rolls,Ingredients.Chicken_Breasts,Ingredients.Chicken_Breasts,
					Ingredients.Lettice,Ingredients.Tomatoes,Ingredients.Onions,Ingredients.Chicken_Breasts);
			BurgerImage = new ImageView(new Image("file:src/main/java/Images/triple.jpg"));
		}
		break;
		case singleCheese:{
			this.Price = "R35.90";
			BurgerName = " Single Cheese Burger";
			AddIngredients(Ingredients.Burgers_Rolls,Ingredients.Chicken_Breasts,
					Ingredients.Lettice,Ingredients.Tomatoes,Ingredients.Onions,Ingredients.Cheese);
			BurgerImage = new ImageView(new Image("file:src/main/java/Images/singleCheese.jpg"));
		}
		break;
		case doubleCheese:{
			this.Price = "R54.90";
			BurgerName = "Double Cheese Burger";
			AddIngredients(Ingredients.Burgers_Rolls,Ingredients.Chicken_Breasts,Ingredients.Chicken_Breasts,
					Ingredients.Lettice,Ingredients.Tomatoes,Ingredients.Onions,Ingredients.Cheese,Ingredients.Cheese);
			BurgerImage = new ImageView(new Image("file:src/main/java/Images/doubleCheese.png"));
		}
		break;
		case tripleCheese:{
			this.Price = "R65.90";
			BurgerName = "Triple Cheese Burger";
			AddIngredients(Ingredients.Burgers_Rolls,Ingredients.Chicken_Breasts,Ingredients.Chicken_Breasts,
					Ingredients.Lettice,Ingredients.Tomatoes,Ingredients.Onions,Ingredients.Cheese,Ingredients.Cheese,
					Ingredients.Chicken_Breasts,Ingredients.Cheese);
			BurgerImage = new ImageView(new Image("file:src/main/java/Images/tripleCheese.jpg"));
		}
		break;
		}

	}


	@Override
	public ImageView getImage() {
		return this.BurgerImage;
	}

	@Override
	public String getPrice() {

		return this.Price;
	}

	@Override
	public void setPrice(String price) {
		this.Price = price;

	}

	@Override
	public String getFoodName() {
		return this.BurgerName;
	}

	@Override
	public void AddIngredients(Ingredients Sides) {
		ingred.add(Sides);

	}
	@Override
	public String toString() {
		return getFoodName() +"\r\n"+ getPrice() ;
	}
	private void AddIngredients(Ingredients... sides) {
		for(Ingredients s: sides) {
			ingred.add(s);
		}
	}

}
