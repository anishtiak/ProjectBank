package bank;

import java.io.File;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Account implements EventHandler<ActionEvent>{
	
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	
	GridPane grid;
	Stage window;
	
	public void account(){
		
		window = new Stage();
		
		b1=new Button(" Deposite ");
		b1.setMinSize(50, 50);
		b1.setFont(Font.font("Sonyy", FontWeight.SEMI_BOLD, 18));
		b1.setOnAction(this);
		b2=new Button(" Check Balance ");
		b2.setMinSize(50, 50);
		b2.setOnAction(this);
		b2.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 18));
		b3=new Button(" Withdraw   ");
		b3.setMinSize(50, 50);
		b3.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 18));
		b3.setOnAction(this);
		b4=new Button(" Exit ");
		b4.setMinSize(50, 50);
		b4.setOnAction(this);
		b4.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 18));
		
		HBox hb = new HBox();
		hb.getChildren().addAll(b1, b2);
		hb.setSpacing(10);
		hb.getChildren().addAll(b3,b4);
		hb.setSpacing(10);
		

		GridPane grid=new GridPane();
		grid.setPadding(new Insets(20,20,10,10));
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setVgap(20);
		
		
		Text scenetitle = new Text("Account");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		scenetitle.setFill(Color.SKYBLUE);
		
		grid.add(b1, 0, 3);
		grid.add(b2, 1, 4);
		grid.add(b3, 2, 3);
		grid.add(b4, 2, 5);
		grid.setAlignment(Pos.TOP_CENTER);
		grid.add(scenetitle, 1, 0, 4, 2);
		grid.setStyle("-fx-background-color: linear-gradient(Gray,DimGrey )");
		
		
		Scene scene = new Scene(grid, 800, 500);
        window.setTitle("");
		window.setScene(scene);
        window.show();
     

		
	}
	String a,b;
	int z;
	public void handle(ActionEvent event) {
		
		if(event.getSource() == b1){
			Deposit d = new Deposit();
			d.layout();
		}
		else if(event.getSource() == b3){
			Withdraw d = new Withdraw();
			d.layout();
		}
		else if(event.getSource() == b4){
			window.close();
		}
		else if(event.getSource() == b2){
			try{
				//int x,y;
				//File file1 = new File("withdraw.txt");
				File file2 = new File("deposit.txt");
				//Scanner input1 = new Scanner(file1);
				Scanner input2 = new Scanner(file2);
				/*while(input1.hasNextLine()){
					a = input1.nextLine();
				}*/
				while(input2.hasNextLine()){
					b = input2.nextLine();
				}
				z = Integer.parseInt(b);
				//y = Integer.parseInt(a);
				//z = x-y;
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			balance b = new balance();
			b.layout("Your account balance is: "+z);
		}
	}
	
		
}

     

