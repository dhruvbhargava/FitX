package sample;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class formatWarn {
    static Stage window= new Stage();
    public static void format_warn()
    {
        window.setTitle("warning!");
        window.initModality(Modality.APPLICATION_MODAL);
        GridPane wb=new GridPane();
        wb.setPadding(new Insets(20,20,20,20));
        wb.setVgap(10);
        wb.setHgap(10);
        Button b=new Button("ok");
        b.setOnAction(event -> window.close());
        Label l=new Label("invalid format!");
        wb.getChildren().addAll(l,b);
        wb.setAlignment(Pos.CENTER);
        GridPane.setConstraints(l,1,0);
        GridPane.setConstraints(b,1,1);
        Scene sc=new Scene(wb,200,100);
        window.setScene(sc);
        window.show();
    }
}
