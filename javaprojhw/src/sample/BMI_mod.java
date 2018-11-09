package sample;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class BMI_mod {
    public double[] unit_converter(boolean wflag,boolean hflag,String wtf,String htf)
    {
        double weight=Float.parseFloat(wtf),height=Float.parseFloat(htf);
        double[] results=new double[2];
        if(wflag)
            weight = Float.parseFloat(wtf)/2.2;
        if(hflag)
            height = Float.parseFloat(htf)/3.28;
        results[0]=weight;
        results[1]=height;
        return results;
    }
    public double BMI_CALC(String w_tag ,String h_tag,String wtf,String htf)
    {   double[] res;
        boolean wflag=false,hflag=false;
        if(w_tag=="lbs")
            wflag=true;
        if(h_tag=="ft")
            hflag=true;
        res=unit_converter(wflag,hflag,wtf,htf);
        return (res[0]/res[1])/res[1];
    }
    public void calculate(Stage primaryStage,Scene main_menu)
    {
        ChoiceBox<String> wunits=new ChoiceBox<>();
        ChoiceBox<String> hunits=new ChoiceBox<>();
        wunits.getItems().addAll("kg","lbs");
        wunits.setValue("kg");
        hunits.getItems().addAll("m","ft");
        hunits.setValue("m");
        TextField weight =new TextField("");
        TextField height = new TextField("");
        TextField BMI=new TextField("");
        weight.setPromptText("weight(in kgs)");
        height.setPromptText("height (in meters)");
        BMI.setPromptText("BMI");
        BMI.setDisable(true);
        Button calculate,b2;
        calculate=new Button("calculate ");
        calculate.setOnAction(event->{
            double bmi;
            try{
                bmi=BMI_CALC(wunits.getValue(),hunits.getValue(),weight.getText(),height.getText());
                BMI.setText(Double.toString(bmi));
            }catch(Exception e)
            {
                formatWarn.format_warn();
            }
        });

        b2=new Button("<<back");
        b2.setOnAction(event ->{
            BMI.setText("");
            height.setText("");
            weight.setText("");
            primaryStage.setScene(main_menu);
        });
        GridPane l2=new GridPane();
        l2.setPadding(new Insets(20,20,20,20));
        l2.getStylesheets().addAll(this.getClass().getResource("theme.css").toExternalForm());
        l2.setVgap(10);
        l2.getChildren().addAll(weight,height,b2,calculate,BMI,wunits,hunits);
        GridPane.setConstraints(b2,0,0);
        GridPane.setConstraints(calculate,3,4);
        GridPane.setConstraints(weight,3,0);
        GridPane.setConstraints(wunits,4,0);
        GridPane.setConstraints(height,3,1);
        GridPane.setConstraints(hunits,4,1);
        GridPane.setConstraints(BMI,3,2);
        l2.setAlignment(Pos.CENTER);
        Scene Bmi_menu;
        Bmi_menu=new Scene(l2,400,400);
        primaryStage.setScene(Bmi_menu);
        primaryStage.show();
    }
}
