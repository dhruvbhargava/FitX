package sample;


import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class Main extends Application  {
Button b,diet;
Scene main_menu;



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FIT_SHIT_NIGGA");
        b =new Button("BMI calculator");
        diet=new Button("Diet plan");
        diet.setOnAction(event ->{
            Diet_plan.Calorie_calculator(primaryStage,main_menu);
        });
        b.setOnAction(event -> {

            BMI_mod BMI_obj=new BMI_mod();
            BMI_obj.calculate(primaryStage,main_menu);
        });

        GridPane layout=new GridPane();
        layout.setId("Pane");
        layout.getStylesheets().addAll(this.getClass().getResource("theme.css").toExternalForm());
        layout.setPadding(new Insets(20,20,20,20));
        layout.setVgap(10);
        layout.getChildren().addAll(b,diet);
        GridPane.setConstraints(diet,3,2);
        GridPane.setConstraints(b,3,3);
        layout.setAlignment(Pos.CENTER);

        main_menu=new Scene(layout,400,400);

        primaryStage.setScene(main_menu);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            if(settings.display())
                primaryStage.close();

        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
