package bank;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;

public class LogIn implements EventHandler<ActionEvent>{
     
	  String user = "JavaFX2";
      String pw = "password";
      String checkUser, checkPw;
      
      String x;
      String y;
      String z;
      
    Button Click;
    Scene scene1,scene2,scene3;
	TextField t1;
	TextField t2;
	TextField t3;
	Label label1;
	Label label2;
	Label label3;
	Label lblMessage;
	Stage window;

	public void login() {
		window = new Stage();
		window.setTitle("Log in Window");
		
		Click=new Button("  Sign in  ");
		Click.setOnAction(this);
		Click.setTextFill(Color.ORANGERED);
		
		
		Text scenetitle = new Text(" Welcome ");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		scenetitle.setFill(Color.BLUE);
		
		
		label1 = new Label("User Name:");
		label1.setTextFill(Color.WHITE);
		t1=new TextField();
		label2 = new Label("Password:");
		label2.setTextFill(Color.WHITE);
		t2=new TextField();
		lblMessage = new Label();
		
		
		VBox hb = new VBox();
		hb.getChildren().addAll(label1, t1);
		hb.setSpacing(10);
		hb.getChildren().addAll(label2, t2);
		hb.setSpacing(10);
		hb.getChildren().add(scenetitle);
		
		
		
		GridPane grid=new GridPane();
		grid.setPadding(new Insets(20,20,10,10));
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setVgap(20);
		
		grid.add(label1,0,1);
		grid.add(t1,1,1);
		grid.add(label2,0,2);
		grid.add(t2,1,2);
		grid.add(Click,2,3);
		grid.add(scenetitle, 1, 0, 2, 1);
		grid.setStyle("-fx-background-color: linear-gradient(gray,DimGrey )");
		grid.add(lblMessage, 1, 2);

		
		
		scene1=new Scene(grid,500,250,Color.BLACK);
		
		
		grid.setId("root");
        Click.setId("btnLogin");
        scenetitle.setId("text");
		
        window.setScene(scene1);
        window.show();
		
	}
	/*public static void main(String[] args) {
		launch(args);
	}*/
	public void getData(String a, String b){
		this.x = a;
		this.y = b;
	}
	public void read(){
		try{
			File file = new File("Record1.txt");
			Scanner input = new Scanner(file);
			while(input.hasNextLine()){
				String a = input.nextLine();
				String b = input.nextLine();
				String c = input.nextLine();
				x = b;
				y = c;
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void handle(ActionEvent event) {
		read();
		if(x.equals(t1.getText()) && y.equals(t2.getText())){
			Account a = new Account();
			a.account();
			window.close();
		}
		else{
			System.out.println("Data doesn't match");
		}
		
		
		/*SignUp s = new SignUp();
		String us = s.getUserName();
		String p = s.getPassword();
		System.out.println(this.x);
		System.out.println(this.y);
		System.out.println(t1.getText());
		System.out.println(t2.getText());
		if(us.equals(t1.getText()) && p.equals(t2.getText())){
			Account a = new Account();
			a.account();
			window.close();
		}
		else{
			System.out.println("Data doesn't match");
		}*/
	}
	
}
	
	
	
	

	