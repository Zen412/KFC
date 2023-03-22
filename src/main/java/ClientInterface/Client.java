 package ClientInterface;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import foodTypes.Bucket;
import foodTypes.Burger;
import foodTypes.Burger.BurgerType;
import foodTypes.StreetWise;
import foodTypes.Twister;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import order.Order;

/**
* Testing the fetch command
**/
public class Client extends BorderPane{
	//orders class declaration
	private Order order;
	//base structure nodes
	private ScrollPane scrollpane;
	private GridPane gridpane;
	private GridPane innerPane;
	
	//FoodType
	private Bucket bucket;
	private Twister twister;
	private StreetWise streetwise_II,streetwise_5, streetwise_feast;
	private Burger single, _double, triple,singleCheese, doubleCheese,tripleCheese;
	
	//button, Controls, 
	private Button bucketButton,twisterButton,street2,street5,feast;
	private Button singlebt, doublebt,triplebt,triplecheesebt,doublecheesebt,singlecheesebt;
	private Button bt1, bt2, bt3, bt4,bt5, bt6, bt7, bt8, bt9, bt10, bt11;
	private Button orderButton, ClearOrder;
	private Text txt;
	private Label label;
	/////////////**************\\\\\\\\\\\\\\
	public Client() throws UnknownHostException, IOException {
		super();
		///////////Set up the Socket for the server connection\\\\\\\\\\\
		
		//
		HandleFood();
		HBox box = new HBox();
		order = new Order();
		label = new Label("Total");
		label.setLabelFor(txt);
		scrollpane = new ScrollPane();//set Center
		innerPane = new GridPane();//set inside the scroll pane
		scrollpane.setContent(innerPane);//set the inner grid into the scroll pane in order to set the contents in the right order
		innerPane.setHgap(5);//setting the spacing between nodes
		innerPane.setVgap(5);
		
		//setting the first item in the pane\\
		innerPane.add(bucket.getImage(), 0, 0);//set the food image in the first grid coordinate (0,0)
		innerPane.add(new Text(bucket.toString()), 1, 0);//set the food details in the second grid coordinates (0,1)
		innerPane.add(bucketButton, 2,0);//set the first button to the third grid coordinates (0,2)
		innerPane.add(bt1, 3, 0);
		bucketButton.setOnAction(e->{
			order.AddFood(bucket);
			String temp = "R" +  String.format("%.2f", order.getTotal());
			txt.setText(temp);
		});
		bt1.setOnAction(e->{
			order.removeFoodItem(txt, bucket);
		});
		
		//second item Twister
		innerPane.add(twister.getImage(), 0, 1);
		innerPane.add(new Text(twister.toString()), 1, 1);
		innerPane.add(twisterButton, 2, 1);
		innerPane.add(bt2, 3, 1);
		twisterButton.setOnAction(e->{
			order.AddFood(twister);
			String temp = "R" + String.format("%.2f", order.getTotal());
			txt.setText(temp);
			
		});
		bt2.setOnAction(e->{
			order.removeFoodItem(txt, twister);
		});
		
		
		//third item street wise 2
		innerPane.add(streetwise_II.getImage(), 0, 2);
		innerPane.add(new Text(streetwise_II.toString()), 1, 2);
		innerPane.add(street2, 2, 2);
		innerPane.add(bt3, 3, 2);
		street2.setOnAction(e->{
			order.AddFood(streetwise_II);
			String temp = "R" + String.format("%.2f", order.getTotal());
			txt.setText(temp);
		});
		bt3.setOnAction(e->{
			order.removeFoodItem(txt, streetwise_II);
		});
		
		//forth item street wise 5
		innerPane.add(streetwise_5.getImage(), 0, 3);
		innerPane.add(new Text(streetwise_5.toString()), 1, 3);
		innerPane.add(street5, 2, 3);
		innerPane.add(bt4, 3, 3);
		street5.setOnAction(e->{
			order.AddFood(streetwise_5);
			String temp = "R" + String.format("%.2f", order.getTotal());
			txt.setText(temp);
		});
		bt4.setOnAction(e->{
			order.removeFoodItem(txt, streetwise_5);
		});
		
		//fifth item street wise feast
		innerPane.add(streetwise_feast.getImage(), 0, 4);
		innerPane.add(new Text(streetwise_feast.toString()), 1, 4);
		innerPane.add(feast, 2, 4);
		innerPane.add(bt5, 3, 4);
		feast.setOnAction(e->{
			order.AddFood(streetwise_feast);
			String temp = "R" + String.format("%.2f", order.getTotal());
			txt.setText(temp);
		});
		bt5.setOnAction(e->{
			order.removeFoodItem(txt, streetwise_feast);
		});
		
		//sixth item single burger
		innerPane.add(single.getImage(), 0, 5);
		innerPane.add(new Text(single.toString()), 1, 5);
		innerPane.add(singlebt, 2, 5);
		innerPane.add(bt7, 3, 5);
		singlebt.setOnAction(e->{
			order.AddFood(single);
			String temp = "R" + String.format("%.2f", order.getTotal());
			txt.setText(temp);
		});
		bt7.setOnAction(e->{
			order.removeFoodItem(txt, single);
		});
		
		//seventh item double burger
		innerPane.add(_double.getImage(), 0, 6);
		innerPane.add(new Text(_double.toString()), 1, 6);
		innerPane.add(doublebt, 2, 6);
		innerPane.add(bt8, 3, 6);
		doublebt.setOnAction(e->{
			order.AddFood(_double);
			String temp = "R" + String.format("%.2f", order.getTotal());
			txt.setText(temp);
		});
		bt8.setOnAction(e->{
			order.removeFoodItem(txt, _double);
		});
		
		//eighth item triple burger
		innerPane.add(triple.getImage(), 0, 7);
		innerPane.add(new Text(triple.toString()), 1, 7);
		innerPane.add(triplebt, 2, 7);
		innerPane.add(bt9, 3, 7);
		triplebt.setOnAction(e->{
			order.AddFood(triple);
			String temp = "R" + String.format("%.2f", order.getTotal());
			txt.setText(temp);
		});
		bt9.setOnAction(e->{
			order.removeFoodItem(txt, triple);
		});
		
		//ninth item single cheese burger
		innerPane.add(singleCheese.getImage(), 0, 8);
		innerPane.add(new Text(singleCheese.toString()), 1, 8);
		innerPane.add(singlecheesebt, 2, 8);
		innerPane.add(bt10, 3, 8);
		singlecheesebt.setOnAction(e->{
			order.AddFood(singleCheese);
			String temp = "R" + String.format("%.2f", order.getTotal());
			txt.setText(temp);
		});
		bt10.setOnAction(e->{
			order.removeFoodItem(txt, singleCheese);
		});
		
		//tenth item double cheese burger
		innerPane.add(doubleCheese.getImage(), 0, 9);
		innerPane.add(new Text(doubleCheese.toString()), 1, 9);
		innerPane.add(doublecheesebt, 2, 9);
		innerPane.add(bt11, 3, 9);
		doublecheesebt.setOnAction(e->{
			order.AddFood(doubleCheese);
			String temp = "R" + String.format("%.2f", order.getTotal());
			txt.setText(temp);
		});
		bt11.setOnAction(e->{
			order.removeFoodItem(txt, doubleCheese);
		});
		
		//eleventh item triple cheese burger
		innerPane.add(tripleCheese.getImage(), 0, 10);
		innerPane.add(new Text(tripleCheese.toString()), 1, 10);
		innerPane.add(triplecheesebt, 2, 10);
		innerPane.add(bt6, 3, 10);
		triplecheesebt.setOnAction(e->{
			order.AddFood(tripleCheese);
			String temp = "R" + String.format("%.2f", order.getTotal());
			txt.setText(temp);
		});
		bt6.setOnAction(e->{
			order.removeFoodItem(txt, tripleCheese);
		});
		
		txt  = new Text("R0.0");
		gridpane = new GridPane();//set Bottom
		gridpane.add(label, 0, 0);//set a holder text in the bottom grid
		gridpane.add(txt, 0, 1);
		gridpane.add(box, 3, 1);
		
		box.getChildren().addAll(orderButton,ClearOrder);
		gridpane.setHgap(80);
		
		orderButton.setOnAction(e->{
			order.SubmitOrder();
			order = new Order();
			txt.setText("R0.0");
		});
		
		ClearOrder.setOnAction(e->{
			order = new Order();
			txt.setText("R0.0");
		});
		
		this.setCenter(scrollpane);//set the scroll pane in the center of our scene
		this.setBottom(gridpane);//set the outer grid on the bottom
		
	}
	
	private void HandleFood() {
		bucket = new Bucket();
		bucketButton = new Button("ADD");
		bt1 = new Button();
		
		twister = new Twister();
		twisterButton = new Button("ADD");
		bt2 = new Button();
		
		streetwise_II = new StreetWise(2);
		street2 = new Button("ADD");
		bt3 = new Button();
		
		streetwise_5 = new StreetWise(5);
		street5 = new Button("ADD");
		bt4 = new Button();
		
		streetwise_feast = new StreetWise(6);
		feast = new Button("ADD");
		bt5 = new Button();
		
		single = new Burger(BurgerType._single);
		singlebt = new Button("ADD");
		bt6 = new Button();
		
		_double = new Burger(BurgerType._double);
		doublebt = new Button("ADD");
		bt7 = new Button();
		
		triple = new Burger(BurgerType._triple);
		triplebt = new Button("ADD");
		bt8 = new Button();
		
		singleCheese = new Burger(BurgerType.singleCheese);
		singlecheesebt = new Button("ADD");
		bt9 = new Button();
		
		doubleCheese = new Burger(BurgerType.doubleCheese);
		doublecheesebt = new Button("ADD");
		bt10 = new Button();
		
		tripleCheese = new Burger(BurgerType.tripleCheese);
		triplecheesebt = new Button("ADD");
		bt11 = new Button();
		
		orderButton = new Button("Submit");
		orderButton.setStyle("-fx-background-color: #00FF00; ");
		
		ClearOrder = new Button("Cancel");
		ClearOrder.setStyle("-fx-background-color: #FF0000");
	}
	

}
