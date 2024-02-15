package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentGradeTracker extends Application{
	private ArrayList<Double> grades = new ArrayList<>();
	
	private TextField gradebox;
	private Button insertGrade;
	private Button calculate;
	private Button Reset;
	private Label Entered;
	private Label result;
	private Label warning;
	private Label title;
	
	
	
	public static void main(String[] args) {
			
			launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		title = new Label("Student Grade Tracker");
		gradebox = new TextField();
		insertGrade = new Button("Insert Grade");
		calculate = new Button("Calculate");
		Reset = new Button("Reset");
		Entered = new Label("You Haven't entered any grade yet");
		result = new Label();
		warning = new Label();
		
		
		gradebox.setMaxWidth(90);
		insertGrade.setPrefWidth(200);
        calculate.setPrefWidth(200);
        Reset.setPrefWidth(200);
		
		
        title.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-alignment: center;");
        Entered.setStyle("-fx-font-size: 20px; -fx-background-color: #F2DEDE ; -fx-font-weight: bold;;-fx-text-fill:#246599 ");
        result.setStyle("-fx-font-size: 20px; -fx-background-color: #F2DEDE ; -fx-font-weight: bold;;-fx-text-fill:#246599 ");
        warning.setStyle("-fx-font-size: 20px;; -fx-font-weight: bold;;-fx-text-fill: #D74A48  ");
        //insertGrade.setStyle("-fx-background-color : #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768);-fx-background-insets: 0,1,2,3;-fx-background-radius: 3,2,2,2;-fx-padding: 12 30 12 30;-fx-text-fill: white;-fx-font-size: 20px;");
		
        
		VBox V = new VBox(20);
		V.getChildren().addAll(gradebox,insertGrade,Reset,calculate,Entered,result,warning);
		V.setAlignment(Pos.CENTER);
		V.setPadding(new Insets(150));
		
		
		BorderPane B= new BorderPane();
		B.setTop(title);
		BorderPane.setAlignment(title, Pos.CENTER);
		B.setCenter(V);
		
		
		Image bg= new Image("bg.jpg");
		BackgroundSize bgSize = new BackgroundSize(1.0, 1.0, true, true, false, false);
		BackgroundImage bg1= new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.DEFAULT, bgSize);
		B.setBackground(new Background(bg1));
		
		
		insertGrade.setOnAction(e -> addgrade());
		calculate.setOnAction(e -> calculateNeeded());
		Reset.setOnAction(e -> Resetgrades());
		
		Scene scene1 = new Scene(B,800,600);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Students Grade Tracker");
        primaryStage.setMaximized(true);
        primaryStage.show();
		
	}
	
	private void addgrade(){
		String gradeEntered = gradebox.getText();
		
		try{
			double grade1 = Double.parseDouble(gradeEntered);
			grades.add(grade1);
			gradebox.clear();
			Entered.setText("You've entered the grades "+ grades.toString());
			result.setText("");
			warning.setText("");
		} 
		catch (NumberFormatException e){
			warning.setText("This Grade can't be entered");
		}
	}
	
	private void calculateNeeded(){
		int count = grades.size();
		double sum = 0;
		double max = grades.get(0);
		double min= grades.get(0);
		
		for(int i = 0;i<count;i++){
			double x = grades.get(i);
			sum+=x;
			
			if(x<min){
				min = x;
			}
			
			if(x>max){
				max = x;
			}
			
		}
		
		double avg = sum/count;
		
		result.setText("Average: " + avg + " ,    Highest: "+max+" ,    Lowest: "+min);
	}
	
	private void Resetgrades(){
		grades.clear();
		Entered.setText("You haven't entered any grade yet");
		result.setText("");
	}
	
}
