package bank;
import java.io.File;
import java.io.FileWriter;

import javafx.application.*;
import javafx.event.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;

public class Deposit implements EventHandler<ActionEvent>{
	
	Label l;
	TextField t;
	Button bd;
	Stage window;
	
	public void layout(){
		
		l = new  Label("Please enter an amount: ");
		
		t = new TextField();
		
		bd = new Button("OK");
		bd.setOnAction(this);
		
		VBox v = new VBox();
		v.setPadding(new Insets(10,10,10,10));
		v.setSpacing(15);
		v.getChildren().addAll(l,t,bd);
		
		window = new Stage();
		window.setTitle("");
		Scene s = new Scene(v, 400,150);
		window.setScene(s);
		window.show();
	}
	public void handle(ActionEvent event){
		if(event.getSource() == bd){
			try{
				String x = t.getText();
				File file = new File("deposit.txt");
				FileWriter fw = new FileWriter(file);
				fw.write(x);
				fw.write("\n");
				fw.close();
				window.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}
