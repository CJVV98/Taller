package tallerfecha1;

import co.edu.unicundinamarca.database.DBManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

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
    public static void editar (Persona persona) {
        try {
            String query = "UPDATE registro SET cedula = ?, nombre = ?, apellido = ?, fechanac = ?, edad = ?, tipo= ?, fecharegistro = ? WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
             sentenciaP.setInt(1, persona.getCedula());
            sentenciaP.setString(2, persona.getNombre());
            sentenciaP.setString(3, persona.getApellido());
            sentenciaP.setDate(4, persona.getFechanac());
            sentenciaP.setInt(5, persona.getEdad());
            sentenciaP.setString(6, persona.getTipo());
            sentenciaP.setTimestamp(7, persona.getFecharegistro());
            sentenciaP.setInt(8, persona.getId());

            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void eliminar (Persona persona) {
        try {
            String query = "DELETE FROM registro WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, Integer.toString(persona.getId()));

            sentenciaP.execute();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Persona> obtenerTodos() {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        try {
            String query = "SELECT * FROM registro;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                //t id, int cedula, int edad, String nombre, String apellido, String tipo,Date fechanac, Timestamp fecharegistro)
                personas.add(Persona.crear(resultado.getInt("id"), resultado.getInt("cedula"), resultado.getInt("edad"), resultado.getString("nombre"), resultado.getString("apellido"), resultado.getString("tipo"), resultado.getDate("fechanac"),  resultado.getTimestamp("fecharegistro")));
            }

            sentenciaP.close();
            database.close();

            return personas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return personas;
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
    
       public static Persona buscar(String documento) {
        try {
            String query = "SELECT * FROM registro WHERE cedula = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, documento);

            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                return Persona.crear(resultado.getInt("id"), resultado.getInt("cedula"), resultado.getInt("edad"), resultado.getString("nombre"), resultado.getString("apellido"), resultado.getString("tipo"), resultado.getDate("fechanac"),  resultado.getTimestamp("fecharegistro"));
            }
            
            sentenciaP.close();
            database.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static int validarcedula(int cedula) {
         int bandera=0; 
       try {
            //aqui ese select me selecciona la tabla ese where me indica donde recreador = String recreador1 si lo encuentra
            String query = "SELECT * FROM registro WHERE cedula = '" + cedula+ "';";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);// esto es para preparar lo del mysql eso si lo copie del ejercicio anterior hast
            ResultSet resultado = sentenciaP.executeQuery();
            
            while (resultado.next()) {//aqui copie
             if (resultado.getInt("cedula")==cedula) {
                 bandera++;
             }
         }
            } catch (Exception e) {
            System.out.println(e.getMessage());
            }
       if(bandera>0){
           return 1;
       }else{
           return 0;
       }
    }
}


