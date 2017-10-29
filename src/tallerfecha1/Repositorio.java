package tallerfecha1;

import co.edu.unicundinamarca.database.DBManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Repositorio {
	
    private static DBManager database = new DBManager();
      static Statement sentencia;
      static ResultSet resultado;
    public static void crear (Persona persona) {
        
        try {
            String query = "INSERT INTO registro (cedula, nombre,apellido, fechanac, edad, tipo, fecharegistro) VALUES (?, ?, ?, ?, ?, ?, ?);";
            //Colocar esos interrogantes l
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setInt(1, persona.getCedula());
            sentenciaP.setString(2, persona.getNombre());
            sentenciaP.setString(3, persona.getApellido());
            sentenciaP.setDate(4, persona.getFechanac());
            sentenciaP.setInt(5, persona.getEdad());
            sentenciaP.setString(6, persona.getTipo());
            sentenciaP.setTimestamp(7, persona.getFecharegistro());
            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public static ArrayList<String> llenar_combo(){
        ArrayList<String> lista = new ArrayList<String>();
        try {
             String query = "SELECT * FROM registro WHERE tipo = 'RECREADOR';";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();
            while(resultado.next()){
                String var=Integer.toString(resultado.getInt("id"));
                lista.add(var+"-"+resultado.getString("nombre")+" "+resultado.getString("apellido"));
            }
             sentenciaP.close();
             database.close();
             return lista;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
}


