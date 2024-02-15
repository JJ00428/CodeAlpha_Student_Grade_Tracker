package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,800,800);
			primaryStage.setScene(scene);
			primaryStage.show();
		
			
		
	}
	

}
