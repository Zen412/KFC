package order;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import Food.Drinks;
import Food.Food;
import javafx.scene.text.Text;

/**
 * 
 * @author Zen Nkabinde
 * This class holds the items in which the customer orders and contains some methods to obtain the total amount of the order
 */
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Food> foods; // the container that will hold the Food types in the order
	private ArrayList<Drinks> drinks; // 
	private Double Total = 0.0;
	private double DrinksPrice = 10.0;
	public Order() {
		foods = new ArrayList<Food>();
		drinks = new ArrayList<Drinks>();
	}
	public void AddFood(Food food) {
		this.foods.add(food);
		String price = food.getPrice().replaceAll("[A-Z]", "");
		Total += Double.parseDouble(price);
		
	}
	public void addDrinks(Drinks drink) {
		drinks.add(drink);
		Total += DrinksPrice;
	}
	public void Clear() {
		foods.clear();
		drinks.clear();
	}
	public double getTotal() {
		return Total;
	}
	public void removeFoodItem(Text txt, Food food) {
		if(foods.contains(food))
		{
			foods.remove(food);
			String price = food.getPrice().replaceAll("[A-Z]", "");
			Total -= Double.parseDouble(price);
			String temp = "R" +  String.format("%.2f", Total);
			txt.setText(temp);
		}	
		
	}
	public void SubmitOrder() {{

        try (Socket socket = new Socket("localhost", 1234);// connect to the server
        		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        		)
            {
        	System.out.println("Connected to server!");
        	out.writeObject(this);
        	String message = (String) in.readObject();
        	System.out.println(message);
        	

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }}
}
