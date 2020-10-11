package bank;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Withdraw implements EventHandler<ActionEvent>{
	
	Label l;
	TextField t;
	Button b;
	Stage window;
	int x;
	
	public void layout(){
		
		l = new  Label("Please enter an amount: ");
		
		t = new TextField();
		
		b = new Button("OK");
		b.setOnAction(this);
		
		VBox v = new VBox();
		v.setPadding(new Insets(10,10,10,10));
		v.setSpacing(15);
		v.getChildren().addAll(l,t,b);
		
		window = new Stage();
		window.setTitle("");
		Scene s = new Scene(v, 400,150);
		window.setScene(s);
		window.show();
		read();
	}
	String a;
	public void read(){
		try{
			File file = new File("deposit.txt");
			Scanner input = new Scanner(file);
			while(input.hasNextLine()){
				a = input.nextLine();
			}
			x = Integer.parseInt(a);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void handle(ActionEvent event){
		if(event.getSource() == b){
			String l = t.getText();
			int d = Integer.parseInt(l);
			if(d < x){
				try{
					String s = t.getText();
					File file = new File("withdraw.txt");
					FileWriter fw = new FileWriter(file);
					fw.write(s);
					fw.write("\n");
					write(d, x);
					System.out.println("Withdrawal successful");
					fw.close();
					window.close();
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			else{
				System.out.println("Not enough balance");
			}
	
		}
	}
	public void write(int k, int u){
		try{
			int e = u-k;
			String h = Integer.toString(e);
			File file = new File("deposit.txt");
			FileWriter fw = new FileWriter(file);
			fw.write(h);
			fw.write("\n");
			fw.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}