package foodTypes;

import java.util.ArrayList;

import Food.Food;
import Food.Ingredients;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Twister extends Food {
	private static final long serialVersionUID = 1L;
	private String Name = "Twister";
	private String Price = "R39.90";
	private transient ImageView image;
	private ArrayList<Ingredients> ingred;

	public Twister() {
		ingred = new ArrayList<Ingredients>();
		image = new ImageView(new Image("file:src/main/java/Images/Twister.jpg"));
		AddIngredients(Ingredients.Pastry_Roll,Ingredients.Chicken_Breasts,Ingredients.Lettice,Ingredients.Tomatoes,Ingredients.Onions,
				Ingredients.Lettice);
	}

	@Override
	public ImageView getImage() {
		return image;
	}

	@Override
	public String getPrice() {
		return Price;
	}

	@Override
	public void setPrice(String price) {
		this.Price = price;
	}

	@Override
	public String getFoodName() {
		return Name;
	}

	@Override
	public void AddIngredients(Ingredients Sides) {
		ingred.add(Sides);

	}
	public String toString() {
		return getFoodName() + "\r\n" + getPrice();
	}
	private void AddIngredients(Ingredients...ingredients ) {
		for(Ingredients i: ingredients) {
			ingred.add(i);
		}
	}

}
