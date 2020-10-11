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

public class SignUp implements EventHandler<ActionEvent>{
     
    Button Click1,Click2;
    Scene scene1,scene2;
	TextField t1;
	TextField t2;
	TextField t3;
	TextField t4;
	TextField t5;


	
	Label label1;
	Label label2;
	Label label3;
	Label label4;
	Label label5;
	Label label6;
	
	Stage window;
	
	
	Label lblMessage;
	
	private String name;
	private String userName;
	private String password;
	
	public void signup(){
		
		window = new Stage();
		window.setTitle("Sign Up Window");
		
		Click1=new Button("  Submit  ");
		Click1.setOnAction(this);
		Click1.setTextFill(Color.ORANGERED);
		
		
		 Click2 = new Button("You have signed successfully");
		 Click2.setTextFill(Color.ORANGERED);
		 
		
		Text scenetitle = new Text(" Sign Up ");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		scenetitle.setFill(Color.BLUE);
		
		label1=new Label("Full Name:");
		label1.setTextFill(Color.WHITE);
		t1=new TextField();		
		label2 = new Label("User Name:");
		label2.setTextFill(Color.WHITE);
		t2=new TextField();
		label3 = new Label("Type Password:");
		label3.setTextFill(Color.WHITE);
		t3=new TextField();
		label4 = new Label("Retype Password:");
		label4.setTextFill(Color.WHITE);
		t4=new TextField();
		lblMessage = new Label();
		
		
		VBox hb = new VBox();
		hb.getChildren().addAll(label1, t1);
		hb.setSpacing(10);
		hb.getChildren().addAll(label2, t2);
		hb.setSpacing(10);
		hb.getChildren().addAll(label3, t3);
		hb.setSpacing(10);
		hb.getChildren().addAll(label4, t4);
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
		grid.add(label3,0,3);
		grid.add(t3,1,3);
		grid.add(label4,0,4);
		grid.add(t4,1,4);
		grid.add(Click1,2,5);
		grid.add(scenetitle, 1, 0, 2, 1);
		grid.setStyle("-fx-background-color: linear-gradient(gray,DimGrey )");
		grid.add(lblMessage, 1, 2);
        
		StackPane layout2 = new StackPane();
        layout2.getChildren().add(Click2);
        scene2 = new Scene(layout2, 600, 300);
		
		
		scene1=new Scene(grid,600,300,Color.BLACK);
		
		
		window.setScene(scene1);
		window.show();	
		//read();
	}
	
	public void handle(ActionEvent event){
		name = t1.getText();
		userName = t2.getText();
		password = t3.getText();
		try{
			File file = new File("Record1.txt");
			FileWriter fw = new FileWriter(file);
			fw.write(name);
			fw.write("\n");
			fw.write(userName);
			fw.write("\n");
			fw.write(password);
			fw.write("\n");
			fw.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		window.close();
	}
	
	/*public void read(){
		try{
			File file = new File("Record.txt");
			Scanner output = new Scanner(file);
			m = new Member[50];
			int i = 0 ;
			while(output.hasNextLine()){
				String a = output.nextLine();
				String b = output.nextLine();
				String c = output.nextLine();
				m[i] = new Member(a,b,c);
				i++;
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public void write(){
		try{
			File file = new File("Record.txt");
			FileWriter fw = new FileWriter(file);
			for(int i = 0; i < m.length; i++){
				if(m[i] != null){
					fw.write(m[i].getName());
					fw.write("\n");
					fw.write(m[i].getUserName());
					fw.write("\n");
					fw.write(m[i].getPassword());
					fw.write("\n");
				}
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void addMember(){
		int index = 0;
		for(int i = 0; i < m.length; i++){
			if(m[i] == null){
				index = i;
				break;
			}
		}
		String a = t1.getText();
		String b = t2.getText();
		String c = t3.getText();
		m[index] = new Member(a,b,c);
	}
	public void handle(ActionEvent event) {
		try{
			if(t3.getText().equals(t4.getText())){
				addMember();
				write();
				window.close();
			}
			else{
				System.out.println("Password doesn't match");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}*/
	
}


	