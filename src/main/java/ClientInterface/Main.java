package ClientInterface;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


public static void main(String[] args) {
	launch(args);
	

}

	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) throws Exception {
		Client client = new Client();
		Scene scene = new Scene(client,400,400);
		stage.setTitle("KFC-finger-linking-good");
		stage.setScene(scene);
		stage.show();
	}

}
