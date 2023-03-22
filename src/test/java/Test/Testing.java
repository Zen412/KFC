package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import order.Order;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("Orders.dat");
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			Order order = (Order)in.readObject();
			System.out.println(order.getTotal());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
