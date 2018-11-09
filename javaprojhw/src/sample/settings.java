package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class settings
{
    static boolean bool;
    public static void bool_set (boolean val)
    {
        bool=val;
    }
    public static boolean display()
    {   Scene Sc;

        Stage window_2=new Stage();
        window_2.initModality(Modality.APPLICATION_MODAL);
        window_2.setTitle("Warning!");
        Label l=new Label("are you sure you want to quit?");
        Button b=new Button("yes");
        Button b2=new Button("cancel");
        b.setOnAction(event -> {bool=true;
        window_2.close();});
        b2.setOnAction(event -> {bool=false;
        window_2.close();});
        GridPane layout=new GridPane();
        layout.getChildren().addAll(l,b,b2);
        layout.setPadding(new Insets(20,20,20,20));
        layout.setVgap(10);
        layout.setHgap(2);
        layout.setAlignment(Pos.CENTER);
        GridPane.setConstraints(b,3,1);
        GridPane.setConstraints(b2,4,1);
        GridPane.setConstraints(l,3,0);
        Sc =new Scene(layout,400,200);
        window_2.setScene(Sc);
        window_2.showAndWait();

        return bool;
    }


}
//#34F8EE