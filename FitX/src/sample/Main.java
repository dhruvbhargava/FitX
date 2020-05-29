package sample;


import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.WORKOUTS;

public class Main extends Application  {
Button b,diet,w;
Scene main_menu;
Label Title;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FITX");
        Title=new Label("FITX");
        Title.setId("TITLE");
        b =new Button("BMI calculator");
        w=new Button("Training programs");
        w.setOnAction(event->{
            WORKOUTS.Workouts(primaryStage,main_menu);
        });
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
        layout.getStylesheets().addAll(this.getClass().getResource("./themes/theme.css").toExternalForm());
        layout.setPadding(new Insets(20,20,20,20));
        layout.setVgap(10);
        layout.getChildren().addAll(b,diet,Title,w);
        GridPane.setConstraints(Title,3,0);
        GridPane.setConstraints(diet,3,2);
        GridPane.setConstraints(b,3,3);
        GridPane.setConstraints(w,3,4);
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
        launch(args);    }
}
