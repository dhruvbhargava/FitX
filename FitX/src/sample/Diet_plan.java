package sample;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class Diet_plan {
    public static void Calorie_calculator(Stage window,Scene main_menu)
    {
        ComboBox<String> qty=new ComboBox<>();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("fats", 25),
                new PieChart.Data("protiens", 25),
                new PieChart.Data("carbs", 25));
        PieChart chart=new PieChart(pieChartData);
        chart.setLabelsVisible(true);
        chart.setMaxSize(250.0d,150.0d);

        TextField stat1,stat2,stat3,stat4;
        Label  S1,S2,S3,S4;

        stat1=new TextField("0.0");
        stat1.setMaxWidth(50.d);
        stat1.setDisable(true);

        stat2=new TextField("0.0");
        stat2.setMaxWidth(50.d);
        stat2.setDisable(true);

        stat3=new TextField("0.0");
        stat3.setMaxWidth(50.d);
        stat3.setDisable(true);

        stat4=new TextField("0.0");
        stat4.setMaxWidth(50.d);
        stat4.setDisable(true);

        S1=new Label("fat (g)");
        S2=new Label("protien(g)");
        S3=new Label("carbs(g)");
        S4=new Label("cals(g)");
//        ObservableList<String> opt=new ObservableList<>();

        qty.getItems().addAll("0","1","2");
       // qty.setEditable(true);
        qty.setPromptText("qty.");
        ListView<String> food_list=new ListView<>();
        food_list.setMaxWidth(120.0d);
        food_list.onMouseClickedProperty().set(e->{
            try {
                float[] macros=dbms.food_Vals(food_list.getSelectionModel().getSelectedItem());
                stat1.setText(Float.toString(macros[0]));
                stat2.setText(Float.toString(macros[1]));
                stat3.setText(Float.toString(macros[2]));
                stat4.setText(Float.toString(macros[3]));
                qty.setPromptText("qty.");
            }catch(Exception E){System.out.println(E);}
        });
        //labels
        Label qty_=new Label("qty.");
        Label fats=new Label("total fats (gm):");
        Label protien=new Label("total protien (gm):");
        Label carbs=new Label("total carbs (gm):");
        Label cals=new Label("total cals (kJ):");
        //values
        TextField FATS=new TextField("0");
        TextField PROTIEN=new TextField("0");
        TextField CARBS=new TextField("0");
        TextField CALS=new TextField("0");
        //making tfs read only
        FATS.setMaxWidth(50.0d);
        PROTIEN.setMaxWidth(50.0d);
        CARBS.setMaxWidth(50.0d);
        CALS.setMaxWidth(50.0d);

        FATS.setDisable(true);
        PROTIEN.setDisable(true);
        CARBS.setDisable(true);
        CALS.setDisable(true);

        food_list.getItems().addAll("roti","rice","BoiledChicken","oatmeal");
        food_list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        Button add=new Button("+");
        Button sub=new Button("-");
        sub.setOnAction(event->{
            try{
                float[] macros=dbms.food_Vals(food_list.getSelectionModel().getSelectedItem());
                macros[0]=Float.parseFloat(FATS.getText())-macros[0];
                macros[1]=Float.parseFloat(PROTIEN.getText())-macros[1];
                macros[2]=Float.parseFloat(CARBS.getText())-macros[2];
                macros[3]=Float.parseFloat(CALS.getText())-macros[3];
                //setting vals
                FATS.setText(Float.toString(macros[0]));
                PROTIEN.setText(Float.toString(macros[1]));
                CARBS.setText(Float.toString(macros[2]));
                CALS.setText(Float.toString(macros[3]));

            }catch(Exception e){System.out.println(e);}
        });
        Button back=new Button("<<back");
        back.setOnAction(event->
        {
            window.setScene(main_menu);
        });
        add.setOnAction(event-> {
            try{
                float[] macros=dbms.food_Vals(food_list.getSelectionModel().getSelectedItem());
                int mux;
                mux=Integer.parseInt(qty.getValue());

                for(int i=0;i<macros.length;i++)
                {
                    macros[i]*=mux;
                }
                macros[0]+=Float.parseFloat(FATS.getText());
                macros[1]+=Float.parseFloat(PROTIEN.getText());
                macros[2]+=Float.parseFloat(CARBS.getText());
                macros[3]+=Float.parseFloat(CALS.getText());
                float sum=0.0f;
                for(float i :macros)
                {
                    if(i!=macros[3])
                        sum+=i;
                }


                ObservableList<PieChart.Data> pieChartData1 = FXCollections.observableArrayList(
                        new PieChart.Data("fats", macros[0]/sum),
                        new PieChart.Data("protien",macros[1]/sum),
                        new PieChart.Data("carbs", macros[2]/sum));
                chart.setData(pieChartData1);
                chart.setLabelsVisible(true);
                //setting vals
                FATS.setText(Float.toString(macros[0]));
                PROTIEN.setText(Float.toString(macros[1]));
                CARBS.setText(Float.toString(macros[2]));
                CALS.setText(Float.toString(macros[3]));

            }catch(Exception e){System.out.println(e);}
        });
     GridPane gp=new GridPane();
     gp.getChildren().addAll(back,add,fats,protien,carbs,cals,FATS,PROTIEN,CARBS,CALS,food_list,qty,stat1,stat2,stat3,stat4,S1,S2,S3,S4,sub,chart);

     GridPane.setConstraints(food_list,0,0);
     GridPane.setConstraints(qty,0,1);
    GridPane.setConstraints(chart,2,0);
     GridPane.setConstraints(stat1,1,3);
     GridPane.setConstraints(stat2,1,4);
     GridPane.setConstraints(stat3,1,5);
     GridPane.setConstraints(stat4,1,6);
     GridPane.setConstraints(S1,0,3);
     GridPane.setConstraints(S2,0,4);
     GridPane.setConstraints(S3,0,5);
     GridPane.setConstraints(S4,0,6);

     GridPane.setConstraints(add,0,2);
     GridPane.setConstraints(sub,1,2);
     //labels
     GridPane.setConstraints(fats,2,3);
     GridPane.setConstraints(protien,2,4);
     GridPane.setConstraints(carbs,2,5);
     GridPane.setConstraints(cals,2,6);
     //tfs
     GridPane.setConstraints(FATS,3,3);
     GridPane.setConstraints(PROTIEN,3,4);
     GridPane.setConstraints(CARBS,3,5);
     GridPane.setConstraints(CALS,3,6);
     //back pos
     GridPane.setConstraints(back,0,7);
     gp.setPadding(new Insets(20,20,20,20));
     gp.setHgap(1);
     gp.getStylesheets().add("./themes/theme.css");
     Scene cc=new Scene(gp,600,400);
     window.setScene(cc);
     window.show();

    }


}
