package sample;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.Window;
import javafx.scene.control.Label;

import javax.swing.text.Position;

public class WORKOUTS {



    public static void Workouts(Stage window,Scene main_menu)
    {
        Label loss,gain,maintain;
        loss=new Label("This workout is recommen");
        GridPane loss_l=new GridPane();
        loss_l.getChildren().add(loss);
        loss_l.setAlignment(Pos.CENTER);
        Scene loss_s=new Scene(loss_l,400,400);
        window.setScene(loss_s);
        window.show();


    }
}
