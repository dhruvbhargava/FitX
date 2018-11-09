package sample;
import java.sql.*;

public class dbms {

    public static float[] food_Vals(String food)throws Exception
    {
        float[] array=new float[4];
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_profiles",
                    "hey",
                    "hey");
            String Sql_query="SELECT * FROM food_list.food_data WHERE NAME='"+food+"'";
            PreparedStatement select=con.prepareStatement(Sql_query);
            ResultSet res=select.executeQuery();
            int i=0;
            res.next();
            array[i++]=Float.parseFloat(res.getString("FATS"));
            array[i++]=Float.parseFloat(res.getString("PROTIEN"));
            array[i++]=Float.parseFloat(res.getString("CARBS"));
            array[i++]=Float.parseFloat(res.getString("CALS"));
        }
        catch(Exception e){
            System.out.println(e);
        }
        return array;
    }
}
