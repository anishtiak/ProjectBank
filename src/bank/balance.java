package bank;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class balance implements EventHandler<ActionEvent>{
	
	Label l;
	Button b;
	Stage window;
	
	public void layout(String g){
	
		l = new  Label(g);
		
		b = new Button("OK");
		b.setOnAction(this);
		
		VBox v = new VBox();
		v.setPadding(new Insets(10,10,10,10));
		v.setSpacing(15);
		v.getChildren().addAll(l,b);
		
		window = new Stage();
		window.setTitle("");
		Scene s = new Scene(v, 400,150);
		window.setScene(s);
		window.show();
	}
	public void handle(ActionEvent event){
		if(event.getSource() == b){
			window.close();
		}
	}
}
