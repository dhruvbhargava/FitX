package sample;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Diet_plan {
    public static void Calorie_calculator(Stage window,Scene main_menu)
    {
        ComboBox<Integer> qty=new ComboBox<>();
        qty.getItems().addAll(0,1,2);
        qty.setValue(0);
        ListView<String> food_list=new ListView<>();
        //labels
        Label qty_=new Label("qty.");
        Label fats=new Label("fats (gm):");
        Label protien=new Label("protien (gm):");
        Label carbs=new Label("carbs (gm):");
        Label cals=new Label("cals (kJ):");
        //values
        TextField FATS=new TextField("0");
        TextField PROTIEN=new TextField("0");
        TextField CARBS=new TextField("0");
        TextField CALS=new TextField("0");
        //making tfs read only

        FATS.setDisable(true);
        PROTIEN.setDisable(true);
        CARBS.setDisable(true);
        CALS.setDisable(true);

        food_list.getItems().addAll("roti","rice","BoiledChicken","oatmeal");
        food_list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        Button add=new Button("Add");
        Button back=new Button("<<back");
        back.setOnAction(event->
        {
            window.setScene(main_menu);
        });
        add.setOnAction(event-> {
            try{
                float[] macros=dbms.food_Vals(food_list.getSelectionModel().getSelectedItem());
                int mux;

                mux=qty.getValue();
                for(int i=0;i<macros.length;i++)
                {
                    macros[i]*=mux;
                }
                macros[0]+=Float.parseFloat(FATS.getText());
                macros[1]+=Float.parseFloat(PROTIEN.getText());
                macros[2]+=Float.parseFloat(CARBS.getText());
                macros[3]+=Float.parseFloat(CALS.getText());
                //setting vals
                FATS.setText(Float.toString(macros[0]));
                PROTIEN.setText(Float.toString(macros[1]));
                CARBS.setText(Float.toString(macros[2]));
                CALS.setText(Float.toString(macros[3]));

            }catch(Exception e){System.out.println(e);}
        });
     GridPane gp=new GridPane();
     gp.getChildren().addAll(back,add,fats,protien,carbs,cals,FATS,PROTIEN,CARBS,CALS,food_list,qty,qty_);

     GridPane.setConstraints(food_list,0,0);
     GridPane.setConstraints(qty,1,1);
     GridPane.setConstraints(qty_,1,0);

     GridPane.setConstraints(add,0,1);
     //labels
     GridPane.setConstraints(fats,0,2);
     GridPane.setConstraints(protien,0,3);
     GridPane.setConstraints(carbs,0,4);
     GridPane.setConstraints(cals,0,5);
     //tfs
     GridPane.setConstraints(FATS,1,2);
     GridPane.setConstraints(PROTIEN,1,3);
     GridPane.setConstraints(CARBS,1,4);
     GridPane.setConstraints(CALS,1,5);
     //back pos
     GridPane.setConstraints(back,0,6);
     gp.setPadding(new Insets(20,20,20,20));
     gp.setHgap(1);
     gp.getStylesheets().add("sample//theme.css");
     Scene cc=new Scene(gp,400,350);
     window.setScene(cc);
     window.show();

    }


}
