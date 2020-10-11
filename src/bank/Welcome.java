package bank;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Welcome extends Application implements EventHandler<ActionEvent>{
	
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	//static Button b;
	GridPane grid;
	//static Label label;
	

	/*public static void display(String s){
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		label = new Label(s);
		b = new Button("Ok");
		b.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					stage.close();
				}
			}
		);
		stage.setTitle("Error");
	}*/
	
	Stage window;
	
	public void start(Stage primaryStage){
		
		window  = primaryStage;
		
		b1=new Button(" Create Account ");
		b1.setMinSize(80, 80);
		b1.setOnAction(this);
		b1.setFont(Font.font("Sonyy", FontWeight.SEMI_BOLD, 18));
		b2=new Button("Sign in");
		b2.setMinSize(80, 80);
		b2.setOnAction(this);
		b2.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 18));
		b3=new Button("About");
		b3.setMinSize(80, 80);
		b3.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 18));
		b4=new Button("Exit");
		b4.setOnAction(this);
		b4.setMinSize(80, 80);
		b4.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 18));
		b5=new Button("Loan");
		b5.setMinSize(80, 80);
		b5.setFont(Font.font("Sonyy", FontWeight.SEMI_BOLD, 18));
		
		HBox hb = new HBox();
		hb.getChildren().addAll(b1, b2);
		hb.setSpacing(10);
		hb.getChildren().addAll(b3,b4);
		hb.setSpacing(10);
		hb.getChildren().add(b5);
		//hb.getChildren().addAll(label, b);
		

		GridPane grid=new GridPane();
		grid.setPadding(new Insets(20,20,10,10));
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setVgap(20);
		
		
		Text scenetitle = new Text("Welcome To Banking Management System");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		scenetitle.setFill(Color.WHITE);
		
		grid.add(b1, 0, 2);
		grid.add(b2, 1, 2);
		grid.add(b3, 0, 3);
		grid.add(b4, 0, 4);
		grid.add(b5, 1, 3);
		grid.setAlignment(Pos.TOP_CENTER);
		grid.add(scenetitle, 0, 0, 3, 1);
		grid.setStyle("-fx-background-color: linear-gradient(Blue,DimGrey )");
		
		
		Scene scene = new Scene(grid, 1000, 600);
        window.setScene(scene);
        window.show();
     

		
	}
	public static void main(String[] args) {
		launch(args);
	}
	public void handle(ActionEvent event) {
		if(event.getSource() == b1){
			SignUp s = new SignUp();
			s.signup();
		}
		else if(event.getSource() == b2){
			LogIn l = new LogIn();
			l.login();
		}
		else if(event.getSource() == b4) window.close();
		
	}
}
     