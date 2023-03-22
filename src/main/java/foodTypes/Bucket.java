/**
 * 
 */
package foodTypes;

import java.util.ArrayList;

import Food.Food;
import Food.Ingredients;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Zen Nkabinde
 *
 */
public class Bucket extends Food {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Name = "Bucket Feast";
	private String Price ;
	private transient ImageView bucketImage;
	private ArrayList<Ingredients> ingred;
	/**
	 * KFC Bucket constructor
	 */
	public Bucket() {
		bucketImage = new ImageView( new Image("file:src/main/java/Images/21-Piece-Bucket.jpg"));
			this.Price = "R159.99";
			AddIngredients();
		
	}
	private void AddIngredients() {
		ingred = new ArrayList<Ingredients>();
		for(int i = 0;i < 40;i++) {
			ingred.add(Ingredients.chicken_Pieces);
			
		}
	}

	@Override
	public ImageView getImage() {
		// TODO Auto-generated method stub
		return bucketImage;
	}

	@Override
	public String getPrice() {
		// TODO Auto-generated method stub
		return Price;
	}

	@Override
	public void setPrice(String price) {
		this.Price = price;

	}

	@Override
	public String getFoodName() {
		// TODO Auto-generated method stub
		return Name;
	}

	public String toString() {
		return getFoodName()+"\r\n"+getPrice();
	}
	@Override
	public void AddIngredients(Ingredients Sides) {

	}

}
