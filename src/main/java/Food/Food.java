package Food;

import java.io.Serializable;

import javafx.scene.image.ImageView;

public abstract class Food implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// set these on the constructor of the individual food type
	public abstract ImageView getImage();
	public abstract String getPrice();
	public abstract void setPrice(String price);
	public abstract String getFoodName();
	public abstract void AddIngredients(Ingredients Sides);

}
