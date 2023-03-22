package foodTypes;
import java.util.ArrayList;

import Food.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * 
 * @author Zen
 * a class for the StreaWise chicken meal
 */
public class StreetWise extends Food{
	private static final long serialVersionUID = 1L;
	/**
	 * class variables
	 */
	private  String Price = "R";
	private transient ImageView image;
	private String FoodName = "StreaWise";
	private ArrayList<Ingredients> ingredients;
	/**
	 * When you call the constructor you need to specify the number of piece
	 * in order to match the right meal
	 */
	public StreetWise(int numberOfPieces) {
		//ADDING THE RIGHT AMOUNT OF CHICKEN PIECES
		AddIngredients(numberOfPieces);
		if(numberOfPieces == 2) {
			//set the meal name
			FoodName = FoodName + "-II";
			
			//set the price of the meal
			Price = Price + "29.90";
			
			//set the meal image
			image =new ImageView( new Image("file:src/main/java/Images/Streetwise-II.jpg"));
			
		}else if(numberOfPieces == 5) {
			//set the meal name
			FoodName = FoodName + "-V";
			
			//set the meal price
			Price = Price + "59.99";
			
			//set the meal image
			image =new ImageView( new Image("file:src/main/java/Images/Streetwise-Five.jpg"));
			
		}else {
			//set the meal name
			FoodName = FoodName + "-Feast";
			
			//set the meal price
			Price = Price + "79.99";
			
			//set the meal image
			image =new ImageView(new Image("file:src/main/java/Images/family-feast.jpg"));
		}
		
	}
	/**
	 * adding the ingredients into the list of ingredients
	 * @param number
	 */
	private void AddIngredients(int number) {
		ingredients = new ArrayList<>();
		for(int i = 0;i <= number;i++) {
			ingredients.add(Ingredients.chicken_Pieces);
		}
	}
	@Override
	public void AddIngredients(Ingredients Sides) {
		ingredients.add(Sides);
	}
	

	@Override
	public String getPrice() {
		return Price;
	}

	@Override
	public String getFoodName() {
		return FoodName;
	}

	@Override
	public void setPrice(String price) {
		this.Price = price;
		
	}
	@Override
	public ImageView getImage() {
		return image;
	}
	public String toString() {
		return getFoodName() + "\r\n" + getPrice();
	}


}
