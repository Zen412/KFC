package clientServer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import order.Order;

/**
 *
 * @author zakes
 *	This class serves as the end point where the orders will be sent and stored to file or to a database
 */
public class Server {

    public static void main(String[] args) {

        try (// create a server socket
		ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is listening on port 1234...");

            while (true) {
                // wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Main connected!");

                // create a new thread to handle the client
                Thread t = new ClientHandler(clientSocket);
                t.start();
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
		public void run() {
            try{
            	ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
        		ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

                Order o = (Order)in.readObject();
                if(o != null) {
                   	StoreData(o);
                   	System.out.println(o.getTotal());
                   	out.writeObject("This is what you wanted");
                  }

            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
    private static void StoreData(Order o) throws FileNotFoundException, IOException{
        ObjectOutputStream objs = new ObjectOutputStream(new FileOutputStream("Orders.dat", true));
        objs.writeObject(o);
        objs.flush();
        objs.close();
    }
    

}
